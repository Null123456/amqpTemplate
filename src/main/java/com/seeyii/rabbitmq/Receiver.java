package com.seeyii.rabbitmq;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

/**
 * @ClassName Receiver
 * @Description rabbitmq接受者
 * @Author PC-002
 * @created 2021/5/18 11:22
 * @Version 1.0*/


@Component
@RabbitListener(queuesToDeclare = @Queue(value = "hello"))
public class Receiver {


    private static Logger logger = LoggerFactory.getLogger(Sender.class);


    @RabbitHandler
    public void processHandler(String msg, Channel channel, Message message) throws IOException {
        try {
            logger.info("收到消息：{}", msg);
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            if (message.getMessageProperties().getRedelivered()) {
                logger.error("消息已重复处理失败,拒绝再次接收...");
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false); // 拒绝消息
            } else {
                logger.error("消息即将再次返回队列处理...");
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            }
        }
    }

}


