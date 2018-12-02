package com.hui.springcloud.order.client;

import com.hui.springcloud.common.entity.product.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <b><code>ProductClient</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/11/28 23:20.
 *
 * @author Hu Weihui
 */
@FeignClient(name = "product-server")
public interface ProductClient {

    @GetMapping(value = "/product/{id}")
    Product getProduct(@PathVariable("id") String id);
}
