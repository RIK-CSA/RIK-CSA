package com.nighthawk.spring_portfolio.mvc.user;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;


@Service
public class UserService {

    private static final List<User> USERS_LIST = new ArrayList<>();

    public void register(User user) {
        user.setStatus("online");
        USERS_LIST.add(user);
    }

    public User login(String email, String password) {
        User user = USERS_LIST.stream()
                .filter(u -> u.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Password incorrect");
        }

        user.setStatus("online");
        return user;
    }


    public void logout(String email) {
        var userIndex = IntStream.range(0, USERS_LIST.size())
            .filter(i -> USERS_LIST.get(i).getEmail().equals(email))
            .findAny()
            .orElseThrow(() -> new RuntimeException("User not found"));
        USERS_LIST.get(userIndex).setStatus("offline");
    }

    public List<User> findAll() {
        return USERS_LIST;
    }
    
}
