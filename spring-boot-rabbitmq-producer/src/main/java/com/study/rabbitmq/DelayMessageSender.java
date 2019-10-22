package com.study.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author rogan.luo
 * @Description
 * @Date 2019/10/22 12:31
 */
@Component
public class DelayMessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(int i){
        rabbitTemplate.convertAndSend(Constants.ORIGIN_EXCHANGE,Constants.ORIGIN_ROUTER_KEY, "this is my new delay message" + i);
    }

}
