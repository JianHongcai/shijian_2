package com.iflytek.test;

import com.iflytek.dao.TeacherDao;
import com.iflytek.dao.impl.TeacherDaoImpl;
import com.iflytek.pojo.Teacher;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        //创建dao接口的实例化对象
        TeacherDao td=new TeacherDaoImpl();
//        List<Teacher> teachers= td.findAll();
//        teachers.forEach(teacher -> {
//            System.out.println(teacher);
//        });


        //增加一个teacher信息
//        Teacher teacher=new Teacher();
//        teacher.setName("韩淘");
//        teacher.setPassword("111222");
//        teacher.setSex("女");
//        teacher.setAge(20);
//        teacher.setPhone("119");
//        td.addTeacher(teacher);



        //删除
//        td.deleteTeacher(350);


        String name="周杰伦";
        Integer id=346;
        td.updateTeacher(id,name);


    }

}
