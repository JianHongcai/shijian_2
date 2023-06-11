package com.iflytek.services;

import com.iflytek.pojo.User;

public interface UserService {

    /**
     * 校验用户名唯一
     */
    User checkNameIsOk(String name);


    /**
     * 用户注册
     */
    void regUser(User user);


    /**
     * 登录
     */
    User login(String name,String upwd);

}
