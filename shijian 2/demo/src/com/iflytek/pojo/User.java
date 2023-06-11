package com.iflytek.pojo;

/**
 * 用户的实体类
 * 1：属性名称
 * 2：标准的5套——>getter setter方法  toString()   有参无参的构造方法
 *
 *
 */
public class User {

    /**
     * 用户名
     */
    private String name;
    /**
     * 密码
     */
    private String password;


    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
