package com.nchu.countryside.service.impl;

import com.nchu.countryside.dao.UserMapper;
import com.nchu.countryside.domain.entity.User;
import com.nchu.countryside.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: countryside
 * @author: Xing guo ning
 * @description：
 * @Date: 2021-01-18 18:00
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public User findUserById(Long id) {
        User user = userMapper.findUserById(id);
        return user ;
    }
}
