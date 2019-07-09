package com.hui.base.springcloud.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <b><code>EurekaApplication</code></b>
 * <p/>
 * Description 服务发现CLIENT的DEMO。
 * 注意与EUREKA不一致
 * <p/>
 * <b>Creation Time:</b> 2019/2/25 16:05.
 *
 * @author Hu-Weihui
 * @since hui-base-springcloud ${PROJECT_VERSION}
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DiscoveryApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscoveryApplication.class, args);
    }
}
