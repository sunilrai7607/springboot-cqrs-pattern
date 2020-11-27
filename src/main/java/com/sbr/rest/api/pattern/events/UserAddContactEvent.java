package com.sbr.rest.api.pattern.events;

import com.sbr.rest.api.pattern.model.Contact;
import lombok.Data;

@Data
public class UserAddContactEvent extends Event {

    private Contact contact;

    public UserAddContactEvent(Contact contact) {
        super("UserAddContactEvent");
        this.contact = contact;
    }
}
