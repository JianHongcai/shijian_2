<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>



</head>
<body>

    <h1>登录成功</h1>

    <button onclick="window.location.href='add.jsp'" type="button" id="add">添加</button>




<%--
    集合数据以表格的形式在页面上遍历出来
        jstl标签
            1：引入依赖
            2: 在页面上引入jstl的标签库
            3：遍历数据
--%>


    <table border="1px">
        <tr>
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>学院</th>

        </tr>

        <c:forEach items="${pla}" var="s">
            <tr>
                <td>${s.sid}</td>
                <td>${s.name}</td>
                <td>${s.sex}</td>
                <td>${s.age}</td>
                <td>${s.collage}</td>

            </tr>

        </c:forEach>



    </table>





</body>
</html>