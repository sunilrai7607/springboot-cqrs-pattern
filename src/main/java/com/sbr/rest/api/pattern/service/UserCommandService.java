package com.sbr.rest.api.pattern.service;

import com.sbr.rest.api.pattern.aggregates.UserAggregate;
import com.sbr.rest.api.pattern.commands.UserRegistrationCommand;
import com.sbr.rest.api.pattern.model.dtos.commands.UserRegisterCommandDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserCommandService {

    private final UserAggregate userAggregate;

    @Autowired
    public UserCommandService(UserAggregate userAggregate) {
        this.userAggregate = userAggregate;
    }

    public void registerNewUser(UserRegisterCommandDto userRegisterCommandDto) {
        UserRegistrationCommand userRegistrationCommand = new UserRegistrationCommand();
        userRegistrationCommand.setEmail(userRegisterCommandDto.getEmail());
        userRegistrationCommand.setPassword(userRegisterCommandDto.getPassword());
        userRegistrationCommand.setUsername(userRegisterCommandDto.getUsername());
        userRegistrationCommand.setUserId(UUID.randomUUID().toString());
        userAggregate.handleUserRegistrationCommand(userRegistrationCommand);
    }
}
