package com.jie.dao;

import com.jie.pojo.User;

import java.util.*;

public interface UserMapper {
    // 根据Id查询用户
    User getUserById(int id);

    //选择全部用户实现分页
    List<User> selectUser(Map<String,Integer> map);

}
