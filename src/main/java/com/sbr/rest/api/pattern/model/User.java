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
    private String username;
    private String email;
    private String password;
    private Set<Contact> contacts;
    private Set<Address> addresses;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }
}
