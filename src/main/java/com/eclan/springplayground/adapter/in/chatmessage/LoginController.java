package com.eclan.springplayground.adapter.in.chatmessage;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
class LoginController {
    
    @GetMapping("/api/v1/login")
    public String login() {
        return "Login success.";
    }
}
