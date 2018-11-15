package com.hui.springcloud.msg.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * <b><code>MsgFeginController</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/11/14 21:55.
 *
 * @author Hu Weihui
 */
@Resource
@FeignClient("eureka-client-account")
public interface AccountFeginClient {

    @GetMapping("account")
    String accountFeign();
}
