<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8" name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="resources/css/bootstrap.css">
    <title>Home</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light shadow-sm" id="mainNav">
            <div class="container px-5">
                <span class="navbar-brand mb-0 h1">LOL</span>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto me-4 my-3 my-lg-0">
                        <li class="nav-item"><a class="me-lg-2 mt-1 btn btn-primary" href="controller?action=PedidoForm">Fazer pedido</a></li>
                        <li class="nav-item"><a class="me-lg-2 mt-1 btn btn-primary" href="controller?action=Logout">Sair</a></li>
                    </ul>
                </div>
            </div>
        </nav>
    
    <div class="container text-end col-7">
        <h1>
        Bem-vindo ${usuario.nome}
        </h1>
    </div>
    
</body>
</html>
