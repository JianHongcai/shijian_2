package com.iflytek.services;

import com.iflytek.pojo.Student;

/**
 * 普通类中不能有抽象方法
 */
public interface StudentService {

    //添加学生
    void addStudent(Student student);

    /**
     * 展示所有的学生信息
     */
    void showAllStudent();


    /**
     * 根据学号删除学生信息
     * @param sid
     */
    void deleteStudent(String sid);


    /**
     * 修改学生；返回修改成功还是失败
     * @param student
     */
    boolean updateStudent(Student student);
}
