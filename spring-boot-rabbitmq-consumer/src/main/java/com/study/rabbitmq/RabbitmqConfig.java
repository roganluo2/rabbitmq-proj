package com.study.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @author rogan.luo
 * @Description
 * @Date 2019/10/22 11:24
 */
@Configuration
public class RabbitmqConfig {

    @Bean
    public DirectExchange directExchange()
    {
        return new DirectExchange(Constants.EXCHANGE_NAME);
    }


    @Bean
    public Queue directQueue()
    {
        return new Queue(Constants.QUEUE_NAME);
    }

    @Bean
    public Binding binding(DirectExchange directExchange, Queue queue)
    {
        return new Binding(Constants.QUEUE_NAME, Binding.DestinationType.QUEUE, Constants.EXCHANGE_NAME, Constants.ROUTER_KEY, new HashMap<String, Object>());
    }



}
