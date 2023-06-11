package com.iflytek.test;

import com.iflytek.pojo.Student;
import com.iflytek.pojo.User;
import com.iflytek.services.StudentService;
import com.iflytek.services.UserService;
import com.iflytek.services.impl.StudentServiceImpl;
import com.iflytek.services.impl.UserServiceImpl;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        UserService userService=new UserServiceImpl();
        StudentService studentService=new StudentServiceImpl();
        Scanner scanner=new Scanner(System.in);

        while(true){
            //输出登录注册的导航信息
            printLoginOrRegInfo();

            String i= scanner.next();
            //对用户输入的值进行判断处理
            if(i.equals("1")){//登录
                String name= getName(scanner);

                //获取密码
                String password= getPassword(scanner);
              User u=  userService.login(name,password);
              if(u!=null){
                  System.out.println("登录成功，欢迎您，"+u.getName());
                  break;
              }
            }else if(i.equals("2")){//注册
                //注册
                //获取用户名
               String name= getName(scanner);

               //获取密码
              String password= getPassword(scanner);
              //创建参数对象
              User user=new User();
              //给参数对象属性赋值
              user.setName(name);
              user.setPassword(password);
              //调用注册的方法
              userService.reg(user);
            }else{
                System.out.println("指令有误，请重新输入");
            }
        }



        while(true){
            System.out.println("************a:添加学生信息*************");
            System.out.println("************b:展示学生列表*************");
            System.out.println("************c:删除学生信息*************");
            System.out.println("************d:修改学生信息*************");
            System.out.println("************0:退出系统*************");

            String i=  scanner.next();
            if(i.equals("a")){

                /**
                 * 获取用户在控制台输入的学生的信息（学号，姓名，地址，年龄）
                 * 存储用户的信息
                 */
                System.out.println("请输入学号");
                String sid=scanner.next();
                System.out.println("请输入姓名");
                String sname=scanner.next();
                System.out.println("请输入地址");
                String addr=scanner.next();
                System.out.println("请输入年龄");
                int age=scanner.nextInt();

                //将获取到的值保存起来
               Student student=new Student(sid,sname,addr,age);

                studentService.addStudent(student);

                //添加学生信息
                System.out.println("添加学生信息完成,输入-1返回");
                String again= scanner.next();
            }else if(i.equals("b")){
                //展示学生列表
                studentService.findAllStudent();
                System.out.println("展示学生信息完成,输入-1返回");
                String again= scanner.next();

            }else if(i.equals("c")){
                //删除学生信息
//                System.out.println("请输入您要删除学生的学号：");
//                String sid=scanner.next();
//                studentService.deleteStudent(sid);
//                System.out.println("删除学生信息完成,输入-1返回");
//                String again= scanner.next();
            }else if(i.equals("d")){
                //修改学生信息
//                System.out.println("修改学生信息");
//                System.out.println("请输入学号");
//                String sid=scanner.next();
//                System.out.println("请输入姓名");
//                String sname=scanner.next();
//                System.out.println("请输入地址");
//                String addr=scanner.next();
//                System.out.println("请输入年龄");
//                int age=scanner.nextInt();
//
//                //将获取到的值保存起来
//                Student student=new Student(sid,sname,addr,age);
//
//                //修改的操作
//                studentService.updateStudent(student);
//                System.out.println("修改学生信息完成,输入-1返回");
//                String again= scanner.next();
            }else if(i.equals("0")){
                //退出系统
                System.exit(0);//程序停止
            }else{
                System.out.println("指令有误，请重新输入");
            }

        }








    }



    /**
     * 输出登录注册的导航信息
     */
    public static void printLoginOrRegInfo(){
        //输出登录注册信息
        System.out.println("*********欢迎来到学生管理系统************");
        System.out.println("*********1：登录************");
        System.out.println("*********2：注册************");
    }

    /**
     * 方法上需要写好注释
     * 阐述清楚函数的用途（最简洁的语言描述最详细的信息）
     * 从控制台获取用户名
     * 用户名拿到之后需要返回出来，返回给调用此方法的地方
     *
     *
     *
     * static:静态的——>无需创建该对象就可以调用的方法
     */
    public static String getName(Scanner scanner){
        System.out.println("请输入用户名：");
        String name=  scanner.next();
        return name;
    }


    /**
     * 从控制台获取密码
     * @param scanner
     * @return
     */
    public static String getPassword(Scanner scanner){
        System.out.println("请输入密码：");
        String password=  scanner.next();
        return password;
    }

}
