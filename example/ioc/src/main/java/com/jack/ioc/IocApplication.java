package com.jack.ioc;

import com.jack.ioc.config.AppConfig;
import com.jack.ioc.pojo.BussinessPerson;
import com.jack.ioc.pojo.User;
import com.jack.ioc.pojo.User2;
import com.jack.ioc.pojo.definition.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class IocApplication {

    public static void main(String[] args) {
        basicAnnotationConfigTest();
        autoScanTest();
        basicDependencyInjectionTest();
    }

    private static void basicAnnotationConfigTest(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = ctx.getBean(User.class);
        System.out.println(user.getId());
    }

    private static void autoScanTest(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        User2 user = ctx.getBean(User2.class);
        System.out.println(user.getUserName());
    }

    private static void basicDependencyInjectionTest(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Person person = ctx.getBean(BussinessPerson.class);
        person.service();
    }
}
