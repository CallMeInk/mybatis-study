package com.kuang.pojo;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    //学生关联一个老师
    private int tid;
}
