package com.sbr.rest.api.pattern.aggregates;

import com.sbr.rest.api.pattern.commands.UserRegistrationCommand;
import com.sbr.rest.api.pattern.model.events.Event;
import com.sbr.rest.api.pattern.model.events.UserRegistrationEvent;
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

    public List<Event> handleUserRegistrationCommand(UserRegistrationCommand userRegistrationCommand) {
        UserRegistrationEvent userRegistrationEvent = new UserRegistrationEvent(new User(userRegistrationCommand.getUsername(), userRegistrationCommand.getEmail(), userRegistrationCommand.getPassword()));
        eventStore.addEvent(userRegistrationCommand.getUsername(), userRegistrationEvent);
        return Arrays.asList(userRegistrationEvent);
    }
}
