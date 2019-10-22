package com.study.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @author rogan.luo
 * @Description
 * @Date 2019/10/22 12:31
 */
@Service
@RabbitListener(queues = Constants.QUEUE_NAME)
public class ConsumerService {


    @RabbitHandler
    public void receive(String message)
    {
        System.out.println( "收到mq消息：" +message);
    }

}
