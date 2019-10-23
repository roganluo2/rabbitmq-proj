package com.study.rabbitmq;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

@Component
public class DelayPluginMessageSender {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void send(int i){

        // 延时投递，比如延时4秒
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, +10);
        Date delayTime = calendar.getTime();

        // 定时投递，把这个值替换delayTime即可
        // Date exactDealyTime = new Date("2019/06/24,22:30:00");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String msg = "延时插件测试消息，发送时间：" + sf.format(now) + "，理论路由时间：" + sf.format(delayTime);

        MessageProperties messageProperties = new MessageProperties();
// 延迟的间隔时间，目标时刻减去当前时刻
        messageProperties.setHeader("x-delay", delayTime.getTime() - now.getTime());
        Message message = new Message(msg.getBytes(), messageProperties);
// 不能在本地测试，必须发送消息到安装了插件的 Linux 服务端
        rabbitTemplate.convertAndSend(Constants.DELAY_PLUGIN_EXCHANGE, "#", message);
    }

}
