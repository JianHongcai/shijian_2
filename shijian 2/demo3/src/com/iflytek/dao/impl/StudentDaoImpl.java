package com.iflytek.dao.impl;

import com.iflytek.dao.StudentDao;
import com.iflytek.pojo.Student;
import com.iflytek.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void addStudent(Student student) {

        try {
            Connection conn = JdbcUtil.getConnection();
            String sql = "insert into tb_student(sid,sname,addr,age) values('" + student.getSid() + "','" + student.getSname()
                    + "','" + student.getAddr() + "'," + student.getAge() + ")";
            PreparedStatement ps = conn.prepareStatement(sql);
            int i=ps.executeUpdate();
            System.out.println(i);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Student> findAllStudent() {

        try {
            Connection conn = JdbcUtil.getConnection();
            String sql = "select * from tb_student";
            PreparedStatement ps = conn.prepareStatement(sql);
           ResultSet rs= ps.executeQuery();
           List<Student>stus=new ArrayList<Student>();
           while (rs.next()){
               Student student=new Student();
               student.setId(rs.getInt("id"));//id的值
               student.setSid(rs.getString("sid"));//学号的值
               student.setSname(rs.getString("sname"));//学生姓名的值
               student.setAddr(rs.getString("addr"));//地址
               student.setAge(rs.getInt("age"));//年龄
               stus.add(student);
           }

            return stus;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
