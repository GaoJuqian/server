package com.gaojuqian.server.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gaojuqian.server.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User>{

    @Select("select * from user")
    public List<User> selectUserList();
}
