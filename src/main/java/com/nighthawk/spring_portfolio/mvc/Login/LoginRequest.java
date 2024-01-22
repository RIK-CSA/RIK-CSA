package com.nighthawk.spring_portfolio.mvc.Login;

public class LoginRequest {
    private String username;
    private String password;

    // Getters and setters

    // Constructor
    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}
