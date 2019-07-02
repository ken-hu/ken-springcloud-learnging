package com.hui.base.springcloud.product.service.impl;

import com.hui.base.springcloud.product.dto.ProductInfo;
import com.hui.base.springcloud.product.mapper.ProductMapper;
import com.hui.base.springcloud.product.model.Product;
import com.hui.base.springcloud.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <b><code>ProductServiceImpl</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/11/27 23:25.
 *
 * @author Hu Weihui
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product get(String id) {
        Product product = productMapper.selectByPrimaryKey(id);
        return product;
    }

    @Override
    public List<Product> list() {
        return productMapper.listAll();
    }

    @Override
    public Product add(Product product) {
        int result = productMapper.insertSelective(product);
        return product;
    }

}
