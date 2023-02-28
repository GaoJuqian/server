package com.gaojuqian.server.controller;

import com.gaojuqian.server.entity.User;
import com.gaojuqian.server.mapper.UserMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "用户")
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @Tag(name = "获取用户列表")
    @GetMapping("/user/list")
    public List<User> getUserList() {

        List<User> userList = userMapper.selectList(null);
        return userList;
    }
}
