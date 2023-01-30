<%-- 
    Document   : homeFuncionario
    Created on : Nov 26, 2022, 1:34:49 PM
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/css/bootstrap.css">
        <title>Home Funcionario</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light fixed-top shadow-sm" id="mainNav">
            <div class="container px-5">
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto me-4 my-3 my-lg-0">
                        <li class="nav-item"><a class="nav-link me-lg-2 mt-1" href="controller?action=HomeFuncionario">Home</a></li>
                        <li class="nav-item"><a class="me-lg-2 mt-1 btn btn-primary" href="controller?action=PedidoForm">Fazer pedido</a></li>
                        <li class="nav-item"><a class="me-lg-2 mt-1 btn btn-primary" href="controller?action=Login">Sair</a></li>
                    </ul>
                </div>
            </div>
        </nav>
       <div class="container" style="margin-top:100px">
            <table class="table">
                <thead class="table-primary">
                  <tr>
                    <th scope="col">Pedido</th>
                    <th scope="col">Data/Hora</th>
                    <th scope="col">Status</th>
                    <th scope="col"></th>
                  </tr>
                </thead>
                <tbody>
                    <% // tabela dinâmica com adição do botão para "Recolher Pedido"
                        %>
                </tbody>
            </table>
        </div>
    </body>
    
    
</html>
