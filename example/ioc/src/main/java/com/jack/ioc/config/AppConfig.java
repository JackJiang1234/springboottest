package com.jack.ioc.config;

import com.jack.ioc.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.jack.ioc.pojo"})
public class AppConfig {

    @Bean(name = "user")
    public User initUser(){
        User user = new User();
        user.setId(1L);
        user.setUserName("user_name");
        user.setNote("note1");

        return user;
    }
}