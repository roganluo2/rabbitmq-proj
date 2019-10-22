package com.study.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;

@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ProducerApplication.class, args);
//        sendSimpleMessage(run);
//        sendDelayMessage(run);
//        sendMessageDoubleExchange(run);
        sendDelayPluginMessage(run);
    }

    private static void sendDelayPluginMessage(ConfigurableApplicationContext run) {
        DelayPluginMessageSender bean = run.getBean(DelayPluginMessageSender.class);

        for(int i = 0;i < 10; i++)
        {
            System.out.println("发送第"+i+"条消息，时间:" + LocalDateTime.now());
            bean.send(i);
        }
    }

    private static void sendMessageDoubleExchange(ConfigurableApplicationContext run) {

        DoubleExchangeSender bean = run.getBean(DoubleExchangeSender.class);
        bean.send(100);
    }

    private static void sendDelayMessage(ConfigurableApplicationContext run) {
        DelayMessageSender bean = run.getBean(DelayMessageSender.class);

        for(int i = 0;i < 10; i++)
        {
            System.out.println("发送第"+i+"条消息，时间:" + LocalDateTime.now());
            bean.send(i);
        }
    }

    private static void sendSimpleMessage(ConfigurableApplicationContext run) {
        ProducerService bean = run.getBean(ProducerService.class);

        for(int i = 0;i < 10; i++)
        {
            bean.send(i);
        }
    }

}
