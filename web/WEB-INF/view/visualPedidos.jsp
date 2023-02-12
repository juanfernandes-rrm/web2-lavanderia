<%-- 
    Document   : visualPedidos
    Created on : Nov 26, 2022, 2:10:34 PM
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
                <form method="POST" action="controller?action=PedidoFuncionarioFiltro">
                    <input type="hidden" name="origin" value="visualPedidos.jsp">
                    <input type="hidden" name="filtro" value="todos">
                    <button type="submit" class="btn btn-outline-secondary">Todos</button>
                </form>
                
                <form method="POST" action="controller?action=PedidoFuncionarioFiltro">
                    <input type="hidden" name="origin" value="visualPedidos.jsp">
                    <input type="hidden" name="filtro" value="hoje">
                    <button type="submit" class="btn btn-outline-secondary">Pedidos de Hoje</button>
                </form>  
                
                <button class="btn btn-outline-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">Período</button>
                    <div class="dropdown-menu px-4 py-3">
                        <form method="POST" action="controller?action=PedidoFuncionarioFiltro">
                            <div class="mb-3">
                                <label for="inicio">Início:</label></br>
                                <input type="date" id="iniData" name="iniData">
                            </div>
                            <div class="mb-3">
                                <label for="fim">Fim:</label></br>
                                <input type="date" id="fimData" name="fimData"></br>
                            </div>
                            <input type="hidden" name="origin" value="visualPedidos.jsp">
                            <input type="hidden" name="filtro" value="range">
                            <button type="submit" class="btn btn-secondary">Pesquisar</button>
                        </form>
                    </div>
            </div>    
        </div>       
        
        <div class="container" style="margin-top:20px">
            <div class="card">
                <div class="card-body">
                    <form action="controller?action=PedidoUpdate" method="post">
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
                                    
                                    <tr class="" style="background-color:
                                        <c:choose>
                                            <c:when test="${pedido.statusPedido.status() == 'Em Aberto'}">#F2E205</c:when>
                                            <c:when test="${pedido.statusPedido.status() == 'Recolhido'}">#CACACA</c:when>
                                            <c:when test="${pedido.statusPedido.status() == 'Aguardando Pagamento'}">#0460D9</c:when> 
                                            <c:when test="${pedido.statusPedido.status() == 'Pago'}">#FA7F08</c:when>
                                            <c:when test="${pedido.statusPedido.status() == 'Finalizado'}">#48D951</c:when> 
                                            <c:when test="${pedido.statusPedido.status() == 'Cancelado' || pedido.statusPedido.status() == 'Rejeitado'}">#F20530</c:when>
                                        </c:choose> 
                                        ">    
                                        <td>${pedido.numero}</td>
                                        <td><tags:localDateTime date="${pedido.dataCriacao}"/></td>
                                        <td>${pedido.statusPedido.status()}</td>
                                        <td>
                                            <c:if test="${pedido.statusPedido.status() == 'Em Aberto'}">
                                                <a href="controller?action=PedidoStatus&status=Recolher&id=${pedido.numero}&origin=PedidoVisual" class="btn btn-primary">Pedido Recolhido</a>
                                            </c:if>
                                            <c:if test="${pedido.statusPedido.status() == 'Recolhido'}">
                                                <a href="controller?action=PedidoStatus&status=Lavar&id=${pedido.numero}&origin=PedidoVisual" class="btn btn-primary">Pedido Lavado</a>
                                            </c:if>
                                            <c:if test="${pedido.statusPedido.status() == 'Pago'}">
                                                <a href="controller?action=PedidoStatus&status=Finalizar&id=${pedido.numero}&origin=PedidoVisual" class="btn btn-primary">Pedido Finalizado</a>
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
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</html>
