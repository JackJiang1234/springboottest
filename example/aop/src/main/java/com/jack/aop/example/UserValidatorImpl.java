package com.jack.aop.example;

public class UserValidatorImpl implements UserValidator {
    @Override
    public boolean validate(User user) {
        System.out.println("import new interface:" + UserValidator.class.getSimpleName());
        return user != null;
    }
}
