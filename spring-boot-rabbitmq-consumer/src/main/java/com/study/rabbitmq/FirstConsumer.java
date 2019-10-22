package com.study.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = Constants.FIRST_QUEUE)
public class FirstConsumer {

    @RabbitHandler
    public void process(String msg){
        System.out.println(" first queue received msg : " + msg);
    }
}
