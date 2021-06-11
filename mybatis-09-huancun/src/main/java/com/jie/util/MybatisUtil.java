package com.jie.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        //使用mybatis     第一步：获取sqlSessionFactory对象
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //通过SqlSessionFactory 对象可以获得SqlSession对象
    //SqlSession包含了面向数据库执行sql命令需要的所有方法

    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession(true);
    }
}
