package com.sbr.rest.api.pattern.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistrationCommand {

    private String userId;

    private String username;

    private String email;

    private String password;
}
