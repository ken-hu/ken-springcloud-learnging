package com.hui.base.springcloud.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <b><code>TestConfig</code></b>
 * <p/>
 * Description 用于测试config动态配置
 * <p/>
 * <b>Creation Time:</b> 2019/7/8 10:16.
 *
 * @author Hu-Weihui
 * @since hui-base-springcloud ${PROJECT_VERSION}
 */
@Component
@ConfigurationProperties(prefix = "test")
@Data
@ToString
public class TestConfig {
    private String name;

    private String address;
}
