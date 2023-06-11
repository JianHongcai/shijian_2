package com.iflytek.services.impl;

import com.iflytek.dao.UserDao;
import com.iflytek.dao.impl.UserDaoImpl;
import com.iflytek.pojo.User;
import com.iflytek.services.UserService;

public class UserServiceImpl implements UserService {


    private  UserDao userDao=new UserDaoImpl();

    @Override
    public User checkNameIsOk(String name) {
       User u= userDao.findUserByName(name);

        return u;
    }

    @Override
    public void regUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public User login(String name, String upwd) {
        User u=userDao.findUserByNameAndUpwd(name,upwd);
        return u;
    }
}
