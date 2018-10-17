package com.jack.ioc.pojo;

import com.jack.ioc.pojo.definition.Animal;
import com.jack.ioc.pojo.definition.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BussinessPerson implements Person {
    @Autowired
    @Qualifier("dog")
    private Animal animal;

    @Override
    public void service() {
        this.animal.user();
    }

    @Override
    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
