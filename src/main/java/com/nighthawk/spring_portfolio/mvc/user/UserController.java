package com.nighthawk.spring_portfolio.mvc.user;

import org.springframework.web.bind.annotation.RestController;

import groovy.util.logging.Slf4j;
import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Slf4j
public class UserController {
    
    private final UserService service;

    @PostMapping
    public void register(User user) {
        service.register(user);
    }

    @PostMapping("/login")
    public User login(User user) {
        return service.login(user);
    }

    @PostMapping("/logout")
    public void logout(String email) {
        service.logout(email);
    }

    @GetMapping
    public List<User> findAll() {
        return service.findAll();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handle(Exception ex) {
        ex.printStackTrace();
        return ResponseEntity
            .status(INTERNAL_SERVER_ERROR)
            .body(ex.getMessage());
            
        
    }
}
