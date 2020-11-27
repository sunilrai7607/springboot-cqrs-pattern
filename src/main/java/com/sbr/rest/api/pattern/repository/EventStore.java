package com.sbr.rest.api.pattern.repository;

import com.sbr.rest.api.pattern.model.events.Event;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class EventStore {

    private Map<String, List<Event>> store = new ConcurrentHashMap<>();

    public void addEvent(String id, Event event) {
        List<Event> events = store.get(id);
        if (events == null) {
            events = new LinkedList<>();
            events.add(event);
            store.put(id, events);
        } else {
            events.add(event);
        }
    }

    public List<Event> getEvents(final String id) {
        return store.get(id);
    }
}
