

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>注册</title>
    <link rel="stylesheet" href="../../css/login_css.css">
</head>

<body>

<form id="register" name="register" method="post"
      action="<%= request.getContextPath()%>/user/userServlet?action=add">
    <div class="checkCodeBox">
        <input name="checkCodeInput" type="text" class="checkCodeInput" >
        <img src="/PurviewMis_Web_exploded/checkCodeServlet">
        <a href="#" id="changeImg">换一张</a>
    </div>
    <div id="login_box">
        <h2>REGISTER</h2>
        <div id="input_box">
            <text>学号：</text>
            <input class="inputs" type="text" name="username" placeholder="请输入学号">
        </div>
        <div class="input_box">
            <text>密码：</text>
            <input class="inputs" type="password" name="password" placeholder="请输入密码">
        </div>
        <div class="input_box">
            <text>密码：</text>
            <input class="inputs" type="password" name="password2" placeholder="请确认密码">
        </div>
        <div class="input_box">
            <text>姓名：</text>
            <input class="inputs" type="text" name="realname" placeholder="请输入真实姓名">
        </div>
        <div class="input_box">
            <text>邮箱：</text>
            <input class="inputs" type="text" name="email" placeholder="请输入邮箱">
        </div>
        <div class="input_box">
            <text>手机号：</text>
            <input class="inputs" type="text" name="telephone" placeholder="请输入手机号">
        </div>
        <div class="input_box">
            <div class="agebox">
                <text>性别：</text>
                <input type="radio" name="sex" value="1" checked="checked">
                <text>男</text>
                <input type="radio" name="sex" value="0">
                <text>女</text>
            </div>
        </div>
        <div class="input_box">
            <text>年龄：</text>
            <input class="inputs" type="text" name="age" placeholder="请输入年龄">
        </div>
        <a href="../../login.jsp">
            <button  type="submit">注册</button>
        </a>
    </div>
</form>
</body>
</html>
