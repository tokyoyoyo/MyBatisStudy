package com.jie.dao;

import com.jie.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {
    //获取指定老师
    public Teacher getTeacher(int id);

    //获取指定老师，及老师下的所有学生
    Teacher getTeacherStudents(@Param("tid") int id);

    Teacher getTeacherStudents2(@Param("tid") int id);
}
