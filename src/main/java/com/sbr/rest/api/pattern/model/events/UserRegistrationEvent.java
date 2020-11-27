package com.sbr.rest.api.pattern.model.events;

import com.sbr.rest.api.pattern.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserRegistrationEvent extends Event {

    private User user;

    public UserRegistrationEvent(User user) {
        super("UserRegistrationEvent");
        this.user = user;
    }
}
