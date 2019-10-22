package com.rabbitmq.demo;

import com.rabbitmq.client.*;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.io.IOException;
import java.util.Map;

public class RabbitmqConsumer {


    public static void main(String[] args) throws Exception {
        //1.连接工厂
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
        //4.声明交互机
        channel.exchangeDeclare(Constants.EXCHANGE_NAME, "direct", false);
        //5.声明队列
        channel.queueDeclare(Constants.QUEUE_NAME, false, false, false, null);
        //6.绑定队列
        channel.queueBind(Constants.QUEUE_NAME, Constants.EXCHANGE_NAME, Constants.ROUTER_KEY);
        //7.创建消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println("receive message");
                System.out.println("consumerTag:" + consumerTag);
                System.out.println("DeliveryTag:" + envelope.getDeliveryTag());
                System.out.println("msg:" + new String(body));

            }
        };
        //8.绑定consumer
        channel.basicConsume(Constants.QUEUE_NAME, true, consumer);
    }

}
