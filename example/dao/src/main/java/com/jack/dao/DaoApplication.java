package com.jack.dao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
public class DaoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DaoApplication.class, args);
        DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getClass().getSimpleName());
    }
}
