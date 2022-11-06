<%--
  Created by IntelliJ IDEA.
  User: juann
  Date: 02/11/2022
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    Bem-vindo <%= session.getAttribute("login") %>
</body>
</html>
