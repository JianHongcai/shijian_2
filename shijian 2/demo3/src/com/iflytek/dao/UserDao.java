package com.iflytek.dao;


import com.iflytek.pojo.User;

public interface UserDao {


    /**
     * 注册——>添加(插入数据)
     */
    void addUser(User user);


    /**
     * 根据用户名和密码来进行登录
     */
    User findUserByNameAndUpwd(String name,String password);
}
