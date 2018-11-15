package com.hui.springcloud.msg.api;

import com.hui.springcloud.msg.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <b><code>MsgController</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/11/14 21:31.
 *
 * @author Hu Weihui
 */
@RestController
public class MsgController {
    @Autowired
    LoadBalancerClient loadBalancerClient;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    private MsgService msgService;

    @Autowired
    private AccountFeginClient accountFeginClient;


    @GetMapping("/msg")
    public String msg() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client-account");
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/account";
        System.out.println(url);
        return restTemplate.getForObject(url, String.class);
    }


    @GetMapping("/msg2")
    public String msg2(){
        return restTemplate.getForObject("http://eureka-client-account/account",String.class);
    }


    @GetMapping("/msg3")
    public String msg3(){
        return accountFeginClient.accountFeign();
    }


    @GetMapping("/msg4")
    public String msg4(){
        return msgService.testService();
    }
}
