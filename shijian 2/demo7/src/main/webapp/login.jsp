<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName()
            + ":" + request.getServerPort() + request.getContextPath() + "/";

    request.setAttribute("basePath", basePath);

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>

    <style>
        * {
            margin: 0;
            padding: 0;
        }

        body {
            background-image: url("img/3.webp");
            background-repeat: no-repeat;
            background-size: 100% 146%;
        }

        .container {
            width: 480px;
            height: auto;
            border: 1px black solid;
            margin: 100px auto;
            text-align: center;
            background-color: rgba(0, 0, 0, 0.2);
        }

        .word {
            margin-top: 60px;
            color: white;
        }

        .input input {
            display: block;
            margin: 20px auto;
            width: 240px;
            height: 35px;
            border: none;
            border-bottom: 2px white solid;
            background-color: transparent;
            color: white;
            font-size: 17px;
            padding: 0 10px;
        }

        .btn input {
            width: 90px;
            height: 40px;
            color: white;
            border: 0;
            border-radius: 10px;
            font-size: 28px;
            font-weight: bold;
            background-color: transparent;

            margin-top: 20px;
        }

        .btn input:hover {
            /* background-image: linear-gradient(19dge,#21D4fD 0%,#2135ff); */
            background-color: #0093e9;
            background-image: linear-gradient(135deg, #0093e9 0%, #80d0c7 100%);
        }

        .v1 {
            margin-top: 60px;
            margin-right: 200px;
        }
        .v2 {
            margin-right: 209px;
        }
        .v3 {
            font-size: 20px;
            margin-right: -350px;
            margin-bottom: 30px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="word">
        <h1>登录页面</h1>
    </div>

    <form action="/user?op=login" method="post">
        <div class="input">
            <div class="v1">用户名:</div>
            <input type="text" name="uname" placeholder="请输入用户名" />
            <br />
            <div class="v2">密码:</div>
            <input type="password" name="upwd" placeholder="请输入密码" />
        </div>

        <div class="btn">
            <input type="submit" value="登录" />
            &nbsp; &nbsp; &nbsp; &nbsp;
            <input type="reset" value="重置" />
        </div>
    </form>
    <a href="reg.jsp"><div class="v3">去注册</div></a>
</div>
</body>
</html>