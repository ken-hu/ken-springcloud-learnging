package com.hui.base.springcloud.product.service.impl;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.codingapi.txlcn.tc.annotation.TxTransaction;
import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.codingapi.txlcn.tracing.TracingContext;
import com.google.common.collect.Sets;
import com.hui.base.springcloud.product.mapper.ProductMapper;
import com.hui.base.springcloud.product.model.Product;
import com.hui.base.springcloud.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

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
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    private ConcurrentHashMap<String, Set<String>> ids = new ConcurrentHashMap<>();


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

    @Override
    @TxcTransaction(propagation = DTXPropagation.SUPPORTS)
    @Transactional(rollbackFor = Exception.class)
    public void txcAdd(Product product) {
        productMapper.insertSelective(product);
    }


    @Override
    @TccTransaction(propagation = DTXPropagation.SUPPORTS)
    @Transactional(rollbackFor = Exception.class)
    public void tccAdd(Product product) {
        productMapper.insertSelective(product);

        ids.putIfAbsent(TracingContext.tracing().groupId(), Sets.newHashSet(product.getProductId()));
        ids.get(TracingContext.tracing().groupId()).add(product.getProductId());
    }

    public void confirmTccAdd (Product product) {
        ids.get(TracingContext.tracing().groupId()).forEach(id -> {
            log.info("tcc-confirm-{}-{}" , TracingContext.tracing().groupId(), id);
            ids.get(TracingContext.tracing().groupId()).remove(id);
        });
    }

    public void cancelTccAdd(Product product) {
        ids.get(TracingContext.tracing().groupId()).forEach(id -> {
            log.info("tcc-cancel-{}-{}", TracingContext.tracing().groupId(), id);
            productMapper.deleteByPrimaryKey(id);
        });
    }

}
