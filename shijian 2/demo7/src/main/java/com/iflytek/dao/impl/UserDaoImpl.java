package com.iflytek.dao.impl;

import com.iflytek.dao.UserDao;
import com.iflytek.pojo.User;
import com.iflytek.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {
    @Override
    public User findUserByName(String name) {

        try {
            //1:获取数据库的连接对象
            Connection conn = JdbcUtil.getConnection();
            //2：准备sql
            String sql = "select * from tb_user where name='" + name + "'";
            //3:根据数据库的连接对象和sql语句的参数获取执行sql语句的执行对象
            PreparedStatement ps = conn.prepareStatement(sql);
            //4：执行sql,获取sql结果
           ResultSet rs= ps.executeQuery();
            //5：分析结果
            User user=null;

            if(rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
            }

            return user;



        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addUser(User user) {

        try {
            Connection conn = JdbcUtil.getConnection();

            String sql = "insert into tb_user (name,password,email,phone) values('"
                    + user.getName() + "','" + user.getPassword() + "','" + user.getEmail() + "','"
                    + user.getPhone() + "')";

            PreparedStatement ps = conn.prepareStatement(sql);
           int i= ps.executeUpdate();
            System.out.println(i);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public User findUserByNameAndUpwd(String name, String upwd) {
        try {
            //1:获取数据库的连接对象
            Connection conn = JdbcUtil.getConnection();
            //2：准备sql
            String sql = "select * from tb_user where name='"+name+"' and password='"+upwd+"'";
            //3:根据数据库的连接对象和sql语句的参数获取执行sql语句的执行对象
            PreparedStatement ps = conn.prepareStatement(sql);
            //4：执行sql,获取sql结果
            ResultSet rs= ps.executeQuery();
            //5：分析结果
            User user=null;

            if(rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("phone"));
            }

            return user;



        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
