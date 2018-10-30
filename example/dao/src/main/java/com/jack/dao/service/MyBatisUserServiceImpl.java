package com.jack.dao.service;

import com.jack.dao.dao.MyBatisUserDao;
import com.jack.dao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBatisUserServiceImpl implements MyBatisUserService {
    @Autowired
    private MyBatisUserDao myBatisUserDao = null;

    @Override
    public User getUser(Long id) {
        return this.myBatisUserDao.getUser(id);
    }
}
