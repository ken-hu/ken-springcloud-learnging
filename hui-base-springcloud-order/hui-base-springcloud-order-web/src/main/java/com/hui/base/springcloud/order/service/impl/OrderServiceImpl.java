package com.hui.base.springcloud.order.service.impl;

import com.hui.base.springcloud.order.mapper.OrderMapper;
import com.hui.base.springcloud.order.model.Order;
import com.hui.base.springcloud.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <b><code>OrderServiceImpl</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/11/27 23:46.
 *
 * @author Hu Weihui
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order get(String id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        return order;
    }

    @Override
    public List<Order> list() {
        return null;
    }

    @Override
    public Order add(Order order) {
        orderMapper.insertSelective(order);
        return order;
    }
}
