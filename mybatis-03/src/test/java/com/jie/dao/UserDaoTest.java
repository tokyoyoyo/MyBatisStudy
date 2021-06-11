package com.jie.dao;

import com.jie.pojo.User;
import com.jie.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {

    //加载日志对象，参数为当前类的class
    static Logger logger = Logger.getLogger(UserDaoTest.class);


    @Test
    public void log4jTest(){
        logger.info("info:进入了log4jTest");
        logger.debug("debuge:进入了log4jTest");
        logger.error("error:进入了log4jTest");
    }

    @Test
    public void getUserByLimit() {

        SqlSession sqlSession = null;
        try {
            //第一步：获取sqlSessionFactory对象
            sqlSession = MybatisUtil.getSqlSession();

            //执行SQL

            //方式一：getMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            HashMap<String, Integer> map = new HashMap<>();
            map.put("startIndex", 0);
            map.put("pageSize", 3);

            List<User> userList = mapper.selectUser(map);
            for (User user : userList) {
                System.out.println(user);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }

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
