package com.sbr.rest.api.pattern.events;

import com.sbr.rest.api.pattern.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class UserCreateEvent extends Event {

    private User user;

    public UserCreateEvent(User user) {
        super("UserCreateEvent");
        this.user = user;
    }
}
