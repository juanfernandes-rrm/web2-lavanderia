<%--
  Created by IntelliJ IDEA.
  User: juann
  Date: 02/11/2022
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="controller?action=Login" method="post">
        Login: <input type="text" name="login" /><br/>
        Senha: <input type="text" name="senha" /><br/>
        <input type="hidden" value="Login" name="action">
        <input type="submit" name="Logar" /><br/>
    </form>
</body>
</html>
