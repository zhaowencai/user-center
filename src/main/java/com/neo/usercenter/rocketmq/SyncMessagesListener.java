package com.neo.usercenter.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * 监听消费批量消息，指定 @RocketMQMessageListener 的属性
 * consumeMode = ConsumeMode.ORDERLY 可以在消费消息时保证消费顺序，
 * 与生产消息集合时添加到集合中的顺序一致
 * 代价是只会创建一个消费者线程消费消息，效率偏低
 *
 * @author zhaoWenCai
 * @date 2020/6/10
 * @since 1.0.0
 */
@Service
@Slf4j
@RocketMQMessageListener(consumerGroup = "syncs-consumer",
        topic = "sync-messages", consumeMode = ConsumeMode.ORDERLY
)
public class SyncMessagesListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        log.info("接收到了消息：message = {}", s);
    }
}
