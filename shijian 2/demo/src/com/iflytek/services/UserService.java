package com.iflytek.services;

import com.iflytek.pojo.User;

/**
 * interface:接口——>接口内都是抽象方法——>没有方法体的方法叫抽象方法——>{}方法体
 *                  访问权限修饰符可以默认不写：默认public
 */
public interface UserService {

    /**
     * 注册   参数两个：String  name   String password   在接口中申明方法，方法有无方法体
     */
    //访问权限修饰符    方法的返回值    方法名称  (参数列表){}
     void reg(String name,String password);



     //登录的方法   根据用户名和密码去查询信息
     User login(String name ,String password);


    /**
     * 判断用户名是否存在
     */
     boolean checkName(String name);
}
