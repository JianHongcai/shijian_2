package com.iflytek.dao.impl;

import com.iflytek.dao.TeacherDao;
import com.iflytek.pojo.Teacher;
import com.iflytek.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TeacherDaoImpl implements TeacherDao {



    @Override
    public List<Teacher> findAll() {
        List<Teacher> teachers = new ArrayList<Teacher>();
        //调用jdbcUtil工具类中获取数据库连接对象的方法——>获取数据库连接对象
        try {
            Connection conn = JdbcUtil.getConnection();
            //准备需要执行的sql语句
            String sql = "select * from tb_teacher";
            //利用数据库的连接对象   获取到   执行sql语句的对象
            PreparedStatement ps = conn.prepareStatement(sql);
            //利用   执行sql语句的对象  执行sql语句   获取sql语句的返回结果
            ResultSet rs = ps.executeQuery();

            //创建list集合对象；装查询出来的数据库中的对象信息

            //分析返回的结果对象；获取数据库中对应的数据
            while (rs.next()) {

                /**
                 * 已经拿到了数据库中所有的数据，共两行数据
                 * 将每行数据封装成一个teacher对象；共两个teacher对象
                 */
                Teacher teacher = new Teacher();
                //获取每一列的值

                //获取id列的值
                int id = rs.getInt("id");
                //将id的值赋给teacher对象中的id的值
                teacher.setId(id);
                teacher.setName(rs.getString("t_name"));//名称
                teacher.setPassword(rs.getString("t_password"));//密码
                teacher.setSex(rs.getString("t_sex"));//性别
                String age = rs.getString("age");
                if (age != null) {
                    teacher.setAge(Integer.valueOf(age));
                }

                teacher.setPhone(rs.getString("phone"));//手机号
                teacher.setEmail(rs.getString("email"));//邮箱
                teacher.setBalanace(rs.getString("balanace"));//余额
                teacher.setNumber(rs.getString("number"));//工号
                teacher.setAddress(rs.getString("address"));//地址

                //将查询出来的结果存在集合中
                teachers.add(teacher);

            }


            return teachers;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public void addTeacher(Teacher teacher) {

        try {
            //1:获取数据库的连接对象
            Connection conn = JdbcUtil.getConnection();
            //2:准备sql语句
            String sql = "insert into tb_teacher(t_name,t_password,t_sex,age,phone) " +
                    "values('" + teacher.getName() + "'," + teacher.getPassword() + ",'" + teacher.getSex() + "',"
                    + teacher.getAge() + "," + teacher.getPhone() + ")";
            System.out.println(sql);
            //3:根据连接对象获取执行sql语句的执行对象
            PreparedStatement ps = conn.prepareStatement(sql);
            //4:执行sql语句
           int i= ps.executeUpdate();//受影响的行数
            System.out.println(i);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTeacher(Integer id) {
      try {
          /**
           * 1:获取数据库的连接对象
           */
          Connection conn = JdbcUtil.getConnection();
          //2：准备sql语句
          String sql = "delete from tb_teacher where id=" + id;

          //3:根据数据库的连接对象 利用sql语句得到执行sql的执行对象
          PreparedStatement ps = conn.prepareStatement(sql);
          //4:执行sql
          int i=ps.executeUpdate();
          System.out.println(i);
      }catch (Exception e){
          e.printStackTrace();
      }
    }

    @Override
    public void updateTeacher(Integer id, String name) {

        try {
            //1:获取数据库的连接对象
            Connection conn = JdbcUtil.getConnection();
            //2：准备sql语句
            String sql = "update tb_teacher set t_name='" + name + "' where id=" + id;
            //3:利用数据库的连接对象 和sql语句获取执行对象
            PreparedStatement ps = conn.prepareStatement(sql);
            //4:执行sql语句
           int i= ps.executeUpdate();
            System.out.println(i);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
