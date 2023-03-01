package com.gaojuqian.server.service.impl;

import com.gaojuqian.server.entity.User;
import com.gaojuqian.server.mapper.UserMapper;
import com.gaojuqian.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        List<User> userList = userMapper.selectUserList();
        return userList;
    }

    @Override
    public User getUser(Integer id) {
        User user = userMapper.selectUserById(id);
        return user;
    }
}
