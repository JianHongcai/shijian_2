package com.iflytek.services.impl;

import com.iflytek.dao.UserDao;
import com.iflytek.dao.impl.UserDaoImpl;
import com.iflytek.pojo.User;
import com.iflytek.services.UserService;

/**
 * services层的实现类：负责业务的处理层
 * 1：调用dao层的接口
 *
 *
 */
public class UserServiceImpl implements UserService {


    private UserDao userDao=new UserDaoImpl();


    @Override
    public void reg(User user) {
        userDao.addUser(user);
    }

    @Override
    public User login(String name, String password) {

       User u= userDao.findUserByNameAndUpwd(name,password);
        return u;
    }
}
