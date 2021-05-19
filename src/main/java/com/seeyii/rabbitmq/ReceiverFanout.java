package com.seeyii.rabbitmq;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @ClassName ReceiverFanout
 * @Description TODO
 * @Author ssk
 * @created 2021/5/18 19:27
 * @Version 1.0
 */
@Component
public class ReceiverFanout {

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "logs",type = "fanout")) //绑定交换机
    })
    public void processHandler(String message){
        System.out.println("1111     "+message);
    }


    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "logs",type = "fanout")) //绑定交换机
    })
    public void processHandler2(String message){
        System.out.println("2222     "+message);
    }

}
