package com.hui.springcloud.product.api;

import com.hui.springcloud.common.entity.product.Product;
import com.hui.springcloud.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b><code>ProductController</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/11/27 23:30.
 *
 * @author Hu Weihui
 */
@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity get(@RequestBody String id){
        Product product = productService.get(id);
        return new ResponseEntity(product,HttpStatus.OK);
    }


    @PostMapping("/products")
    public ResponseEntity listAll(){
        List<Product> list = productService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
}
