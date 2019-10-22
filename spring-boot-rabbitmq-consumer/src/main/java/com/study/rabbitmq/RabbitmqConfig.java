package com.study.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

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
    public Binding binding(@Qualifier("directExchange") DirectExchange directExchange, @Qualifier("directQueue") Queue queue)
    {
        return BindingBuilder.bind(queue).to(directExchange).with(Constants.ROUTER_KEY);
    }


    // 两个交换机
    @Bean("topicExchange")
    public TopicExchange getTopicExchange(){
        return new TopicExchange(Constants.TOPIC_EXCHANGE);
    }

    @Bean("fanoutExchange")
    public FanoutExchange getFanoutExchange(){
        return  new FanoutExchange(Constants.FANOUT_EXCHANGE);
    }

    // 三个队列
    @Bean("firstQueue")
    public Queue getFirstQueue(){
        Map<String, Object> args = new HashMap<String, Object>();
        args.put("x-message-ttl",6000);
        Queue queue = new Queue(Constants.FIRST_QUEUE, false, false, true, args);
        return queue;
    }

    @Bean("secondQueue")
    public Queue getSecondQueue(){
        return new Queue(Constants.SECOND_QUEUE);
    }

    @Bean("thirdQueue")
    public Queue getThirdQueue(){
        return new Queue(Constants.THIRD_QUEUE);
    }

    @Bean("fourthQueue")
    public Queue getFourthQueue(){
        return new Queue(Constants.FOURTH_QUEUE);
    }
    // 两个绑定
    @Bean
    public Binding bindSecond(@Qualifier("secondQueue") Queue queue,@Qualifier("topicExchange") TopicExchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with(Constants.TOPIC_ROUTER_KEY);
    }

    @Bean
    public Binding bindThird(@Qualifier("thirdQueue") Queue queue,@Qualifier("fanoutExchange") FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }


    @Bean
    public Binding bindFourth(@Qualifier("fourthQueue") Queue queue,@Qualifier("fanoutExchange") FanoutExchange exchange){
        return BindingBuilder.bind(queue).to(exchange);
    }


}
