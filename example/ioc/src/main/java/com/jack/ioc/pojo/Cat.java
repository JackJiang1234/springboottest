package com.jack.ioc.pojo;

import com.jack.ioc.pojo.definition.Animal;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Cat implements Animal {
    @Override
    public void user() {
        System.out.println("cat user");
    }
}
