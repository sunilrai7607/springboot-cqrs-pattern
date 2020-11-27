package com.sbr.rest.api.pattern.projectors;

import com.sbr.rest.api.pattern.events.Event;
import com.sbr.rest.api.pattern.events.UserAddAddressEvent;
import com.sbr.rest.api.pattern.events.UserAddContactEvent;
import com.sbr.rest.api.pattern.model.Address;
import com.sbr.rest.api.pattern.model.Contact;
import com.sbr.rest.api.pattern.model.UserAddress;
import com.sbr.rest.api.pattern.model.UserContact;
import com.sbr.rest.api.pattern.repository.UserReadRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Component
@Slf4j
public class UserProjector {

    private final UserReadRepository userReadRepository;

    @Autowired
    public UserProjector(UserReadRepository userReadRepository) {
        this.userReadRepository = userReadRepository;
    }

    public void project(String userId, List<Event> events) {
        events.stream().forEach(event -> {
                    if (event instanceof UserAddAddressEvent)
                        apply(userId, (UserAddAddressEvent) event);
                    if (event instanceof UserAddContactEvent)
                        apply(userId, (UserAddContactEvent) event);
                }
        );
    }

    private void apply(String userId, UserAddAddressEvent event) {
        Address address = event.getAddress();
        UserAddress userAddress = Optional.ofNullable(userReadRepository.getUserAddress(userId)).orElse(new UserAddress());
        Set<Address> addresses = Optional.ofNullable(userAddress.getAddressByRegion()
                .get(address.getState()))
                .orElse(new HashSet<>());
        addresses.add(address);
        userAddress.getAddressByRegion()
                .put(address.getState(), addresses);
        userReadRepository.addUserAddress(userId, userAddress);

    }

    private void apply(String userId, UserAddContactEvent event) {
        Contact contact = event.getContact();
        UserContact userContact = Optional.ofNullable(userReadRepository.getUserContact(userId))
                .orElse(new UserContact());
        Set<Contact> contacts = Optional.ofNullable(userContact.getContactByType()
                .get(contact.getType()))
                .orElse(new HashSet<>());
        contacts.add(contact);
        userContact.getContactByType()
                .put(contact.getType(), contacts);
        userReadRepository.addUserContact(userId, userContact);
    }
}
