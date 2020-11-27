package com.sbr.rest.api.pattern.model.dtos.commands;

import lombok.Data;

@Data
public class UserTriggerResetPasswordCommandDto {

    private String email;
}
