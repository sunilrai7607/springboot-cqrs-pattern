package com.sbr.rest.api.pattern.aggregates;

import com.sbr.rest.api.pattern.commands.CreateUserCommand;
import com.sbr.rest.api.pattern.events.Event;
import com.sbr.rest.api.pattern.events.UserCreateEvent;
import com.sbr.rest.api.pattern.model.User;
import com.sbr.rest.api.pattern.repository.EventStore;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class UserAggregate {

    private final EventStore eventStore;

    @Autowired
    public UserAggregate(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    public List<Event> handleCreateUserCommand(CreateUserCommand createUserCommand) {
        UserCreateEvent userCreateEvent = new UserCreateEvent(new User(createUserCommand.getUserId(), createUserCommand.getFirstName(), createUserCommand.getLastName()));
        eventStore.addEvent(createUserCommand.getUserId(), userCreateEvent);
        return Arrays.asList(userCreateEvent);
    }
}
