<%--
  Created by IntelliJ IDEA.
  User: 简宏才
  Date: 2022/12/23
  Time: 1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Title</title>
    <style>
        .container {
            width: 500px;
            height: auto;
            border: 1px black solid;
            margin: 100px auto;
            text-align: center;
            background-color: rgba(0, 0, 0, 0.2);
            background-color: aqua;
        }


        body {
            background-image: url("img/9.webp");
            background-repeat: no-repeat;
            background-size: 100% 100%;
        }


    </style>
</head>
<body>
<h1>添加数据</h1>
<div class="container">
    <form  action="/player?op=add" method="post">
        学号：<input type="text" name="sid" id="sid" placeholder="请输入学号" />
        姓名：<input type="text" name="name" placeholder="请输入名字" /><br />
        性别：<input type="text" name="sex" placeholder="请输入性别" />
        年龄：<input type="text" name="age" placeholder="请输入年龄" /><br />
        学院：<input type="text" name="collage" placeholder="请输入学院" />
        <input type="submit" value="提交" />
        <input type="reset" value="重置" />


    </form>
</div>

<h1>删除数据</h1>
<div class="container">
    <form action="/player?op=delet" method="post">
        学号：<input type="text" name="sid" placeholder="请输入学号" />
        <input type="submit" value="提交" />
        <input type="reset" value="重置" />
    </form>
</div>

<h1>修改数据</h1>
<div class="container">
    <form action="/player?op=update" method="post">
        id:<input type="text" name="id" placeholder="请输入id" /><br />
        学号：<input type="text" name="sid" id="id" placeholder="请输入学号" />
        姓名：<input type="text" name="name" placeholder="请输入名字" /><br />
        性别：<input type="text" name="sex" placeholder="请输入性别" />
        年龄：<input type="text" name="age" placeholder="请输入年龄" /><br />
        学院：<input type="text" name="collage" placeholder="请输入学院" />

        <input type="submit" value="提交"/>
        <input type="reset" value="重置" />
    </form>
</div>

<h1>查询数据</h1>
<div class="container">
    <form action="/player?op=select" method="post">
        <input type="submit" value="查询" />
    </form>
</div>
<div>
    <button onclick="window.location.href='index.jsp'" type="button" id="add">
        返回
    </button>
</div>
</body>
</html>

