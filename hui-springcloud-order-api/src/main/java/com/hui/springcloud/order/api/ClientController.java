package com.hui.springcloud.order.api;

import com.alibaba.fastjson.JSONObject;
import com.hui.springcloud.common.entity.product.Product;
import com.hui.springcloud.order.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.xml.ws.Response;
import java.util.HashMap;

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
    @Autowired
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
    @GetMapping("/order/product/{id}")
    public ResponseEntity getProduct(@PathVariable("id") String id){
        RestTemplate restTemplate = new RestTemplate();
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("id",id);
        Product product = restTemplate.getForObject("http://localhost:8080/product/{id}", Product.class ,paramMap);
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
    public ResponseEntity getProduct2(@PathVariable("id") String id){
        RestTemplate restTemplate = new RestTemplate();
        ServiceInstance instance = loadBalancerClient.choose("product-server");
        String url = String.format("http://%s:%s/product/{id}", instance.getHost(), instance.getPort());
//        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("id",id);
        Product product = restTemplate.getForObject(url,Product.class,paramMap);
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
    @GetMapping("/order/product3/{id}")
    public ResponseEntity getProduct3(@PathVariable("id") String id){
//        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
//        id = JSONObject.toJSONString(id);
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("id",id);
        Product product = restTemplate.getForObject("http://product-server/product/{id}", Product.class,paramMap);
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
    public ResponseEntity getProduct4(@PathVariable("id") String id){
        Product product = productClient.getProduct(id);
        return ResponseEntity.ok(product);
    }
}
