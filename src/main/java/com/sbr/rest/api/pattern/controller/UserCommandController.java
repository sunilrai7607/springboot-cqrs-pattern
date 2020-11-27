package com.sbr.rest.api.pattern.controller;

import com.sbr.rest.api.pattern.model.request.UserRequestDto;
import com.sbr.rest.api.pattern.service.UserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/users")
public class UserCommandController {

    private final UserCommandService userCommandService;

    @Autowired
    public UserCommandController(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    @PostMapping(value = "/registration", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> registration(@RequestBody UserRequestDto userRequestDto) {
        userCommandService.registerNewUser(userRequestDto);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
