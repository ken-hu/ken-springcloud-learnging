package com.hui.base.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * <b><code>ZuulApplication</code></b>
 * <p/>
 * Description: SpringCloud Finchley 版本 + Zuul 网关中心
 * <p/>
 * <b>Creation Time:</b> 2018/11/26 0:06.
 *
 * @author Hu Weihui
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }
}
