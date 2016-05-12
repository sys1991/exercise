<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/12
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>考试中心</title>
</head>
<body>
<h1>考试中心</h1>
<form action="/User" method="post">
    <input type="hidden" name="action" value="login">
    用户名：<input type="text" name="username" placeholder="用户名"><br>
    密码：<input type="password" name="password" placeholder="密码"><br>
    <input type="submit" value="登陆">
</form>
${requestScope.message}
<a href="/register.jsp">注册</a>
</body>
</html>
