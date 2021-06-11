package com.jie.dao;

import com.jie.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User queryUserById(@Param("id") int id);


    //修改用户
    int updateUser(Map map);
}
