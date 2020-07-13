package com.neo.usercenter.rocketmq;

import com.alibaba.fastjson.JSON;
import com.neo.usercenter.domain.dto.message.UserAddBonusMsgDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

/**
 * 监听消费同步延时消息
 *
 * @author zhaoWenCai
 * @date 2020/6/10
 * @since 1.0.0
 */
@Service
@Slf4j
@RocketMQMessageListener(consumerGroup = "sync-delay-consumer", topic = "sync-delay-message")
public class SyncDelayMessageLister implements RocketMQListener<UserAddBonusMsgDTO> {

    @Override
    public void onMessage(UserAddBonusMsgDTO userAddBonusMsgDTO) {
        log.info("消费了延时消息: message = {}", JSON.toJSONString(userAddBonusMsgDTO));
    }
}
