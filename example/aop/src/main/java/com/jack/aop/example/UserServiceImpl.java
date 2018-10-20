package com.jack.aop.example;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    @Override
    public void printUser(User user) {
        if (user == null){
            throw new RuntimeException("user cannot be null.");
        }
        System.out.println(user);
    }
}
