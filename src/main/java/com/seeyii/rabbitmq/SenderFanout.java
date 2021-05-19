package com.seeyii.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SenderFanout {
    @Autowired
    private AmqpTemplate amqpTemplate;

    /*
     * @method send
     * @Description //TODO
     * @Author ssk
     * @Date 2021/5/18 19:09
     * @param s
     * @return java.lang.String
     **/
    public String send(String s){
        amqpTemplate.convertAndSend("logs","",s);
        return "success";
    }



}
