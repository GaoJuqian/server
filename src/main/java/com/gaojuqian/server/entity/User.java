package com.gaojuqian.server.entity;
import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class User {
    @NotNull(message = "name is null")
    private String name;
    @NotNull(message = "password is null")
    private String password;
}
