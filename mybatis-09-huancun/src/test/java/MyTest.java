import com.jie.dao.UserMapper;
import com.jie.pojo.User;
import com.jie.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class MyTest {

    @Test
    public void selectAll(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(2);
        System.out.println(user);
        System.out.println("========================");
        User user2 = mapper2.queryUserById(3);
        System.out.println(user2);
        System.out.println(user == user2);
        sqlSession.close();
    }

    @Test
    public void change(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user1 = mapper.queryUserById(3);
        System.out.println(user1);

        System.out.println("========================");

        HashMap map = new HashMap();
        map.put("name","杰哥");
        map.put("id",4);
        mapper.updateUser(map);

        User user2 = mapper.queryUserById(3);
        System.out.println(user2);

        System.out.println(user1 == user2);
        sqlSession.close();

    }

    @Test
    public void diy(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user1 = mapper.queryUserById(3);
        System.out.println(user1);

        System.out.println("========================");
        sqlSession.clearCache();

        User user2 = mapper.queryUserById(3);
        System.out.println(user2);

        System.out.println(user1 == user2);
        sqlSession.close();
    }

    @Test
    public void two(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        SqlSession sqlSession2 = MybatisUtil.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);

        User user1 = mapper.queryUserById(3);
        System.out.println(user1);
        sqlSession.close();
        System.out.println("========================");

        User user2 = mapper2.queryUserById(3);
        System.out.println(user2);

        System.out.println(user1 == user2);

        sqlSession2.close();
    }



}



