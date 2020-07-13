package com.neo.usercenter.service.user;

import com.neo.usercenter.dao.bonus.BonusEventLogMapper;
import com.neo.usercenter.dao.user.UserMapper;
import com.neo.usercenter.domain.dto.message.UserAddBonusMsgDTO;
import com.neo.usercenter.domain.entity.bonus.BonusEventLog;
import com.neo.usercenter.domain.entity.user.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author: zhaoyun
 * @date: 2020/5/21 22:09
 * @version: 1.0。0
 */
@Service
@Slf4j
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private BonusEventLogMapper bonusEventLogMapper;

    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void addBonus(UserAddBonusMsgDTO addBonusMsgDTO) {
        //1. 为用户加积分
        Integer userId = addBonusMsgDTO.getUserId();
        Integer bonus = addBonusMsgDTO.getBonus();
        User user = userMapper.selectByPrimaryKey(userId);
        user.setBonus(user.getBonus() + bonus);
        userMapper.updateByPrimaryKeySelective(user);
        //2. 记录日志
        this.bonusEventLogMapper.insert(
                BonusEventLog.builder()
                        .userId(userId)
                        .value(bonus)
                        .event("CONTRIBUTE")
                        .gmtCreate(new Date())
                        .description("投稿加积分..")
                        .build()
        );
        log.info("添加积分成功");
    }
}
