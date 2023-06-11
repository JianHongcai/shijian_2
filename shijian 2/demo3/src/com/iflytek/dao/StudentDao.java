package com.iflytek.dao;

import com.iflytek.pojo.Student;

import java.util.List;

public interface StudentDao {

    /**
     * 添加学生
     */
    void addStudent(Student student);


    /**
     * 查询全部学生信息
     */
    List<Student> findAllStudent();



}
