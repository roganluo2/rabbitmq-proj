package com.study.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = Constants.FOURTH_QUEUE)
public class FourthConsumer {

    @RabbitHandler
    public void process(String msg){
        System.out.println(" fourth queue received msg : " + msg);
    }
}
