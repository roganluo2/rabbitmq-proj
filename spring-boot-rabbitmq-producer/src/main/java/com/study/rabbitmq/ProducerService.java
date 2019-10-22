package com.study.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author rogan.luo
 * @Description
 * @Date 2019/10/22 12:31
 */
@Service
public class ProducerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(int i){
        rabbitTemplate.convertAndSend(Constants.EXCHANGE_NAME,Constants.ROUTER_KEY, "this is my new message" + i);
    }

}
