package com.sbr.rest.api.pattern.model.dtos.commands;

import lombok.Data;

@Data
public class UserRegisterCommandDto {

    private String username;

    private String email;

    private String password;
}
