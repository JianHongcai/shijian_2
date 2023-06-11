package com.iflytek.dao;

import com.iflytek.pojo.Teacher;

import java.util.List;

public interface TeacherDao {


    /**
     * 查询全部的teacher信息——>
     * 见名知意
     *
     */
    //访问权限修饰符   方法的返回值  方法名称()
    List<Teacher> findAll();


    /**
     * 增加teacher进入数据库
     */
     void addTeacher(Teacher teacher);


     //删除和修改

    /**
     * 根据主键编号id  去删除信息
     */
    void deleteTeacher(Integer id);



    //修改
    /**
     * 根据id 348  去修改用户名；改成彭伟
     */
    void updateTeacher(Integer id,String name);

}
