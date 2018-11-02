package com.jack.dao;

import com.jack.dao.pojo.SexEnum;
import com.jack.dao.pojo.User;
import com.jack.dao.service.JdbcService;
import com.jack.dao.service.JdbcTmplUserService;
import com.jack.dao.service.MyBatisUserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@SpringBootApplication
@MapperScan(basePackages = "com.jack.dao.*", annotationClass = Repository.class)
public class DaoApplication {

    public static void main(String[] args) {
        //testUserJdbcTemplate(args);
        //testUserMyBatis(args);
        //testUseJdbcService(args);

        testTransaction(args);
    }

    static void testChangeDataSourceType(String[] args){
        ApplicationContext ctx = SpringApplication.run(DaoApplication.class, args);
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getClass().getCanonicalName());
    }

    static void testUserJdbcTemplate(String[] args){
        ApplicationContext ctx = SpringApplication.run(DaoApplication.class, args);
        JdbcTmplUserService userService = ctx.getBean(JdbcTmplUserService.class);

        User u = new User();
        u.setUserName("jack");
        u.setSex(SexEnum.MALE);
        u.setNote("just for test.");
        System.out.println("insert user:" + userService.insertUser(u));

        List<User> users = userService.findUsers("jack", "just");
        System.out.println("count records:" + users.size());

        User u2 = userService.getUser(users.get(0).getId());
        System.out.println("get user :" + u.getUserName());

        for (User eachU: users) {
            //userService.deleteUser(eachU.getId());
        }
    }

    static void testUserMyBatis(String[] args){
        ApplicationContext ctx = SpringApplication.run(DaoApplication.class, args);
        MyBatisUserService userService = ctx.getBean(MyBatisUserService.class);
        System.out.println("mybatis get user:" + userService.getUser(Long.valueOf(8)).getUserName());
    }

    static void testUseJdbcService(String[] args){
        ApplicationContext ctx = SpringApplication.run(DaoApplication.class, args);
        JdbcService userService = ctx.getBean(JdbcService.class);
        System.out.println("testUseJdbcService:" + userService.insertUser("jack", "test"));
    }

    static void testTransaction(String[] args){
        ApplicationContext ctx = SpringApplication.run(DaoApplication.class, args);
        JdbcTmplUserService userService = ctx.getBean(JdbcTmplUserService.class);

        User u = new User();
        u.setUserName("jack");
        u.setSex(SexEnum.MALE);
        u.setNote("just for test.");
        System.out.println("insert user:" + userService.insertUser(u));
    }
}
