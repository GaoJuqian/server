package com.gaojuqian.server.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Integer id;
    @NotNull(message = "name is null")
    private String name;
    @NotNull(message = "password is null")
    private String password;
}
