package com.nighthawk.spring_portfolio.mvc.Login;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        // Perform authentication logic
        // Check username and password against your database or authentication service

        // For demonstration purposes, let's assume a simple username and password
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if ("exampleUser".equals(username) && "examplePassword".equals(password)) {
            return "Login successful!";
        } else {
            return "Login failed. Invalid username or password.";
        }
    }
}
