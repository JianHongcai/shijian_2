package com.iflytek.services;

import com.iflytek.pojo.User;

public interface UserService {

    /**
     * 注册
     * @param user
     */
    void reg(User user);

    /**
     * 登录
     * @param name
     * @param password
     * @return
     */
    User login(String name,String password);

}
