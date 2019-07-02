package com.hui.base.springcloud.product.controller;

import com.hui.base.springcloud.common.response.ResultMapper;
import com.hui.base.springcloud.common.response.ResultVO;
import com.hui.base.springcloud.product.model.Product;
import com.hui.base.springcloud.product.service.ProductService;
import dto.ProductDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
@Slf4j
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public ResultVO<ProductDTO> get(@PathVariable("id") String id){
        ProductDTO productDTO = new ProductDTO();
        Product product = productService.get(id);
        BeanUtils.copyProperties(product,productDTO);
        log.info(productDTO.toString());
        return ResultMapper.ok(productDTO);
    }


    @GetMapping("/products")
    public ResultVO listAll(){
        List<Product> list = productService.list();
        return ResultMapper.ok(list);
    }


    @PutMapping("/products")
    public ResultVO add(@RequestBody ProductDTO productDTO){
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        productService.add(product);
        return ResultMapper.ok(product);
    }


    @PutMapping("/lcn/tcc/products")
    public ResultVO tccAdd(@RequestBody ProductDTO productDTO){
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        productService.tccAdd(product);
        return ResultMapper.ok();
    }

    @PutMapping("/lcn/txc/products")
    public ResultVO txcAdd(@RequestBody ProductDTO productDTO){
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        productService.txcAdd(product);
        return ResultMapper.ok();
    }
}
