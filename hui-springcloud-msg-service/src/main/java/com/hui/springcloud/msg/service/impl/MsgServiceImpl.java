package com.hui.springcloud.msg.service.impl;

import com.hui.springcloud.msg.service.MsgService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * <b><code>MsgServiceImpl</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/11/15 22:04.
 *
 * @author Hu Weihui
 */
@Service
public class MsgServiceImpl implements MsgService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "testServiceFallBack")
    public String testService() {
        return restTemplate.getForObject("http://eureka-client-account/account",String.class);
    }

    @Override
    public String testServiceFallBack() {
        return "only can fall back ";
    }
}
