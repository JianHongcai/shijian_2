package com.iflytek.servlet;

import com.iflytek.pojo.Player;
import com.iflytek.services.PlayerService;
import com.iflytek.services.impl.PlayerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/player")
public class PlayerServlet extends HttpServlet {

    private PlayerService playerService = new PlayerServiceImpl();


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String op= request.getParameter("op");
        if("add".equals(op)){
            //添加数据
            doAdd(request,response);

        }else if("delet".equals(op)){

           doDelet(request,response);
        }else if("update".equals(op)){

            doUpdate(request,response);
        }else if("select".equals(op)){

            doSelect(request,response);
        }

    }

    private void doAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String sid= request.getParameter("sid");
       String name= request.getParameter("name");
       String sex= request.getParameter("sex");
       Integer age= Integer.parseInt(request.getParameter("age"));
       String collage= request.getParameter("collage");

        Player p = new Player();
        p.setSid(sid);
        p.setName(name);
        p.setSex(sex);
        p.setAge(age);
        p.setCollage(collage);

        playerService.addPlayer(p);
       response.sendRedirect("/index.jsp");
    }


    private void doUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String sid= request.getParameter("sid");
        String name= request.getParameter("name");
        String sex= request.getParameter("sex");
        Integer age= Integer.parseInt(request.getParameter("age"));
        String collage= request.getParameter("collage");
        Integer id= Integer.parseInt(request.getParameter("id"));

        Player p = new Player(id,sid,name,sex,age,collage);
        p.setId(id);
        p.setSid(sid);
        p.setName(name);
        p.setSex(sex);
        p.setAge(age);
        p.setCollage(collage);



        playerService.updatePlayer(p);
        response.sendRedirect("/index.jsp");
    }


    private void doSelect(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        List<Player> pla= playerService.selectPlayer();
        request.getSession().setAttribute("pla",pla);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    private void doDelet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sid= request.getParameter("sid");
        Player p = new Player();
        p.setSid(sid);
        playerService.deletePlayer(sid);
        response.sendRedirect("/index.jsp");
    }







}
