package com.hui.base.springcloud.gateway;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.stereotype.Component;

/**
 * <b><code>ZuulConfig</code></b>
 * <p/>
 * Description: 动态路由。配置动态注入
 * <p/>
 * <b>Creation Time:</b> 2018/12/26 22:27.
 *
 * @author HuWeihui
 */
@Component
public class ZuulConfig {
    @ConfigurationProperties("zuul")
    @RefreshScope
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }
}
