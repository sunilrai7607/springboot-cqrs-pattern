package com.sbr.rest.api.pattern.repository;

import com.sbr.rest.api.pattern.model.UserAddress;
import com.sbr.rest.api.pattern.model.UserContact;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class UserReadRepository {

    private Map<String, UserAddress> userAddress = new ConcurrentHashMap<>();

    private Map<String, UserContact> userContact = new ConcurrentHashMap<>();

    public void addUserAddress(String id, UserAddress user) {
        userAddress.put(id, user);
    }

    public UserAddress getUserAddress(String id) {
        return userAddress.get(id);
    }

    public void addUserContact(String id, UserContact user) {
        userContact.put(id, user);
    }

    public UserContact getUserContact(String id) {
        return userContact.get(id);
    }

}
