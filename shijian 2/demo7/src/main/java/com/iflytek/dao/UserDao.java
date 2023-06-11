package com.iflytek.dao;

import com.iflytek.pojo.User;

public interface UserDao {

    /**
     * 根据参数用户名查询   用户名是否存在
     *
     * 数据库中表的一行信息  在Java代码层面用什么表示
     *
     */

    User findUserByName(String name);


    /**
     * 注册   添加
     */
    void addUser(User user);


    /**
     * 根据用户名和密码查询用户；返回用户对象
     */
    User findUserByNameAndUpwd(String name,String upwd);


}
