package com.neo.usercenter.controller.user;

import com.neo.usercenter.domain.entity.user.User;
import com.neo.usercenter.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zhaoyun
 * @date: 2020/5/21 21:49
 * @version: 1.0。0
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        log.info("我被请求了---");
        return userService.findById(id);
    }
}
