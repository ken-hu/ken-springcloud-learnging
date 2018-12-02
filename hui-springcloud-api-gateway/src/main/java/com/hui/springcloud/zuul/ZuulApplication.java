package com.hui.springcloud.zuul;

import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * <b><code>ZuulApplication</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/11/26 0:06.
 *
 * @author Hu Weihui
 */
@SpringCloudApplication
@EnableEurekaClient
@EnableZuulServer
public class ZuulApplication {

}
