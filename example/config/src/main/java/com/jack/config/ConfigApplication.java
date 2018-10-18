package com.jack.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
//@PropertySource(value = {"classpath:jdbc.properties"}, ignoreResourceNotFound = true)
public class ConfigApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ConfigApplication.class, args);

        DataBaseProperties config = context.getBean(DataBaseProperties.class);
        System.out.println(config);

        DataBaseProperties2 config2 = context.getBean(DataBaseProperties2.class);
        System.out.println(config2);
    }
}
