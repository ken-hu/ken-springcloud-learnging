package com.hui.springcloud.order.api;

import com.hui.springcloud.common.entity.order.Order;
import com.hui.springcloud.common.entity.product.Product;
import com.hui.springcloud.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity get(@PathVariable("id") String id){
        Order order = orderService.get(id);
        return ResponseEntity.ok(order);
    }

    /**
     * 查询所有订单
     *
     * @return the response entity
     */
    @GetMapping("/orders")
    public ResponseEntity listAll(){
        List<Order> list = orderService.list();
        return ResponseEntity.ok(list);
    }


}
