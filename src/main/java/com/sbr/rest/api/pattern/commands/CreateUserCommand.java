package com.sbr.rest.api.pattern.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserCommand {

    private String userId;
    private String firstName;
    private String lastName;
}
