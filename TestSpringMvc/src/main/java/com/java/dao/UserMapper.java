package com.java.dao;

import java.util.List;

import com.java.entity.User;
/**
 * dao层
 * @author nj
 *
 */
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User user);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);
    
    /**
     * 获得所有的用户
    * @Title: users
    * @Description: 
    * @param @return    
    * @return List<User>    
    * @throws
    * @author 倪军
     */
    List<User> getUsers(User user);
}