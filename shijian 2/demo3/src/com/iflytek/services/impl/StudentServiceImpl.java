package com.iflytek.services.impl;

import com.iflytek.dao.StudentDao;
import com.iflytek.dao.impl.StudentDaoImpl;
import com.iflytek.pojo.Student;
import com.iflytek.services.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao=new StudentDaoImpl();

    @Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    @Override
    public void findAllStudent() {
       List<Student>stus= studentDao.findAllStudent();
       stus.forEach(student -> {
           System.out.println(student);
       });
    }
}
