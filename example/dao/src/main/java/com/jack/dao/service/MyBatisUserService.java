package com.jack.dao.service;

import com.jack.dao.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface MyBatisUserService {
    User getUser(Long id);
}
