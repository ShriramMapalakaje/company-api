package org.example.companyapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.companyapi.dto.UserLoginDto;
import org.example.companyapi.dto.UserLoginRespDto;
import org.example.companyapi.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/c2d/api/v1/user")
public class UserController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody UserLoginDto userLoginDto){
        log.info("Inside Login User Method");
        UserLoginRespDto loginResp = authService.loginUser(userLoginDto);
        return new ResponseEntity(loginResp, HttpStatus.OK);
    }
}