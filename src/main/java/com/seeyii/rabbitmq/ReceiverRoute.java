package com.seeyii.rabbitmq;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName ReceiverRoute
 * @Description TODO
 * @Author ssk
 * @created 2021/5/18 19:41
 * @Version 1.0
 */
@Component
public class ReceiverRoute {
    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "directexchange",type = "direct"),
            key = {"key"}) //绑定交换机
    })
    public void processHandler(String message){
        System.out.println("1111     "+message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "directexchange",type = "direct"),
                    key = {"error"}) //绑定交换机
    })
    public void processHandler2(String message){
        System.out.println("2222     "+message);
    }

}
