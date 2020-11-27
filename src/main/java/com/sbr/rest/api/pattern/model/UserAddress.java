package com.sbr.rest.api.pattern.model;

import lombok.Data;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Data
public class UserAddress {

    private Map<String, Set<Address>> addressByRegion = new ConcurrentHashMap<>();

}
