package com.nchu.countryside.dao;

import com.nchu.countryside.domain.entity.User;
import org.apache.ibatis.annotations.Select;

/**
 * @author Potter
 */
public interface UserMapper {

    /**
     * 通过id查询
     * @param id
     * @return
     */
    @Select("select * from user where id = #{id}")
    User findUserById(Long id);

    /**
     * 根据名字查询用户信息
     * @param name
     * @return
     */
    User findUserByName(String name);
}
