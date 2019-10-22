package com.study.rabbitmq;

/**
 * @author rogan.luo
 * @Description 常量
 * @Date 2019/10/22 11:42
 */
public final class Constants {

    public static final  String EXCHANGE_NAME = "spring.boot.exchange";


    public static final String ROUTER_KEY = "spring.boot.router.key";

    public static final String ORIGIN_EXCHANGE = "spring.boot.dead.origin.exchange";

    public static final String ORIGIN_ROUTER_KEY = "spring.boot.dead.origin.router.key";

    public static final String TOPIC_EXCHANGE = "spring.boot.topic.exchange";

    public static final String FANOUT_EXCHANGE = "spring.boot.fanout.exchange";

    public static final String TOPIC_ROUTER_KEY = "topic.study.gupao.rabbitmq";

    public static final String DELAY_PLUGIN_EXCHANGE = "spring.boot.delay.plugin.exchange";
}
