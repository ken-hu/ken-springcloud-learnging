package com.hui.base.springcloud.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b><code>TestController</code></b>
 * <p/>
 * Description
 * <p/>
 * <b>Creation Time:</b> 2019/7/8 11:01.
 *
 * @author Hu-Weihui
 * @since hui-base-springcloud ${PROJECT_VERSION}
 */
@RestController
public class TestController {

    @Autowired
    private TestConfig testConfig;

    @GetMapping("/testConfig")
    public String testConfig(){
        return testConfig.toString();
    }
}
