package com.hui.base.springcloud.lcn;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <b><code>LcnServerApplication</code></b>
 * <p/>
 * Description: SpringCloud LCN-manager服务（分布式事务） 默认是8070端口
 * <p/>
 * <b>Creation Time:</b> 2019/4/1 21:15.
 *
 * @author HuWeihui
 */
@EnableTransactionManagerServer
@SpringBootApplication
@EnableDiscoveryClient
public class LcnServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(LcnServerApplication.class,args);
    }
}
