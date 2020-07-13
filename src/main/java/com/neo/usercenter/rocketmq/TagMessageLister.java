package com.neo.usercenter.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * 监听消费带 tag 的消息。必须指定@RocketMQMessageListener的属性
 * selectorType = SelectorType.TAG
 * selectorExpression = "tagName" -> 指定要消费的消息的 tag
 *
 * @author zhaoWenCai
 * @date 2020/6/14
 * @since 1.0.0
 */
@Slf4j
@Service
@RocketMQMessageListener(consumerGroup = "tag-consumer", topic = "tag-message",
        selectorExpression = "tagA", selectorType = SelectorType.TAG)
public class TagMessageLister implements RocketMQListener<String> {
    @Override
    public void onMessage(String s) {
        log.info("收到了带 tag 的消息: message = {}", s);
    }
}
