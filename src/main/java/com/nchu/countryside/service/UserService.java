package com.nchu.countryside.service;

import com.nchu.countryside.domain.entity.User;

/**
 * @program: countryside
 * @author: Xing guo ning
 * @description：
 * @Date: 2021-01-18 17:59
 */
public interface UserService {

    /**
     * 通过id查找用户信息
     * @param id
     * @return
     */
    public User findUserById(Long id);
}
