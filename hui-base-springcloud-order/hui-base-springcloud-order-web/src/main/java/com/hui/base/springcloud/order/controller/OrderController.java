package com.hui.base.springcloud.order.controller;

import com.hui.base.springcloud.common.response.ResultMapper;
import com.hui.base.springcloud.common.response.ResultVO;
import com.hui.base.springcloud.order.model.Order;
import com.hui.base.springcloud.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <b><code>OrderController</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/11/28 1:00.
 *
 * @author Hu Weihui
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;


    /**
     * 通过id查询订单.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/order/{id}")
    public ResultVO<Order> get(@PathVariable("id") String id){
        Order order = orderService.get(id);
        return ResultMapper.ok(order);
    }

    /**
     * 查询所有订单
     *
     * @return the response entity
     */
    @GetMapping("/orders")
    public ResultVO<List<Order>> listAll(){
        List<Order> list = orderService.list();
        return ResultMapper.ok(list);
    }

}
