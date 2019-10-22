package com.study.rabbitmq;

/**
 * @author rogan.luo
 * @Description 常量
 * @Date 2019/10/22 11:42
 */
public final class Constants {

    public static final  String EXCHANGE_NAME = "spring.boot.exchange";

    public static final String QUEUE_NAME = "spring.boot.queue";

    public static final String ROUTER_KEY = "spring.boot.router.key";

    public static final String FIRST_QUEUE = "spring.boot.first.queue";

    public static final String SECOND_QUEUE = "spring.boot.second.queue";

    public static final String THIRD_QUEUE = "spring.boot.third.queue";

    public static final String FOURTH_QUEUE = "spring.boot.fourth.queue";

    public static final String TOPIC_EXCHANGE = "spring.boot.topic.exchange";

    public static final String FANOUT_EXCHANGE = "spring.boot.fanout.exchange";

    public static final String TOPIC_ROUTER_KEY = "#.gupao.#";

    /***************死信队列************************/
    public static final String ORIGIN_EXCHANGE = "spring.boot.dead.origin.exchange";

    public static final String ORIGIN_QUEUE = "spring.boot.dead.origin.queue";

    public static final String ORIGIN_ROUTER_KEY = "spring.boot.dead.origin.router.key";

    public static final String DEAD_LETTER_EXCHANGE = "spring.boot.dead.backup.exchange";


    public static final String DEAD_LETTER_QUEUE = "spring.boot.dead.backup.queue";
    /***************死信队列************************/

}
