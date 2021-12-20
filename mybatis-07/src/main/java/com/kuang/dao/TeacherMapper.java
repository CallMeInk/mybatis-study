package com.kuang.dao;

import com.kuang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    //获取所有老师
    List<Teacher> getTeacher();

    //获取指定老师及该老师下所有学生
    Teacher getTeacherByTid(@Param("tid") int tid);

    Teacher getTeacherByTid2(@Param("tid") int id);

}
