package com.sbr.rest.api.pattern.events;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Event {

    private final UUID id = UUID.randomUUID();

    private final Date created = new Date();

    private String eventName;

    Event(final String eventName) {
        this.eventName = eventName;
    }
}
