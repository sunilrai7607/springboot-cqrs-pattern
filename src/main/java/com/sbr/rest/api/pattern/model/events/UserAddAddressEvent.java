package com.sbr.rest.api.pattern.model.events;

import com.sbr.rest.api.pattern.model.Address;
import lombok.Data;

@Data
public class UserAddAddressEvent extends Event {

    private Address address;

    public UserAddAddressEvent(Address address) {
        super("UserAddAddressEvent");
        this.address = address;
    }
}
