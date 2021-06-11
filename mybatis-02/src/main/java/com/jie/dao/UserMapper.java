package com.jie.dao;

import com.jie.pojo.User;

public interface UserMapper {
    // 根据Id查询用户
    User getUserById(int id);
}
