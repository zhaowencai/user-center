package com.neo.usercenter.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * 监听消费异步有序消息
 *
 * @author zhaoWenCai
 * @date 2020/6/10
 * @since 1.0.0
 */
@Slf4j
@Service
@RocketMQMessageListener(consumerGroup = "async-orderly-consumer",
        topic = "async-order-message",
        consumeMode = ConsumeMode.ORDERLY,
        consumeThreadMax = 1
)
public class AsyncOrderlyMessageLister implements RocketMQListener<String> {

    @Override
    public void onMessage(String s) {
        log.info("received message = {}", s);
    }
}
