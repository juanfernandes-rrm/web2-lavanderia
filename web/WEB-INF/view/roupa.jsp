<%-- 
    Document   : roupa
    Created on : 11 de fev. de 2023, 18:40:33
    Author     : juann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/css/bootstrap.css">
        <title>Roupas</title>
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
    </head>
    <body>        
        <div class="container pt-3">
            
            <c:if test="${mensagem} != null">
                <c:out value="${mensagem}" />
            </c:if>
            
            <div>
                <h1>Roupas cadastradas</h1>
            </div>
            
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead class="table-primary">
                      <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Peça</th>
                        <th scope="col">Valor</th>
                        <th scope="col">Prazo de entrega</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                      </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="roupa" items="${roupas}">
                            <tr>
                                <td>${roupa.id}</td>
                                <td>${roupa.peca}</td>
                                <td>${roupa.valor}</td>
                                <td>${roupa.prazoEntrega}</td>
                                <td><a href="controller?action=RoupaUpdateForm&id=${roupa.id}" class="btn btn-secondary">editar</a></td>
                                <td><a href="controller?action=RoupaDeletar&id=${roupa.id}" class="btn btn-danger">excluir</a></td>
                            </tr>                         
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        

            <div>  
                <div class="col-12">
                    <a href="controller?action=RoupaCadastrarForm" class="btn btn-primary">Cadastrar roupa</a>
                </div>
            </div>
        </div> 
    </body>
</html>
