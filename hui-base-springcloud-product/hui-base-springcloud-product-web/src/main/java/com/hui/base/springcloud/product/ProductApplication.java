package com.hui.base.springcloud.product;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <b><code>ProductApplication</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/11/26 0:11.
 *
 * @author Hu Weihui
 */
@EnableDiscoveryClient
@MapperScan("com.hui.base.springcloud.*.mapper")
@SpringBootApplication(scanBasePackages = "com.hui.base.springcloud")
@EnableFeignClients(basePackages = "com.hui.base.springcloud")
@EnableDistributedTransaction
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}
