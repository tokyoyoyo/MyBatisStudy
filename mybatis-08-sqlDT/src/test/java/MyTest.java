import com.jie.dao.BlogMapper;
import com.jie.pojo.Blog;
import com.jie.utils.IDutils;
import com.jie.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class MyTest {

    @Test
    public void addBlogTest() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis");
        blog.setAuthor("杰哥");
        blog.setCreateTime(new Date());
        blog.setViews(1203);

        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("java");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("spring");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务");
        mapper.addBlog(blog);

        //sqlSession.commit();
        sqlSession.close();
    }


    @Test
    public void selectLike(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();

        map.put("title","微服务");
        map.put("author","杰哥");

        List<Blog> blogs = mapper.queryBlogIF(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }


    @Test
    public void queryChoose(){

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();

        map.put("title","spring");
        map.put("author","");
        map.put("views",1203);

        List<Blog> blogs = mapper.queryBlogChoose(map);

        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void updateBlog(){

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();

        map.put("title","三天之内改了你");
        map.put("author","shug");
        map.put("id","c999d93f873149d7af7233eb4da0ad9f");

        int i = mapper.updateBlog(map);

        if ((i>0)) {
            System.out.println("更改成功");
        }

        sqlSession.close();
    }


    @Test
    public void test(){

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();

        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(4);
        map.put("ids",ids);

        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    @Test
    public void del(){

        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        if (mapper.deleteAll() > 0){
            System.out.println("删除成功");
        }

        sqlSession.close();
    }

}
