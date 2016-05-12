<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/12
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h1>考试中心注册</h1>
<form action="/User" method="post">
    <input type="hidden" name="action" value="register">
    <input type="text" name="username" placeholder="填写用户名">
    <input type="password" name="password" placeholder="请填写密码">
    <input type="submit" value="注册">
</form>
</body>
</html>
