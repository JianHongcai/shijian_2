package com.iflytek.demo;

import com.iflytek.pojo.Student;
import com.iflytek.pojo.User;
import com.iflytek.services.StudentService;
import com.iflytek.services.UserService;
import com.iflytek.services.impl.StudentServiceImpl;
import com.iflytek.services.impl.UserServiceImpl;

import java.util.Scanner;

public class Demo {


    private static UserService userService=new UserServiceImpl();

    private static StudentService studentService=new StudentServiceImpl();


    /**
     * 程序入口函数
     * @param args
     */
    public static void main(String[] args) {

        //如何获取用户在控制台输入的值
        //通过scanner对象调用函数获取的来
        //1：创建scanner对象
        Scanner scanner=new Scanner(System.in);

        while(true){
            //输出登录注册的导航信息
            printLoginOrRegInfo();

            //获取用户输入的值；
            // 通过scanner对象调用next()获取用户在控制输入的值；返回值为string
            //对象名.方法名();
            String i= scanner.next();
            //对用户输入的值进行判断处理
            if(i.equals("1")){//登录
                System.out.println("欢迎登录");
                /**
                 * 登录的思路：
                 *  1：获取用户输入的用户名
                 *  2：获取用户输入的密码
                 *  3：校验用户输入的用户名和密码是否正确
                 */
                //登录-获取用户输入的用户名
               String name= getName(scanner);
                //登录-获取用户输入的密码
                String password=getPassword(scanner);

               User u= userService.login(name,password);
                if(u==null){
                    System.out.println("用户名或密码有误，请重新输入");
                }else{
                    System.out.println("登录成功，欢迎您，"+u.getName());
                    break;
                }


                //登录
//                break;//退出当前循环;跳出整个循坏
//                return;//返回值，结束方法（有无返回值，若方法有返回值，return返回值，若方法没有返回值，return,退出方法）
//                continue;//结束此次循环，开启下一次循环
            }else if(i.equals("2")){//注册
                //注册
                /**
                 * 注册的思路
                 * 1：获取用户输入的用户名
                 * 2：获取用户输入的密码
                 * 3：将用户输入的用户名和密码保存起来（为登录服务）
                 */


                /**
                 * 校验该用户名是否已经存在；若存在，该用户名不能用；让用户重新输入
                 *                          若不存在，则该用户名可以使用
                 */
                String name=null;
                while(true){
                    name=getName(scanner);

                    boolean result= userService.checkName(name);
                    if(result){//用户名可用
                        break;
                    }else{//用户名已存在，不可用
                        System.out.println("用户名已存在，请重新输入");
                    }
                }




                String password= getPassword(scanner);

                /**
                 *  调用业务中UserService中注册的方法
                 *  1：创建UserService 的对象
                 *  2：通过对象调用方法
                 */
                userService.reg(name,password);
            }else{
                System.out.println("指令有误，请重新输入");
            }
        }



        /**
         *  获取用户在控制台输入的指令
         *  怎么获取用户在控制台输入的信息
         */


        /**
         * 学生信息的增删改查
         */



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
                studentService.showAllStudent();
                System.out.println("展示学生信息完成,输入-1返回");
                String again= scanner.next();

            }else if(i.equals("c")){
                //删除学生信息
                System.out.println("请输入您要删除学生的学号：");
                String sid=scanner.next();
                studentService.deleteStudent(sid);
                System.out.println("删除学生信息完成,输入-1返回");
                String again= scanner.next();
            }else if(i.equals("d")){
                //修改学生信息
                System.out.println("修改学生信息");
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

                //修改的操作
                studentService.updateStudent(student);
                System.out.println("修改学生信息完成,输入-1返回");
                String again= scanner.next();
            }else if(i.equals("0")){
                //退出系统
                System.exit(0);//程序停止
            }else{
                System.out.println("指令有误，请重新输入");
            }

        }

        /**
         * 每次项目重新启动之后；之前注册的用户或者添加的学生信息统统消失了
         *
         * 目前情况下数据存储Map集合中——>存储在内存中——>程序停止，释放资源，数据丢失
         *
         * 数据持久化——>数据写入到数据库（mysql）中；
         *                难点：Java程序如何和mysql数据进行交互
         *
         *
         *
         */



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
     * 申明一个函数   方法
     */
    //    private
    //    public
    //      protected
    //      默认的   缺省
    //访问权限修饰符    方法的返回值    方法名称  (参数列表){}

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
