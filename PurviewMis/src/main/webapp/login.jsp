<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>登录</title>
  <link rel="stylesheet" href="<%= request.getContextPath()%>/css/login_css.css">
</head>

<body>
<form id="login" name="login" method="post"
      action="<%= request.getContextPath()%>/user/userServlet?action=login">
<div id="login_box">
  <h2>LOGIN</h2>
  <div id="input_box">
  <input class="inputs" type="text" name="username" value="${cookie.username.value}" placeholder="请输入学号">
</div>
  <div class="input_box">
    <input class="inputs" type="password" name="password" value="${cookie.password.value}" placeholder="请输入密码">
  </div>
  <div class="remember">
    <span>记住我?</span><input type="checkbox" name="remember" value="1" class="tui-checkbox " >
    <div class="error">${error}</div>
  </div>

  <button> <a href="html/list/user_list.jsp"></a>登录</button>
  <a href="html/register/register.jsp"><button type="button">注册</button></a>
</div>
</form>
</body>
</html>
