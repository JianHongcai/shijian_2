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

    <script
            type="text/javascript"
            src="https://code.jquery.com/jquery-3.5.1.min.js"
    ></script>

    <script type="text/javascript">
        function checkName() {
            //1:获取用户输入的值
            var name = document.getElementById("uname").value; //jack
            //2：发送请求，校验该值是否可用；服务端会返回结果（1/0）
            $.ajax({
                url: "/user?op=checkName", //请求地址
                type: "post", //请求类型
                data: "name=" + name, //请求参数
                //user?op=checkName&name=jack
                success: function (result) {
                    //服务端给前端的数据响应
                    // alert(result);
                    if (result == "1") {
                        alert("用户名可用");
                    } else if (result == "0") {
                        alert("用户名已存在，换一个");
                    } else {
                        alert("服务器异常，请稍后再试");
                    }
                },
            });

            //3：对结果进行处理

            /**
             * 前端发送请求的方式：
             *          地址栏输入请求地址
             *          a标签
             *          img标签
             *          form表单
             *          ajax     jquery
             */
        }

        /**
         * 获取邮箱验证码
         */
        function getCode() {
            /**
             * 1：获取收件人的邮箱
             */
            var email = document.getElementById("email").value;

            //发送请求
            $.ajax({
                url: "/user?op=getCode",
                type: "post",
                data: "email=" + email,
                success: function (result) {
                    if (result == "1") {
                        alert("验证码已发送");
                    } else if (result == "0") {
                        alert("验证码发送失败");
                    } else {
                        alert("服务器异常，请稍后再试");
                    }
                },
            });
        }
    </script>

    <style>
        * {
            margin: 0;
            padding: 0;
        }

        .container {
            width: 500px;
            height: 1200px;
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
            height: 30px;
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
            background-color: #85ffbd;
            background-image: linear-gradient(
                    244deg,
                    #85ffbd 0%,
                    #fffb7d 50%,
                    #ffffff 100%
            );
        }

        .v1 {
            margin-top: 60px;
            margin-right: 209px;
            color: aqua;
        }
        .v2 {
            margin-right: -200px;
        }
        body {
            background-image: url("img/4.webp");
            background-repeat: no-repeat;
            background-size: 100% 100%;
        }
    </style>
</head>
<body>
<%--tomcat启动默认首页的名称是index
首页：只需要在地址栏输入ip地址和端口号即可访问的页面就是首页
tomcat默认首页的名字叫index 首页的配置是可以修改的——>修改配置文件web.xml
邮箱发送验证码：通过发送邮件的形式——>发件人，收件人，邮件内容 张三 验证码
--%>
<div class="container">
    <div class="word">
        <h1>注册页面</h1>
    </div>

    <form action="/user?op=reg" method="post">
        <div class="input">
            <div class="v1">用户名:</div>
            <input
                    type="text"
                    name="uname"
                    id="uname"
                    placeholder="请输入用户名"
                    onblur="checkName()"
            />

            <div class="v1">密码：</div>
            <input type="password" name="upwd" placeholder="请输入密码" />
            <div class="v1">确认密码：</div>
            <input
                    type="password"
                    name="confirmUpwd"
                    placeholder="请输入确认密码"
            />
            <div class="v1">邮箱：</div>
            <input
                    type="text"
                    name="email"
                    id="email"
                    placeholder="请输入邮箱"
            /><a href="javascript:void(0)" onclick="getCode()"
        ><div class="v2">获取验证码</div></a
        >
            <div class="v1">手机号:</div>
            <input type="text" name="phone" placeholder="请输入手机号" />
            <div class="v1">验证码：</div>
            <input type="text" name="code" placeholder="请输入验证码" />
        </div>
        <div class="btn">
            <input type="submit" value="注册" />
            <input type="reset" value="重置" />
        </div>
    </form>
</div>
</body>
</html>
