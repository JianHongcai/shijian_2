package com.iflytek.servlet;

import com.iflytek.pojo.User;
import com.iflytek.services.UserService;
import com.iflytek.services.impl.UserServiceImpl;
import com.iflytek.util.SendEmailUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * 登录，注册，校验用户名唯一等等关于用户模块的功能
 */

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private UserService userService=new UserServiceImpl();




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        //获取参数：用户模块的标识  op
       String op= request.getParameter("op");


        if("login".equals(op)){
            //登录
            doLogin(request,response);
        }else if("reg".equals(op)){
            //注册
            doReg(request,response);
        }else if("checkName".equals(op)){
            //校验用户名唯一
            doCheckName(request,response);
        }else if("getCode".equals(op)){
            doGetCode(request,response);
        }

    }


    /**
     * 登录的方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1：获取参数
         * 2：调用service方法
         */

      String name=  request.getParameter("uname");
       String password= request.getParameter("upwd");

      User u= userService.login(name,password);
      if(u==null){//登录失败，用户名和密码有误
        response.sendRedirect("/login.jsp");
      }else{//登录成功

         //将用户信息存入作用域
         request.getSession().setAttribute("user",u);

        request.getRequestDispatcher("index.jsp").forward(request,response);
      }

    }



        /**
         * 注册用户
         * 注意点：中文乱码问题：
         *          前端往服务端传参数数据的时候：post/get
         *              post请求的中文乱码问题可以一并解决
         *                   request.setCharacterEncoding("UTF-8");
         *              get请求的中文乱码必须要单个参数逐一处理
         *                  new String(name.getBytes("ISO-8859-1"),"utf-8");
         *              绝大部分情况下：有中文参数的尽可能发post请求
         *
         *          代码和数据库连接时：
         *              数据库连接地址后追加参数
         *                  jdbc:mysql://localhost:3306/zysf-javaweb?characterEncoding=utf-8
         *
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException
         */
    private void doReg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1：获取前端传递的参数值
         *
         *      准备好参数对象
         * 2：调用service层方法
         */
       String name= request.getParameter("uname");//用户名
        String upwd= request.getParameter("upwd");//密码
        String email= request.getParameter("email");//邮箱
        String phone= request.getParameter("phone");//手机号
        String code= request.getParameter("code");//验证码



        /**
         * 验证码的校验
         *         1：获取生成的验证码是多少
         */
       String str=(String) request.getSession().getAttribute("code");
        if(str.equals(code)){//验证码正确
            User u=new User();
            u.setName(name);
            u.setPassword(upwd);
            u.setEmail(email);
            u.setPhone(phone);
            userService.regUser(u);
            response.sendRedirect("/login.jsp");
        }else{//验证码不对
            response.sendRedirect("/reg.jsp");
        }





    }





        /**
         * 获取邮箱验证码
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException
         */
    private void doGetCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /**
         * 1：生成验证码
         *
         * 2：根据生成的验证码拼接邮件内容——>string
         *
         * 3：发送邮件——>得到结果（true/false）
         *
         * 4：告知用户，成功还是失败
         */

        //生成随机数
        //创建生成随机数对象
        Random random=new Random();
        //创建拼接随机数的对象
        StringBuffer sb=new StringBuffer();//
        //随机生成4个随机数
        for(int i=0;i<4;i++){
            //[0.10)
           int num= random.nextInt(10);//[0.10)      //9    8     3      1
            //拼接再一起
            sb.append(num);//9831
        }
        String code=sb.toString();//验证码

        /**
         *   验证码需要保存   存到session作用域
         *
         *   方便下次校验时取出（注册时候）
         */
        request.getSession().setAttribute("code",code);



        //邮件内容
        String email="您的验证码为："+code+";请妥善保管，不要告知他人，30分钟有效！";


        //获取参数的值
      String to=  request.getParameter("email");//收件人的邮箱

       boolean f= SendEmailUtil.sendMail(to,email);

     PrintWriter out=  response.getWriter();

        if(f){//发送成功
            out.print("1");
        }else{//发送失败
            out.print("0");
        }

        out.flush();
        out.close();

    }




        /**
         * 校验用户名唯一
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException
         */
    private void doCheckName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //后端获取前端传递参数的方法
       String name= request.getParameter("name");//jack


      User u=  userService.checkNameIsOk(name);//u==null

      PrintWriter out= response.getWriter();

      if(u==null){//jack可以使用

          out.print("1");//输出1


      }else{//jack不可以使用，已经存在
          out.print("0");//输出0
      }

      out.flush();//刷新
      out.close();//关闭
    }






        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}
