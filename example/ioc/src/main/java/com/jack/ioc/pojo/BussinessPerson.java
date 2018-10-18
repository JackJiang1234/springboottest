package com.jack.ioc.pojo;

import com.jack.ioc.pojo.definition.Animal;
import com.jack.ioc.pojo.definition.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BussinessPerson implements Person {

    private Animal animal;

    @Override
    public void service() {
        this.animal.user();
    }

    @Override
    @Autowired
    @Qualifier("dog")
    public void setAnimal(Animal animal) {
        System.out.println("delay inject test.");
        this.animal = animal;
    }
}
