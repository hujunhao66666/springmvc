<%--
  Created by IntelliJ IDEA.
  User: 一个帅帅哒男神
  Date: 2021/2/23
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
</head>
<body>
    <h1>登陆页面</h1>

    <form action="${pageContext.request.contextPath}/user/login" method="post">
        用户名：<input type="text" name="username">
        密码：<input type="text" name="password">
        <input type="submit" value="提交">
    </form>
</body>
</html>
