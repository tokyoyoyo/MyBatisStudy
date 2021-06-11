import com.jie.dao.StudentMapper;
import com.jie.dao.TeacherMapper;
import com.jie.pojo.Student;
import com.jie.pojo.Teacher;
import com.jie.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {

    @Test
    public void testTeacher(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void testGetStudent(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent();

        for (Student stu : student) {
            System.out.println(stu);
        }
        sqlSession.close();
    }
}
