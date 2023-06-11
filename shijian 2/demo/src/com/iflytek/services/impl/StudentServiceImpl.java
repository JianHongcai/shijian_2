package com.iflytek.services.impl;

import com.iflytek.pojo.Student;
import com.iflytek.services.StudentService;

import java.util.HashMap;
import java.util.Map;

public class StudentServiceImpl implements StudentService {


    //map集合：专门存储学生的信息
    public static final Map<String,Student> map=new HashMap<String,Student>();

    //添加学生
    @Override
    public void addStudent(Student student) {
        //
        map.put(student.getSid(),student);
    }

    @Override
    public void showAllStudent() {
        /**
         * 展示学生列表——>遍历学生的集合信息——>遍历map集合
         */
//        for (String str:map.keySet()){
//            System.out.println(map.get(str));
//        }

        //效率更快
        map.keySet().forEach(str->{
            Student student=  map.get(str);
            System.out.println(student);
        });




    }

    @Override
    public void deleteStudent(String sid) {
        //判断学号目前在不在集合中；若在才会删除，若不在则没必要删除
       boolean f= map.containsKey(sid);
       if(f){
            map.remove(sid);
       }
    }

    @Override
    public boolean updateStudent(Student student) {
        /**
         * 1：修改学生——>前提是学生信息已经存进去了，需要修改掉
         */
       boolean f= map.containsKey(student.getSid());
       if(f){
           //获取原来存储的对象信息
          Student stu= map.get(student.getSid());
          //替换属性值（值来自传进来的参数对象student）
          stu.setSname(student.getSname());
          stu.setAddr(student.getAddr());
          stu.setAge(student.getAge());

          return true;
       }else{
           return false;
       }
    }
}
