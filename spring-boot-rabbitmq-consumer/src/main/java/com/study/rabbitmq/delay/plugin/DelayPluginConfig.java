package com.study.rabbitmq.delay.plugin;

import com.study.rabbitmq.Constants;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DelayPluginConfig {

    @Bean("delayExchange")
    public TopicExchange exchange() {
        Map<String, Object> argss = new HashMap<String, Object>();
        argss.put("x-delayed-type", "direct");
        return new TopicExchange(Constants.DELAY_PLUGIN_EXCHANGE, true, false, argss);
    }

    @Bean("delayQueue")
    public Queue deadLetterQueue() {
        return new Queue(Constants.DELAY_PLUGIN_QUEUE, true, false, false, new HashMap<>());
    }

    @Bean
    public Binding bindingDead(@Qualifier("delayQueue") Queue queue, @Qualifier("delayExchange") TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("#"); // 无条件路由
    }

}
