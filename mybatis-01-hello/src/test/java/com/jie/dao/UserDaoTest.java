package com.jie.dao;

import com.jie.pojo.User;
import com.jie.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserDaoTest {
    @Test       //查询语句，查询所有用户
    public void test(){

        SqlSession sqlSession = null;
        try {
            //第一步：获取sqlSessionFactory对象
            sqlSession = MybatisUtil.getSqlSession();

            //执行SQL

            //方式一：getMapper
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            List<User> userList = mapper.getUserList();

            //方式二
//        List<User> userList = sqlSession.selectList("com.jie.dao.UserDao.getUserList");
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
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            User user = mapper.getUserById(3);

            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }

    @Test       //插入数据
    public void addUser(){
        SqlSession sqlSession = null;
        try {
            //第一步：获取sqlSessionFactory对象
            sqlSession = MybatisUtil.getSqlSession();

            //执行SQL
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            int num = mapper.addUser(new User(7,"一九九八","12345DFC"));
            //提交事务
            sqlSession.commit();
            if(num >0){
                System.out.println("已插入数据");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }

    @Test       //更改数据
    public void UpdateUser(){
        SqlSession sqlSession = null;
        try {
            //第一步：获取sqlSessionFactory对象
            sqlSession = MybatisUtil.getSqlSession();

            //执行SQL
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            int num = mapper.updateUser(new User(7,"一九三七","1pleaseC"));
            //提交事务
            sqlSession.commit();
            if(num >0){
                System.out.println("已更改数据");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }

    @Test       //删除数据
    public void deleteUser() {
        SqlSession sqlSession = null;
        try {
            //第一步：获取sqlSessionFactory对象
            sqlSession = MybatisUtil.getSqlSession();

            //执行SQL
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            int num = mapper.deleteUser(7);
            //提交事务
            sqlSession.commit();
            if (num > 0) {
                System.out.println("已删除数据");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void addUser2(){
        SqlSession sqlSession = null;
        try {
            //第一步：获取sqlSessionFactory对象
            sqlSession = MybatisUtil.getSqlSession();
            //执行SQL
            UserDao mapper = sqlSession.getMapper(UserDao.class);

            HashMap<String, Object> map = new HashMap<>();
            map.put("id",33);
            map.put("name","发李");
            map.put("pwd","12345");
            int num = mapper.addUser2(map);
            //提交事务
            sqlSession.commit();
            if(num >0){
                System.out.println("已插入数据");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void TestGetUserById2(){
        SqlSession sqlSession = null;
        try {
            //第一步：获取sqlSessionFactory对象
            sqlSession = MybatisUtil.getSqlSession();

            //执行SQL

            //方式一：getMapper
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            HashMap<String, Object> map = new HashMap<>();
            map.put("id",3);
            User user = mapper.getUserById2(map);

            System.out.println(user);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testLike(){

        SqlSession sqlSession = null;
        try {
            //第一步：获取sqlSessionFactory对象
            sqlSession = MybatisUtil.getSqlSession();

            //执行SQL

            //方式一：getMapper
            UserDao mapper = sqlSession.getMapper(UserDao.class);
            List<User> userList = mapper.getUserLike("%李%");


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

}
