package com.neo.usercenter.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * 消费单向有序消息
 *
 * @author zhaoWenCai
 * @date 2020/6/10
 * @since 1.0.0
 */
@Service
@Slf4j
@RocketMQMessageListener(consumerGroup = "oneWay-order-consumer",
        topic = "oneWay-order-message",
        consumeMode = ConsumeMode.ORDERLY
)
public class OneWayOrderMessageLister implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        log.info("收到了单向有序消息: message = {}", s);
    }
}
