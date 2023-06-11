package com.iflytek.dao.impl;


import com.iflytek.dao.UserDao;
import com.iflytek.pojo.User;
import com.iflytek.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDaoImpl implements UserDao {



    @Override
    public void addUser(User user) {

       try {
           /**
            * 1:获取数据库的连接对象
            */
           Connection conn = JdbcUtil.getConnection();
           String sql = "insert into tb_user(name,password) values ('" + user.getName() + "','" + user.getPassword() + "')";
           PreparedStatement ps = conn.prepareStatement(sql);
           int i=ps.executeUpdate();
           System.out.println(i);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    @Override
    public User findUserByNameAndUpwd(String name, String password) {



        try {


            Connection conn = JdbcUtil.getConnection();

            String sql = "select * from tb_user where name='" + name + "' and password='" + password + "'";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs=ps.executeQuery();

            User user=new User();
            while (rs.next()){
                user.setId( rs.getInt("id"));//id的值
                user.setName(rs.getString("name"));//name的值
                user.setPassword(rs.getString("password"));//password的值
            }

            return user;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }
}
