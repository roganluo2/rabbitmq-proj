package com.rabbitmq.demo;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class RabbitmqProducer {


    public static void main(String[] args) throws Exception {
        //1. 创建connection factory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost(Constants.HOST);
        connectionFactory.setUsername(Constants.USERNAME);
        connectionFactory.setPort(Constants.PORT);
        connectionFactory.setPassword(Constants.PASSWORD);
        connectionFactory.setVirtualHost("/");
        //2.得到connnection
        Connection connection = connectionFactory.newConnection();
        //3.得到channel
        Channel channel = connection.createChannel();
        //4.定义消息
        String msg = "Rabbitmq Producer send a message";
        //5.发送消息
        channel.basicPublish(Constants.EXCHANGE_NAME, Constants.ROUTER_KEY, null, msg.getBytes());
        TimeUnit.SECONDS.sleep(10);
        //6.关闭通道，连接
        channel.close();
        connection.close();

    }

}
