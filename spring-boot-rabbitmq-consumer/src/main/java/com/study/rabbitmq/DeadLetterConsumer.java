package com.study.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author rogan.luo
 * @Description
 * @Date 2019/10/22 12:31
 */
@Component
@RabbitListener(queues = Constants.DEAD_LETTER_QUEUE)
public class DeadLetterConsumer {


    @RabbitHandler
    public void receive(String message)
    {
        System.out.println( "收到mq消息：" +message + "时间" + LocalDateTime.now());
    }

}
