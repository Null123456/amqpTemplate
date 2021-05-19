package com.seeyii.rabbitmq;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @ClassName ReceiverTopic
 * @Description TODO
 * @Author ssk
 * @created 2021/5/18 19:54
 * @Version 1.0
 */
@Component
public class ReceiverTopic {
    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "topicexchange",type = "topic"),
                    key = {"user.key","order.#"}) //绑定交换机
    })
    public void processHandler(String message){
        System.out.println("topicexchange 1111    "+message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "topicexchange",type = "topic"),
                    key = {"user.*"}) //绑定交换机
    })
    public void processHandler2(String message){
        System.out.println("topicexchange 2222    "+message);
    }


}
