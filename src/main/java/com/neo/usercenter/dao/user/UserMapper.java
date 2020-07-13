package com.neo.usercenter.dao.user;

import com.neo.usercenter.domain.entity.user.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author zhaoyun
 */
@Repository
public interface UserMapper extends Mapper<User> {
}