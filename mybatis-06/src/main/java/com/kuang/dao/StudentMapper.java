package com.kuang.dao;

import com.kuang.pojo.Student;

import java.util.List;

public interface StudentMapper {

    //查出所有的学生以及学生对应的老师
    List<Student> getStudent();

    List<Student> getStudent2();

}
