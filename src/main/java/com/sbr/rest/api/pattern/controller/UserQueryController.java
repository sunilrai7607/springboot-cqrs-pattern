package com.sbr.rest.api.pattern.controller;

import com.sbr.rest.api.pattern.model.dtos.queries.UserQueryDto;
import com.sbr.rest.api.pattern.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserQueryController {

    private final UserQueryService userQueryService;

    @Autowired
    public UserQueryController(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }


    @GetMapping
    public ResponseEntity<List<UserQueryDto>> getUserLists() {
        return ResponseEntity.ok(userQueryService.getAllUsers());
    }


}
