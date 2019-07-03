package com.hui.base.springcloud.order.controller;

import com.hui.base.springcloud.common.response.ResultMapper;
import com.hui.base.springcloud.common.response.ResultVO;
import com.hui.base.springcloud.order.model.Order;
import com.hui.base.springcloud.order.service.OrderService;
import com.hui.base.springcloud.product.api.ProductFeignApi;
import dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.UUID;

/**
 * <b><code>ClientController</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/11/28 23:24.
 *
 * @author Hu Weihui
 */
@RestController
@Slf4j
public class ClientController {

    /**
     * 调用方式 1 httpClient封装的 restTemplate
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 调用方式 2 负载均衡 loadBalancerClient
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 调用方式 3 Feign
     */
    @Autowired
    private ProductFeignApi productFeignApi;

    @Autowired
    private OrderService orderService;

    /**
     * 通过具体url调用.
     *
     * @return the response entity
     * @author Hu weihui
     * @since hui_project 1.0.0
     */
    @GetMapping("/order/product/{id}")
    public ResponseEntity getProduct(@PathVariable("id") String id) {
        RestTemplate restTemplate = new RestTemplate();
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("id", id);
        ProductDTO product = restTemplate.getForObject("http://localhost:8080/mapper/{id}", ProductDTO.class, paramMap);
        return ResponseEntity.ok(product);
    }


    /**
     * 负载均衡后通过application_name远程调用
     *
     * @return the response entity
     * @author Hu weihui
     * @since hui_project 1.0.0
     */
    @GetMapping("/order/product2/{id}")
    public ResponseEntity getProduct2(@PathVariable("id") String id) {
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance instance = loadBalancerClient.choose("mapper-server");
        String url = String.format("http://%s:%s/mapper/{id}", instance.getHost(), instance.getPort());
//        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("id", id);
        ProductDTO product = restTemplate.getForObject(url, ProductDTO.class, paramMap);
        return ResponseEntity.ok(product);
    }

    /**
     * 注入@loadBalancerClient后获取.
     *
     * @return the response entity
     * @author Hu weihui
     * @since hui_project 1.0.0
     */
    @GetMapping("/order/product3/{id}")
    public ResponseEntity getProduct3(@PathVariable("id") String id) {
//        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
//        id = JSONObject.toJSONString(id);
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("id", id);
        ProductDTO product = restTemplate.getForObject("http://mapper-server/mapper/{id}", ProductDTO.class, paramMap);
        return ResponseEntity.ok(product);
    }

    /**
     * fegin获取.
     *
     * @param id the id
     * @return the response entity
     * @author Hu weihui
     * @since hui_project 1.0.0
     */
    @GetMapping("/order/product4/{id}")
    public ResultVO<ProductDTO> getProduct4(@PathVariable("id") String id) {
        ProductDTO data = productFeignApi.get(id).getData();
        log.info(data.toString());
        return ResultMapper.ok(data);
    }


    @PutMapping("/orders/addProduct")
    public ResultVO addProduct(@RequestBody Order order) {
        orderService.add(order);
        ProductDTO productDTO = new ProductDTO();
        double ceil = Math.ceil(Math.random() * 100);
        String productId = String.valueOf(ceil);
        productDTO.setProductId(productId);
        productDTO.setProductName("test");
        productFeignApi.add(productDTO);
        return ResultMapper.ok();
    }


    /**
     * 用于测试TCC模式
     * @param order
     * @param exFlag
     * @return
     */
    @PutMapping("/orders/addProduct/tcc")
    public ResultVO addProductByTcc(@RequestBody Order order, String exFlag) {
        orderService.testTCC(order, exFlag);
        return ResultMapper.ok();
    }

    /**
     * 用于测试TXC模式
     * @param order
     * @param exFlag
     * @return
     */
    @PutMapping("/orders/addProduct/txc")
    public ResultVO addProductByTxc(@RequestBody Order order, String exFlag) {
        orderService.testTXC(order, exFlag);
        return ResultMapper.ok();
    }

}
