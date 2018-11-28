package com.hui.springcloud.product.service.impl;

import com.hui.springcloud.common.entity.product.Product;
import com.hui.springcloud.common.mapper.product.ProductMapper;
import com.hui.springcloud.product.service.ProductService;
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
        productMapper.selectByPrimaryKey("p-1");
        return null;
    }

    @Override
    public List<Product> list() {
        return productMapper.listAll();
    }
}
