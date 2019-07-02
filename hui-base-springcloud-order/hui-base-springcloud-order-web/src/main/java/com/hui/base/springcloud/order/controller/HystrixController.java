package com.hui.base.springcloud.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <b><code>HystrixController</code></b>
 * <p/>
 * Description: 熔断测试
 * <p/>
 * <b>Creation Time:</b> 2019/2/26 21:49.
 *
 * @author HuWeihui
 */
@RestController
public class HystrixController {

    @GetMapping("/hystrixTest")
    @HystrixCommand(fallbackMethod = "fallback")
    public String hystrixTest(){
        RestTemplate restTemplate = new RestTemplate();
        String productStr = restTemplate.getForObject("http://127.0.0.1/product/product/{id}",
                String.class, 1);
        return productStr;
    }

    @GetMapping("/hystrixTest2")
    @HystrixCommand(fallbackMethod = "fallback")
    public String hystrixTest2(){
        throw new RuntimeException("抛异常~");
    }


    @GetMapping("/hystrixTest3")
    @HystrixCommand(defaultFallback = "defaultFallback")
    public String hystrixTest3(){
        throw new RuntimeException("抛异常~");
    }

    //超时时间配置，超时则会降级
    @GetMapping("/hystrixTest4")
    @HystrixCommand(commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String hystrixTest4(){
        RestTemplate restTemplate = new RestTemplate();
        String productStr = restTemplate.getForObject("http://127.0.0.1/product/product/{id}",
                String.class, 1);
        return productStr;
    }

    //熔断设置
    @GetMapping("/hystrixTest5")
    @HystrixCommand(commandProperties = {
            //开启熔断
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            //设置熔断器最少请求次数
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            //设置熔断时间窗（断路器打开的时候会进行计时，超过这个时间再访问仍然请求失败会继续熔断，并重新计时）
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            //错误率百分之60就会熔断
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public String hystrixTest5(){
        RestTemplate restTemplate = new RestTemplate();
        String productStr = restTemplate.getForObject("http://127.0.0.1/product/product/{id}",
                String.class, 1);
        return productStr;
    }

    //熔断设置（也可以通过commonKey改名，对应bootstrap.yml里面做配置,默认为方法名，这里即hystrixTestX）
    @GetMapping("/hystrixTest6")
    @HystrixCommand(commandKey = "hystrixTestX")
    public String hystrixTest6(){
        RestTemplate restTemplate = new RestTemplate();
        String productStr = restTemplate.getForObject("http://127.0.0.1/product/product/{id}",
                String.class, 1);
        return productStr;
    }


    private String fallback(){
        return "服务降级测试~";
    }

    private String defaultFallback(){
        return "默认提示： 服务降级测试~";
    }


}
