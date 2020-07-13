package com.neo.usercenter.rocketmq;

import com.neo.usercenter.domain.entity.user.Share;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * 监听消费事务消息
 *
 * @author zhaoWenCai
 * @date 2020/6/14
 * @since 1.0.0
 */
@Slf4j
@Service
@RocketMQMessageListener(consumerGroup = "transactional-consumer", topic = "transactional-message")
public class TransactionalMessageLister implements RocketMQListener<Share> {

    @Override
    public void onMessage(Share share) {
        log.info("消费到了事务消息 message ={}", share);
    }
}
