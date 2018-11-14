package com.hui.springcloud.account.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b><code>AccountController</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/11/13 22:14.
 *
 * @author Hu Weihui
 */
@RestController
public class AccountController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/account")
    public String account() {
        String services = "Services Account run : " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }



}
