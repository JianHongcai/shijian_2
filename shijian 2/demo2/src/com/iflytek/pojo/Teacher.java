package com.iflytek.pojo;

public class Teacher {

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;

    /**
     * 余额
     */
    private String balanace;

    /**
     * 工号
     */
    private String number;

    /**
     * 地址
     */
    private String address;


    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", balanace='" + balanace + '\'' +
                ", number='" + number + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Teacher() {
    }

    public Teacher(Integer id, String name, String password, String sex, Integer age, String phone, String email, String balanace, String number, String address) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.email = email;
        this.balanace = balanace;
        this.number = number;
        this.address = address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBalanace(String balanace) {
        this.balanace = balanace;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getSex() {
        return sex;
    }

    public Integer getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getBalanace() {
        return balanace;
    }

    public String getNumber() {
        return number;
    }

    public String getAddress() {
        return address;
    }
}
