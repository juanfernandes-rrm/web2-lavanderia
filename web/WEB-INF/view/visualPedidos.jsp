<%-- 
    Document   : visualPedidos
    Created on : Nov 26, 2022, 2:10:34 PM
    Author     : Felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/css/bootstrap.css">
        <title>Pedidos</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light shadow-sm">
             <div class="container px-5">
                    <ul class="navbar-nav ms-auto me-4 my-3 my-lg-0">
                        <li class="nav-item"><a class="nav-link me-lg-3" href="controller?action=HomeFuncionario">Home</a></li>
                    </ul>
                    <a href="controller?action=Login" class="btn btn-primary">Sair</a> 
            </div>
        </nav>
        <div class="container" style="margin-top: 1rem">
            <div class="btn-group align-content-center" role="group">       
                <button class="btn btn-outline-secondary">Todos</button>
                <button class="btn btn-outline-secondary">Pedidos de Hoje</button>
                <button class="btn btn-outline-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">Período</button>
                    <div class="dropdown-menu px-4 py-3">
                        <form method="POST" action="/é o DAO">  <!-- Implementar DAO -->
                            <div class="mb-3">
                                <label for="inicio">Início:</label></br>
                                <input type="date" id="iniData" name="iniData">
                            </div>
                            <div class="mb-3">
                                <label for="fim">Fim:</label></br>
                                <input type="date" id="fimData" name="fimData"></br>
                            </div>
                            <button type="submit" class="btn btn-primary">Pesquisar</button>
                        </form>
                    </div>
            </div>    
        </div>

        
        <div class="container" style="margin-top:20px">
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
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</html>