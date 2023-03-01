package com.gaojuqian.server.controller;

import com.gaojuqian.server.entity.User;
import com.gaojuqian.server.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "用户")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Operation(summary = "获取用户列表")
    @GetMapping("/user/list")
    public List<User> getUserList() {
        List<User> userList = userService.getUserList();
        return userList;
    }

    @Operation(summary = "获取用户")
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Integer id) {
        User user = userService.getUser(id);
        return user;
    }

}
