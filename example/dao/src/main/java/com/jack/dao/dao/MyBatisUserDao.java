package com.jack.dao.dao;

import com.jack.dao.pojo.User;
import org.springframework.stereotype.Repository;

@Repository
public interface MyBatisUserDao {
    User getUser(Long id);
}
