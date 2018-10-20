package com.jack.aop.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserAspect {

    /**
     * 切点定义
     * execution 匹配连接点的执行方法
     * arg() 限制方法参数
     * @args() 通过方法参数注解进行限定
     * this()
     * target
     * @target()
     * https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#aop-pointcuts
     * */
    @Pointcut("execution(* com.jack.aop.example.UserServiceImpl.printUser(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before() {
        System.out.println("before...");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after...");
    }

    @AfterReturning("pointCut()")
    public void afterReturning() {
        System.out.println("afterReturning...");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing...");
    }

    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around before...");
        jp.proceed();
        System.out.println("around after...");
    }
}
