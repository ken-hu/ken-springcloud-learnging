
package com.hui.base.springcloud.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <b><code>AuthServerConfig</code></b>
 * <p/>
 * Description:Swagger配置
 * <p/>
 * <b>Creation Time:</b> 2019/3/12 22:39.
 *
 * @author HuWeihui
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        StopWatch watch = new StopWatch();
        watch.start();
        Docket swaggerSpringMvcPlugin = new Docket(DocumentationType.SWAGGER_2)
                .groupName("order-service")
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select().apis(RequestHandlerSelectors.basePackage("com.hui.base.springcloud"))
                .paths(PathSelectors.any())
                .build();
        watch.stop();
        return swaggerSpringMvcPlugin;
    }

    private ApiInfo apiInfo() {
        String title = "order-service API文档";
        String description = " RESTFUL API";
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version("1.0.0")
                .build();
    }

}
