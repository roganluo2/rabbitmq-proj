package com.study.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ProducerApplication.class, args);
        ProducerService bean = run.getBean(ProducerService.class);

        for(int i = 0;i < 10; i++)
        {
            bean.send(i);
        }
    }

}
