package com.jie.dao;

import com.jie.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    int addBlog(Blog blog);

    //查询博客
    List<Blog> queryBlogIF(Map map);

    //
    List<Blog> queryBlogChoose(Map map);

    //更新博客
    int updateBlog(Map map);

    //查询第1-3号记录的博客
    List<Blog> queryBlogForeach(Map map);

    int deleteAll();
}
