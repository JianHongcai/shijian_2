//package com.iflytek.test;
//
//import com.iflytek.pojo.Teacher;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Demo {
//
//    /**
//     * 目标：使用jdbc链接java程序和mysql数据库
//     * 任务：查询tb_teacher表中的所有数据，遍历的控制台中
//     *
//     * jdbc的链接步骤：
//     *  1：添加jar   (数据库的驱动包)
//     *  2：指定jar包被项目引入
//     *  3：创建main方法，在方法中编写具体的代码逻辑
//     *  4：
//     */
//
//
//    /**
//     * jdbc连接数据库的使用技术
//     * @param args
//     */
//
//    public static void main(String[] args) {
//
//        try {
//            //1:加载数据库的驱动类
//            Class.forName("com.mysql.jdbc.Driver");
//
//            //获取数据库的连接对象
//            //需要三个参数：url    user   password
//            //url：数据库的连接地址信息
//            //user:  数据库的用户名
//            // password:   数据库用户名的密码
//        Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/20-java-1","root","root");
//
//            //准备需要执行的sql语句
//            String sql="select * from tb_teacher";
//            //利用数据库的连接对象   获取到   执行sql语句的对象
//          PreparedStatement ps= conn.prepareStatement(sql);
//            //利用   执行sql语句的对象  执行sql语句   获取sql语句的返回结果
//          ResultSet rs= ps.executeQuery();
//
//          //创建list集合对象；装查询出来的数据库中的对象信息
//          List<Teacher> teachers=new ArrayList<Teacher>();
//          //分析返回的结果对象；获取数据库中对应的数据
//          while(rs.next()){
//
//              /**
//             * 已经拿到了数据库中所有的数据，共两行数据
//             * 将每行数据封装成一个teacher对象；共两个teacher对象
//             */
//            Teacher teacher=new Teacher();
//            //获取每一列的值
//
//            //获取id列的值
//            int id= rs.getInt("id");
//            //将id的值赋给teacher对象中的id的值
//            teacher.setId(id);
//            teacher.setName(rs.getString("t_name"));//名称
//            teacher.setPassword(rs.getString("t_password"));//密码
//            teacher.setSex(rs.getString("t_sex"));//性别
//            String age= rs.getString("age");
//            if(age!=null){
//                teacher.setAge(Integer.valueOf(age));
//            }
//
//            teacher.setPhone(rs.getString("phone"));//手机号
//            teacher.setEmail(rs.getString("email"));//邮箱
//            teacher.setBalanace(rs.getString("balanace"));//余额
//            teacher.setNumber(rs.getString("number"));//工号
//            teacher.setAddress(rs.getString("address"));//地址
//
//            //将查询出来的结果存在集合中
//            teachers.add(teacher);
//
//        }
//
//        /**
//         * 一般情况下；在数据库中的一张表；在Java代码中一般用一个实体类来表示，两者相呼应
//         * 数据库中表的一行数据实际上用Java代码来表示该实体类的一个对象
//         */
//        teachers.forEach(teacher -> {
//            System.out.println(teacher);
//        });
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//}
