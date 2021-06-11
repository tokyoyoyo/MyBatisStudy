package com.jie.dao;

import com.jie.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    //模糊查询
    List<User> getUserLike(String value);
    //获取所有用户
    List<User> getUserList();
    // 根据Id查询用户
    User getUserById(int id);
    //利用map传参
    User getUserById2(Map<String,Object> map);
    //insert一个用户
    int addUser(User user);
    //Map的用法
    int addUser2(Map<String,Object> map);
    //更改一个用户
    int updateUser(User user);
    //删除用户
    int deleteUser(int id);
}
