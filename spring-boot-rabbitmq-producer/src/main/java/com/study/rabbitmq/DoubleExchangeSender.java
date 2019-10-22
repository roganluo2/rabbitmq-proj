package com.study.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author rogan.luo
 * @Description
 * @Date 2019/10/22 12:31
 */
@Component
public class DoubleExchangeSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(int i){
        rabbitTemplate.convertAndSend(Constants.TOPIC_EXCHANGE,Constants.TOPIC_ROUTER_KEY, "this is my new topic message" + i);
        rabbitTemplate.convertAndSend(Constants.FANOUT_EXCHANGE,"", "this is my new fanout message" + i);
    }

}
