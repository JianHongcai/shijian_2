package com.iflytek.services;

import com.iflytek.pojo.Student;

public interface StudentService {

    /**
     * 添加学生
     * @param student
     */
    void addStudent(Student student);


    /**
     * 查询全部的学生信息，输出打印
     */
    void findAllStudent();

}
