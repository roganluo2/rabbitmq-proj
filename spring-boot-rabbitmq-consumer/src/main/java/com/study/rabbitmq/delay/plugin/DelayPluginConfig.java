package com.study.rabbitmq.delay.plugin;

import com.rabbitmq.client.ConnectionFactory;
import com.study.rabbitmq.Constants;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DelayPluginConfig {

    @Bean("delayExchange")
    public CustomExchange exchange() {
        Map<String, Object> argss = new HashMap<String, Object>();
        argss.put("x-delayed-type", "direct");
        return new CustomExchange(Constants.DELAY_PLUGIN_EXCHANGE, "x-delayed-message",true, false, argss);
    }

    @Bean("delayQueue")
    public Queue deadLetterQueue() {
        return new Queue(Constants.DELAY_PLUGIN_QUEUE, true, false, false, new HashMap<>());
    }

    @Bean
    public Binding bindingDead(@Qualifier("delayQueue") Queue queue, @Qualifier("delayExchange") CustomExchange exchange) {
        return new Binding(queue.getName(), Binding.DestinationType.QUEUE, exchange.getName(), "#", new HashMap());

    }

}
