package com.hui.springcloud.order.client;

import com.alibaba.fastjson.JSONObject;
import com.hui.springcloud.common.entity.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.xml.ws.Response;

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
public class ClientController {

    /**
     * The Product client.
     *
     * @since hui_project 1.0.0
     */
    @Resource
    private ProductClient productClient;

    /**
     * The Load balancer client.
     *
     * @since hui_project 1.0.0
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    /**
     * 通过具体url调用.
     *
     * @return the response entity
     * @author Hu weihui
     * @since hui_project 1.0.0
     */
    @PostMapping("/order/product")
    public ResponseEntity getProduct(Integer id){
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("data",JSONObject.toJSONString(id));
        Product product = restTemplate.postForObject("http://localhost:8080/product",paramMap, Product.class);
        return ResponseEntity.ok(product);
    }


    /**
     * 负载均衡后通过application_name远程调用
     *
     * @return the response entity
     * @author Hu weihui
     * @since hui_project 1.0.0
     */
    @PostMapping("/order/product2")
    public ResponseEntity getProduct2(Integer id){
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance instance = loadBalancerClient.choose("product-server");
        String url = String.format("http://$s:$s", instance.getHost(), instance.getPort());
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("data",JSONObject.toJSONString(id));
        Product product = restTemplate.postForObject(url, paramMap,Product.class);
        return ResponseEntity.ok(product);
    }

    /**
     * The Rest template.
     *
     * @since hui_project 1.0.0
     */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 注入@loadBalancerClient后获取.
     *
     * @return the response entity
     * @author Hu weihui
     * @since hui_project 1.0.0
     */
    @PostMapping("/order/product3")
    public ResponseEntity getProduct3(Integer id){
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("data",JSONObject.toJSONString(id));
        Product product = restTemplate.postForObject("http://product-server/product",paramMap, Product.class);
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
    @GetMapping("/order/product4")
    public ResponseEntity getProduct4(Integer id){
        Product product = productClient.getProduct(id);
        return ResponseEntity.ok(product);
    }
}
