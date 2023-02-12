<%-- 
    Document   : homeFuncionario
    Created on : Nov 26, 2022, 1:34:49 PM
    Author     : Felipe
--%>

<%@ page import="java.util.ArrayList" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<fmt:setLocale value="pt-BR" />
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
                        <li class="nav-item "><a class="nav-link me-lg-3" href="controller?action=ManterRoupa">Cadastro de Itens</a></li>
                        <li class="nav-item "><a class="nav-link me-lg-3" href="controller?action=ManterFuncionario">Manter Funcionário</a></li>
                        <li class="nav-item"><a class="nav-link me-lg-3" href="controller?action=PedidoVisual">Visualização de pedidos</a></li>
                    </ul>
                     <a href="controller?action=Login" class="btn btn-primary">Sair</a> 
                </div>
            </div>
        </nav>
        
        <div class="container" style="margin-top:100px">
            <div class="pb-3">
                <div class="btn-group align-content-center" role="group"> 
                    <form method="POST" action="controller?action=PedidoFuncionarioFiltro">
                        <input type="hidden" name="filtro" value="todos">
                        <input type="hidden" name="origin" value="homeFuncionario.jsp">
                        <button type="submit" class="btn btn-outline-secondary">Listar</button>
                    </form>
                </div>
            </div>
            <div class="card">
                <div class="card-body"> 
                    <form action="controller?action=PedidoFuncionarioFiltro" method="post">
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
                            <c:forEach var="pedido" items="${pedidos}">
                                <tr>
                                    <td>${pedido.numero}</td>
                                    <td><tags:localDateTime date="${pedido.dataCriacao}"/></td>
                                    <td>${pedido.statusPedido.status()}</td>
                                    <td>
                                        <c:if test="${pedido.statusPedido.status() == 'Em Aberto'}">
                                            <a href="controller?action=PedidoStatus&status=Recolher&id=${pedido.numero}&origin=PedidoVisual" class="btn btn-primary">Pedido Recolhido</a>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </form>    
                </div>
            </div>
        </div>
    </body> 
</html>
