package com.iflytek.services.impl;

import com.iflytek.pojo.User;
import com.iflytek.services.UserService;

import java.util.HashMap;
import java.util.Map;

/**
 * UserServiceImpl 实现UserService接口
 * 必须需要重写接口中的所有抽象方法
 */
public class UserServiceImpl implements UserService {

    /**
     * 创建一个map集合——>用来存储用户的信息
     * map集合：键值对的方法来存值——>夫妻对   周杰伦-昆凌；黄晓明-杨颖
     * map集合的创建方式：map本身是一个接口——>不能直接new实例化对象——>创建实现类对象
     *
     * key:用户名
     * value:该用户名的对象
     */
    public static final Map<String,User> map=new HashMap<String, User>();



    @Override//方法重写的特有标识，注解
    public void reg(String name, String password) {
        //创建map集合中的value值对象
        User user=new User();
        //通过setter给属性name赋值
        user.setName(name);
        //通过setter给属性password赋值
        user.setPassword(password);
        //map集合如何存值
        //通过put()给map集合存值
        map.put(name,user);
    }

    @Override
    public User login(String name, String password) {


        //判断map集合是否存在对应的用户名    map判断key是否存在
        //判断map集合是否存在对应的key;若存在，则返回true;若不存在，则返回假 false
        boolean f=map.containsKey(name);
        if(f){//存在
            //表示用户名对的；进行下一步处理；判断密码是否正确
            User u=map.get(name);
//            u.getPassword();//注册时用户输入的密码
//            password//登录时用户输入的密码
// equals() 方法在String类中表示的含义是判断两个字符串的值是否相同；若相同，返回true;若不同，返回false

            if(password.equals(u.getPassword())){
                return u;
            }else{
                return null;
            }
        }else{//不存在
            //说明map集合中不存在对应的用户名
            return null;
        }
    }

    @Override
    public boolean checkName(String name) {

        /**
         * 判断map集合中是否已经存在name的值作为key的
         */

        //若f为true时；表示该用户名已存在；若f为false时，表示该用户名不存在
        boolean f=map.containsKey(name);

        if(f){
            return false;
        }else{
            return true;
        }

    }
}
