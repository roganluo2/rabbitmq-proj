package com.study.rabbitmq.delay.plugin;

import com.study.rabbitmq.Constants;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author rogan.luo
 * @Description
 * @Date 2019/10/22 12:31
 */
@Component
public class DelayPluginConsumer {


    @RabbitHandler
    @RabbitListener(queues = Constants.DELAY_PLUGIN_QUEUE)
    public void receive(String message)
    {
        System.out.println( "收到mq消息：" + message + "时间" + LocalDateTime.now());
    }

}
