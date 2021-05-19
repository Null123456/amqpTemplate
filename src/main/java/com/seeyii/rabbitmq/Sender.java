package com.seeyii.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
/**  
 * @ClassName Sender
 * @Description rabbitmq发送者类
 * @Author PC-002   
 * @created 2021/5/18 11:21 
 * @Version 1.0 
 */
@Component
public class Sender {

    private static Logger logger = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private AmqpTemplate amqpTemplate;

    public String send(String queueName){
        String context = "这是一条消息";
        amqpTemplate.convertAndSend(queueName, context);
        logger.info("发送：", context);
        return "发送成功";
    }


}
