import com.jie.dao.UserMapper;
import com.jie.pojo.User;
import com.jie.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test       //查询语句，查询所有用户
    public void getAll(){
        SqlSession sqlSession = null;
        try {
            //第一步：获取sqlSessionFactory对象
            sqlSession = MybatisUtil.getSqlSession();
            //执行SQL
            //方式一：getMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getAllUser();

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

    @Test       //查询语句，查询所有用户
    public void getById(){
        SqlSession sqlSession = null;
        try {
            //第一步：获取sqlSessionFactory对象
            sqlSession = MybatisUtil.getSqlSession();

            //执行SQL
            //方式一：getMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = mapper.selectUserById(5);

            System.out.println(user);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }

    @Test       //查询语句，查询所有用户
    public void addUser(){

        SqlSession sqlSession = null;
        try {
            //第一步：获取sqlSessionFactory对象
            sqlSession = MybatisUtil.getSqlSession();

            //执行SQL
            //方式一：getMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.addUser(new User(1,"hellp","123432"));

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }

    @Test       //查询语句，查询所有用户
    public void updateUser(){
        SqlSession sqlSession = null;
        try {
            //第一步：获取sqlSessionFactory对象
            sqlSession = MybatisUtil.getSqlSession();

            //执行SQL
            //方式一：getMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.updateUser(new User(1,"baibai","123432"));

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }

    @Test       //查询语句，查询所有用户
    public void deleteUser(){
        SqlSession sqlSession = null;
        try {
            //第一步：获取sqlSessionFactory对象
            sqlSession = MybatisUtil.getSqlSession();

            //执行SQL
            //方式一：getMapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            mapper.deleteUser(1);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }
}
