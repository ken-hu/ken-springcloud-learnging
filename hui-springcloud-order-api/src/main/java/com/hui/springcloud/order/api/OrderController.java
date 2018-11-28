package com.hui.springcloud.order.api;

import com.hui.springcloud.common.entity.order.Order;
import com.hui.springcloud.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @PostMapping("/order")
    public ResponseEntity get(@PathVariable String id){
        Order order = orderService.get(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping("/orders")
    public ResponseEntity listAll(){
        List<Order> list = orderService.list();
        return ResponseEntity.ok(list);
    }

}
