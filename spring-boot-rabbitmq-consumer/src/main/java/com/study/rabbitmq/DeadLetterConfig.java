package com.study.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * 通过死信队列实现延时发送
 */
@Configuration
public class DeadLetterConfig {

    @Bean("oriExchange")
    public DirectExchange directExchange()
    {
        return new DirectExchange(Constants.ORIGIN_EXCHANGE,false,false,new HashMap<>());
    }

    @Bean("oriQueue")
    public Queue directQueue()
    {
        Map<String,Object> args = new HashMap<>();
        // 10s 过期
        args.put("x-message-ttl",10 * 1000) ;
        args.put("x-dead-letter-exchange", Constants.DEAD_LETTER_EXCHANGE);
        return new Queue(Constants.ORIGIN_QUEUE, false, false, false, args);
    }

    @Bean
    public Binding oriBinding(@Qualifier("oriQueue") Queue queue, @Qualifier("oriExchange") DirectExchange exchange)
    {
        return BindingBuilder.bind(queue).to(exchange).with(Constants.ORIGIN_ROUTER_KEY);
    }


    @Bean
    public TopicExchange deadLetterExchange()
    {
        return new TopicExchange(Constants.DEAD_LETTER_EXCHANGE);
    }

    @Bean
    public Queue deadLetterQueue()
    {
        return new Queue(Constants.DEAD_LETTER_QUEUE);
    }

    @Bean
    public Binding deadBinding(@Qualifier("deadLetterExchange") TopicExchange topicExchange, @Qualifier("deadLetterQueue") Queue queue)
    {
        return BindingBuilder.bind(queue).to(topicExchange).with("#");
    }







}
