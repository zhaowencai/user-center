package com.neo.usercenter.rocketmq;

import com.alibaba.fastjson.JSON;
import com.neo.usercenter.domain.dto.message.UserAddBonusMsgDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * 监听消费异步延时消息
 *
 * @author zhaoWenCai
 * @date 2020/6/16
 * @since 1.0.0
 */
@Service
@Slf4j
@RocketMQMessageListener(consumerGroup = "async-delay-consumer", topic = "async-delay-message")
public class AsyncDelayMessageLister implements RocketMQListener<UserAddBonusMsgDTO> {

    @Override
    public void onMessage(UserAddBonusMsgDTO userAddBonusMsgDTO) {
        log.info("消费了延时消息: message = {}", JSON.toJSONString(userAddBonusMsgDTO));
    }
}
