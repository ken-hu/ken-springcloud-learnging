package com.hui.base.springcloud.order.service.impl;

import com.hui.base.springcloud.order.mapper.OrderMapper;
import com.hui.base.springcloud.order.model.Order;
import com.hui.base.springcloud.order.service.OrderService;
import com.hui.base.springcloud.product.api.ProductFeignApi;
import dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private ProductFeignApi productFeignApi;

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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testTCC(Order order, String exFlag) {

        // use the tcc mode to start remote transaction
        ProductDTO productDTO = new ProductDTO();
        double ceil = Math.ceil(Math.random() * 100);
        String productId = String.valueOf(ceil);
        productDTO.setProductName("tccTest");
        productDTO.setProductId(productId);
        productFeignApi.tccAdd(productDTO);


        // use the local transaction
        orderMapper.insertSelective(order);

        if (exFlag.equals("true")){
            throw new RuntimeException("test txc exception");
        }

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void testTXC(Order order, String exFlag) {

        // use the local transaction
        orderMapper.insertSelective(order);

        // use the txc mode to start remote transaction
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductName("txcTest");
        double ceil = Math.ceil(Math.random() * 100);
        String productId = String.valueOf(ceil);

        productDTO.setProductId(productId);
        productFeignApi.txcAdd(productDTO);

        if (exFlag.equals("true")){
            throw new RuntimeException("test txc exception");
        }
    }
}
