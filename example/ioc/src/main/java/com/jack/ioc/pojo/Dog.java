package com.jack.ioc.pojo;

import com.jack.ioc.pojo.definition.Animal;
import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {
    @Override
    public void user() {
        System.out.println("dog user.");
    }
}
