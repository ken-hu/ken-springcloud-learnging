package com.hui.base.springcloud.order.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <b><code>RestTemplateConfig</code></b>
 * <p/>
 * Description: 注册restTemplate到Bean
 * <p/>
 * <b>Creation Time:</b> 2018/11/28 23:38.
 *
 * @author Hu Weihui
 */
@SpringBootConfiguration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
