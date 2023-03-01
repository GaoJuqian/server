package com.gaojuqian.server.mapper;

import com.gaojuqian.server.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> selectUserList();

    User selectUserById(Integer id);
}
