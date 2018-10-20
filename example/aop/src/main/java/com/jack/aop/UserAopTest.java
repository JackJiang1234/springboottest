package com.jack.aop;

import com.jack.aop.example.User;
import com.jack.aop.example.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserAopTest {
    private UserService userService;

    @Autowired
    public UserAopTest(UserService service) {
        this.userService = service;
    }

    public void execute(){
        User u = new User();
        u.setId("1");
        u.setName("jack");
        u.setNote("just for test");
        this.userService.printUser(u);
    }
}
