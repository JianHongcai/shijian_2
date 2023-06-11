package com.iflytek.pojo;

public class Student {

    /**
     * 学号
     */
    private String sid;


    /**
     * 姓名
     */
    private String sname;

    /**
     * 家庭地址
     */
    private String addr;

    /**
     * 年龄
     */
    private int age;


    /**
     * 重写toString方法；
     * toString方法的作用：将对象信息（具体属性的值）以字符串拼接的形式展示出来，
     * 如果不写的话；输出对象会直接输入对象的内存地址（com.iflytek.pojo.Student@5fd0d5ae）
     *
     * 重写的是object类中的方法；因为object类默认是所有类的父类
     * 一个类student 可以继承多个父类  （错的）  单继承
     * 可以多重继承      a类继承了b类；b类继承c类；c类继承d类
     *
     *  一个类可以实现多个接口     多实现
     *
     * @return
     */
    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", addr='" + addr + '\'' +
                ", age=" + age +
                '}';
    }

    public Student() {
    }

    public Student(String sid, String sname, String addr, int age) {
        this.sid = sid;
        this.sname = sname;
        this.addr = addr;
        this.age = age;
    }

    /**
     * 构造函数：无参的构造函数；有参的构造函数
     *          构造函数的用途：实际上在实例化对象时（new对象），本质上是执行了构造函数
     *
     *
     *          Student s=new Student(sid,sname,addr,age);
     *
     *    一个普通类中肯定至少存在一个构造函数（true）
     *
     *    普通类中默认存在一个无参的构造函数(隐性的)
     *    如果在类中写了有参的构造函数，那么默认存在无参构造函数则消失
     *    需要手写无参的构造函数即可
     *
     *
     *
     */


    /**
     * 封装的特性：属性私有化；             方法公开化
     *         为了安全性而言；             通过对应的方法来访问属性值（修改属性值）
     *
     *
     *  一般情况下   一个实体类包含：属性，标准5套生成（setter/getter/toString/有参构造函数/无参构造函数）
     *
     *
     * @return
     */
    public String getSid() {
        return sid;
    }

    public String getSname() {
        return sname;
    }

    public String getAddr() {
        return addr;
    }

    public int getAge() {
        return age;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public static void main(String[] args) {
        Student stu=new Student();
    }



}
