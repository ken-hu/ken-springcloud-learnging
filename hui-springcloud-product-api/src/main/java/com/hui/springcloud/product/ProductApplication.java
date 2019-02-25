package com.hui.springcloud.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b><code>ProductApplication</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/11/26 0:11.
 *
 * @author Hu Weihui
 */
@EnableEurekaClient
@MapperScan("com.hui.springcloud.common.mapper")
@SpringBootApplication(scanBasePackages = "com.hui.springcloud")
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}
