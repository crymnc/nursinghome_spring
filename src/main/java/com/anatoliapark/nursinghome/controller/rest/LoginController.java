package com.anatoliapark.nursinghome.controller.rest;

import com.anatoliapark.nursinghome.annotation.RestApiController;
import com.anatoliapark.nursinghome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@RestApiController
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(Principal principal) {

        return "login";
    }

}