<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/12
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/inc.jsp"%>
<html>
<head>
    <title>Student</title>
</head>
<body>
<c:if test="${sessionScope.user eq null}">
    <c:redirect url="index.jsp"/>
</c:if>
<h1>Student</h1>
</body>
</html>
