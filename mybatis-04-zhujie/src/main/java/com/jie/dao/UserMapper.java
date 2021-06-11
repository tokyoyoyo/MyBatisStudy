package com.jie.dao;

import com.jie.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    //查询全部用户
    @Select("select id,name,pwd as password from user")
    public List<User> getAllUser();


    //根据id查询用户
    @Select("select id,name,pwd as password from user where id = #{id}")
    User selectUserById(@Param("id") int id);

    @Insert("insert into user(`id`,`name`,`pwd`) values (#{id},#{name},#{password})")
    int addUser(User user);

    @Update("update user set name = #{name},pwd =#{password} where id =#{id}")
    int updateUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id") int id);
}
