package com.rabbitmq.demo;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DelayPluginConsumer {


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
        //7.创建消费者
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "UTF-8");
                SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                System.out.println("收到消息：[" + msg + "]\n接收时间：" +sf.format(new Date()));

            }
        };
        //8.绑定consumer
        channel.basicConsume("spring.boot.delay.plugin.queue", true, consumer);
    }

}
