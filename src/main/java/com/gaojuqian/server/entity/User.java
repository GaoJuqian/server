package com.gaojuqian.server.entity;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class User {
    @NotNull(message = "name is null")
    private String name;
    @NotNull(message = "password is null")
    private String password;
}
