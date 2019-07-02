package com.hui.base.springcloud.lcn;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <b><code>LcnServerApplication</code></b>
 * <p/>
 * Description: SpringCloud LCN服务（分布式事务）
 * <p/>
 * <b>Creation Time:</b> 2019/4/1 21:15.
 *
 * @author HuWeihui
 */
@EnableTransactionManagerServer
@SpringBootApplication
@EnableEurekaClient
public class LcnServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LcnServerApplication.class,args);
    }
}
