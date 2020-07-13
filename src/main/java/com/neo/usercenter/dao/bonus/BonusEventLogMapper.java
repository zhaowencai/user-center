package com.neo.usercenter.dao.bonus;

import com.neo.usercenter.domain.entity.bonus.BonusEventLog;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author zhaoyun
 */
@Repository
public interface BonusEventLogMapper extends Mapper<BonusEventLog> {
}