package com.sbr.rest.api.pattern.model;

import lombok.Data;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class UserContact {

    private Map<String, Set<Contact>> contactByType = new ConcurrentHashMap<>();
}
