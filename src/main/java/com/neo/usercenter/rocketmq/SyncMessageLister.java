package com.neo.usercenter.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * 测试消息消费者监听器：有测试消息就消费
 *
 * @author zhaoWenCai
 * @date 2020/6/10
 * @since 1.0.0
 */
@Service
@Slf4j
@RocketMQMessageListener(consumerGroup = "sync-consumer", topic = "sync-message")
public class SyncMessageLister implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        log.info("收到了同步消息: message = {}", s);
    }
}
