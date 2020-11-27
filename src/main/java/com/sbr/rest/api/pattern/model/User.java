package com.sbr.rest.api.pattern.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String userId;
    private String firstName;
    private String lastName;
    private Set<Contact> contacts;
    private Set<Address> addresses;

    public User(String userId, String firstName, String lastName) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }


}
