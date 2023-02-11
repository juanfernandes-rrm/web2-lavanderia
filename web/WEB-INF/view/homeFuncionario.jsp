<%-- 
    Document   : homeFuncionario
    Created on : Nov 26, 2022, 1:34:49 PM
    Author     : Felipe
--%>

<%@ page import="java.util.ArrayList" %>
<%@ page import="br.com.tads.model.PedidoTeste" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <li class="nav-item "><a class="nav-link me-lg-3" href="controller?action=ManterRoupas">Cadastro de Itens</a></li>
                        <li class="nav-item "><a class="nav-link me-lg-3" href="controller?action=ManterFuncionario">Manter Funcionário</a></li>
                        <li class="nav-item"><a class="nav-link me-lg-3" href="controller?action=VisualPedidos">Visualização de pedidos</a></li>
                    </ul>
                     <a href="controller?action=Login" class="btn btn-primary">Sair</a> 
                </div>
            </div>
        </nav>
        
        <c:set var="origin" value="homeFuncionario.jsp" />
        <c:set var="controller" value="new PedidoFuncionarioFiltro()" />
        <c:set var="result" value="${controller.execute(request, response)}" />
        <c:set var="pedidos" value="${requestScope.pedidos}" />
        
        <div class="container" style="margin-top:100px">
            <div class="card">
                <div class="card-body"> 
                    <form action="controller?action=PedidoController" method="post">
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
                                <c:forEach var="pedidos" items="${pedidos}">
                                    <c:if test="${pedido.statusPedido == 'EM ABERTO'}">
                                        <tr>
                                            <td>${pedidos.numero}</td>
                                            <td>${pedidos.dataCriacao}</td>
                                            <td>${pedidos.statusPedido}</td>
                                            <td>
                                                <input type="hidden" name="pedido" value="${pedido.numero}"/>
                                                <input type="hidden" name="acao" value="recolhido"/>
                                                <input type="submit" class="btn btn-primary col-5" value="Recolhido"/>
                                            </td>
                                        </tr> 
                                    </c:if>
                                </c:forEach>
                            </tbody>
                        </table>
                    </form>    
                </div>
            </div>
        </div>
    </body>
    
    
</html>
