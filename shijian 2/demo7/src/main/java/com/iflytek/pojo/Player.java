package com.iflytek.pojo;

public class Player {

    private Integer id;

    private String sid;

    private String name;

    private String sex;

    private Integer age;

    private String collage;

    public Player() {
    }

    public Player(String sid, String name, String sex, Integer age, String collage) {
        this.sid = sid;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.collage = collage;
    }

    public Player(Integer id, String sid, String name, String sex, Integer age, String collage) {
        this.id = id;
        this.sid = sid;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.collage = collage;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCollage() {
        return collage;
    }

    public void setCollage(String collage) {
        this.collage = collage;
    }

    @Override
    public String toString() {
        return "player{" +
                "id=" + id +
                ", sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", collage='" + collage + '\'' +
                '}';
    }
}
