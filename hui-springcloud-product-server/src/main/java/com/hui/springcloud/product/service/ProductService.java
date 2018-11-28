package com.hui.springcloud.product.service;

import com.hui.springcloud.common.entity.product.Product;

import javax.annotation.Resource;
import java.util.List;

/**
 * <b><code>ProductService</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/11/26 0:11.
 *
 * @author Hu Weihui
 */
@Resource
public interface ProductService {

    Product get(String id);

    List<Product> list();
}
