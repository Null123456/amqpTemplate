package com.seeyii.controller;

import com.seeyii.rabbitmq.Sender;
import com.seeyii.rabbitmq.SenderFanout;
import com.seeyii.rabbitmq.SenderRoute;
import com.seeyii.rabbitmq.SenderTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PushTestController {

    @Autowired
    private Sender sender;

    @Autowired
    private SenderFanout senderFanout;

    @Autowired
    private SenderRoute senderRoute;

    @Autowired
    private SenderTopic senderTopic;

    @GetMapping("pushMsg")
    public String pushMsg(){
        // 队列的名称
        String queueName = "hello";
        sender.send(queueName);
        return "success";
    }

    @GetMapping("/fanout")
    public String fanout(){
        // 队列的名称
        String message = "hi";
        senderFanout.send(message);
        return "success";
    }

    @GetMapping("/direct")
    public String direct(){
        // 队列的名称
        String message = "hi123456";
        senderRoute.send(message);
        return "success";
    }


    @GetMapping("/topic")
    public String topic(){
        // 队列的名称
        String message = "topicya";
        senderTopic.send(message);
        return "success";
    }

}

