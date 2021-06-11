package com.jie.dao;

import com.jie.pojo.User;
import com.jie.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {

    @Test       //按id查询用户
    public void TestGetUserById(){
        SqlSession sqlSession = null;
        try {
            //第一步：获取sqlSessionFactory对象
            sqlSession = MybatisUtil.getSqlSession();

            //执行SQL

            //方式一：getMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.getUserById(3);

            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭sqlSession
            sqlSession.close();
        }

    }
}
