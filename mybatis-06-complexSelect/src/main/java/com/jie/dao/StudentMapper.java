package com.jie.dao;

import com.jie.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    //@Select("SELECT `s.id` `s.name` `t.name` FROM student AS s ,teacher AS t where s.id = t.id  ")
    //查询学生及老师信息
    public List<Student> getStudent();

    public List<Student> getStudent2();
}
