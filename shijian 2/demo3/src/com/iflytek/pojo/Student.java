package com.iflytek.pojo;

public class Student {

    /**
     * 主键编号
     */
    private Integer id;


    /**
     * 学号
     */
    private String sid;


    /**
     * 学生姓名
     */
    private String sname;

    /**
     * 家庭地址
     */
    private String addr;

    /**
     * 年龄
     */
    private Integer age;


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", addr='" + addr + '\'' +
                ", age=" + age +
                '}';
    }

    public Student() {
    }


    public Student(String sid, String sname, String addr, Integer age) {
        this.sid = sid;
        this.sname = sname;
        this.addr = addr;
        this.age = age;
    }

    public Student(Integer id, String sid, String sname, String addr, Integer age) {
        this.id = id;
        this.sid = sid;
        this.sname = sname;
        this.addr = addr;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
