package com.hui.springcloud.order.msg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <b><code>MQReceiver</code></b>
 * <p/>
 * Description:
 * <p/>
 * <b>Creation Time:</b> 2018/12/2 18:06.
 *
 * @author HuWeihui
 */
@Component
@Slf4j
public class MQReceiver {

    //1.先创建消息队列，直接监听
    //@RabbitListener(queues = "huiQueue")
    //2.自动声明队列(2.0以上)
    //@RabbitListener(queuesToDeclare = @Queue("huiQueue"))
    //3.自动声明队列和exchange并自动关联（Exchange:服务根据消息分组进行转发）
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "huiQueue"),
            exchange = @Exchange(value = "huiExchange")
    ))
    public void receiver(String msg) {
        log.info("[MQReceiver] receiver: getMsg ::: {}", msg);
    }




    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "huiQueue"),
            key = "serviceA",
            exchange= @Exchange(value = "huiExchange")
    ))
    public void receiver1(String msg) {
        log.info("[MQReceiver] receiver: serviceA getMsg ::: {}", msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "huiQueue"),
            key = "serviceB",
            exchange = @Exchange(value = "huiExchange")
    ))
    public void receiver2(String msg) {
        log.info("[MQReceiver] receiver: serviceB getMsg ::: {}", msg);
    }
}
