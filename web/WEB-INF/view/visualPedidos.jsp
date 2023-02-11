<%-- 
    Document   : visualPedidos
    Created on : Nov 26, 2022, 2:10:34 PM
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
                <form method="POST" action="controller?action=PedidoController">
                    <input type="hidden" name="filtro" value="todos">
                    <button type="submit" class="btn btn-outline-secondary">Todos</button>
                </form>
                <form method="POST" action="controller?action=PedidoController">
                    <input type="hidden" name="filtro" value="hoje">
                    <button type="submit" class="btn btn-outline-secondary">Pedidos de Hoje</button>
                </form>    
                <button class="btn btn-outline-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">Período</button>
                    <div class="dropdown-menu px-4 py-3">
                        <form method="POST" action="controller?action=PedidoController">
                            <div class="mb-3">
                                <label for="inicio">Início:</label></br>
                                <input type="date" id="iniData" name="iniData">
                            </div>
                            <div class="mb-3">
                                <label for="fim">Fim:</label></br>
                                <input type="date" id="fimData" name="fimData"></br>
                            </div>
                            <input type="hidden" name="filtro" value="range">
                            <button type="submit" class="btn btn-secondary">Pesquisar</button>
                        </form>
                    </div>
            </div>    
        </div>

        <c:set var="origin" value="visualPedidos.jsp" />
        <c:set var="controller" value="new PedidoFuncionarioFiltro()" />
        <c:set var="result" value="${controller.execute(request, response)}" />
        <c:set var="pedidos" value="${requestScope.pedidos}" />
       
        
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
                                <c:forEach var="pedidos" items="${pedidos}">
                                    <c:choose>
                                        <c:when test="${pedidos.statusPedido == 'EM ABERTO'}">
                                            <tr class="table-warning">
                                                <td>${pedidos.numero}</td>
                                                <td>${pedidos.dataCriacao}</td>
                                                <td>${pedidos.statusPedido}</td>
                                                <td>
                                                    <input type="hidden" name="pedido" value="${pedido.numero}"/>
                                                    <input type="hidden" name="acao" value="recolhido"/>
                                                    <input type="submit" class="btn btn-primary col-5" value="Recolhido"/>
                                                </td>
                                            </tr> 
                                        </c:when>
                                        <c:when test="${pedidos.statusPedido == 'RECOLHIDO'}">
                                            <tr class="table-secondary">
                                                <td>${pedidos.numero}</td>
                                                <td>${pedidos.dataCriacao}</td>
                                                <td>${pedidos.statusPedido}</td>
                                                <td>
                                                    <input type="hidden" name="pedido" value="${pedido.numero}"/>
                                                    <input type="hidden" name="acao" value="lavado"/>
                                                    <input type="submit" class="btn btn-primary col-5" value="Lavado"/>
                                                </td>
                                            </tr> 
                                        </c:when>
                                        <c:when test="${pedidos.statusPedido == 'AGUARDANDO'}">
                                            <tr class="table-info">
                                                <td>${pedidos.numero}</td>
                                                <td>${pedidos.dataCriacao}</td>
                                                <td>${pedidos.statusPedido}</td>
                                                <td>
                                                    <input type="hidden" name="pedido" value="${pedido.numero}"/>
                                                    <input type="hidden" name="acao" value="pago"/>
                                                    <input type="submit" class="btn btn-primary col-5" value="Pago"/>
                                                </td>
                                            </tr> 
                                        </c:when>
                                        <c:when test="${pedidos.statusPedido == 'PAGO'}">
                                            <tr style="background-color: #fecba4">
                                                <td>${pedidos.numero}</td>
                                                <td>${pedidos.dataCriacao}</td>
                                                <td>${pedidos.statusPedido}</td>
                                                <td>
                                                    <input type="hidden" name="pedido" value="${pedido.numero}"/>
                                                    <input type="hidden" name="acao" value="finalizar"/>
                                                    <input type="submit" class="btn btn-primary col-5" value="Finalizar "/>
                                                </td>
                                            </tr>
                                        </c:when>
                                        <c:when test="${pedidos.statusPedido == 'FINALIZADO'}">
                                            <tr style="background-color: #74b69a">
                                                <td>${pedidos.numero}</td>
                                                <td>${pedidos.dataCriacao}</td>
                                                <td>${pedidos.statusPedido}</td>
                                                <td></td>
                                            </tr>
                                        </c:when>        
                                         <c:when test="${pedidos.statusPedido == 'CANCELADO'}">
                                             <tr class="table-danger">
                                                <td>${pedidos.numero}</td>
                                                <td>${pedidos.dataCriacao}</td>
                                                <td>${pedidos.statusPedido}</td>
                                                <td></td>
                                            </tr>
                                        </c:when>     
                                    </c:choose>>            
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
