package com.hui.base.springcloud.order.service;


import com.hui.base.springcloud.order.model.Order;

import javax.annotation.Resource;
import java.util.List;

/**
 * <b><code>OrderApplication</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/11/26 0:08.
 *
 * @author Hu Weihui
 */
@Resource
public interface OrderService {
    Order get(String id);

    List<Order> list();

    Order add(Order order);
}
