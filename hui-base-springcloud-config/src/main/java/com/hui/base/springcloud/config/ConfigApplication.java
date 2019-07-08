package com.hui.base.springcloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <b><code>ConfigApplication</code></b>
 * <p/>
 * Description: 配置中心DEMO
 * <p/>
 * <b>Creation Time:</b> 2018/11/26 0:06.
 *
 * @author Hu Weihui
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties
public class ConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }

}
