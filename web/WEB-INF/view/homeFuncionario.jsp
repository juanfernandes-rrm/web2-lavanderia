<%-- 
    Document   : homeFuncionario
    Created on : Nov 26, 2022, 1:34:49 PM
    Author     : Felipe
--%>

<<<<<<< HEAD
<%@ page import="java.util.ArrayList" %>
<%@ page import="br.com.tads.model.PedidoTeste" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
=======
<%@page contentType="text/html" pageEncoding="UTF-8"%>
>>>>>>> ef843d8643274b18c1e26a6ff7a9e39269500c36
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
<<<<<<< HEAD
                        <li class="nav-item "><a class="nav-link me-lg-3" href="controller?action=ManterRoupas">Cadastro de Itens</a></li>
                        <li class="nav-item "><a class="nav-link me-lg-3" href="controller?action=ManterFuncionario">Manter Funcionário</a></li>
=======
>>>>>>> ef843d8643274b18c1e26a6ff7a9e39269500c36
                        <li class="nav-item"><a class="nav-link me-lg-3" href="controller?action=VisualPedidos">Visualização de pedidos</a></li>
                    </ul>
                     <a href="controller?action=Login" class="btn btn-primary">Sair</a> 
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
<<<<<<< HEAD
                    <%                    
                    ArrayList<PedidoTeste> lista = new ArrayList<PedidoTeste>();
                    PedidoTeste p = new PedidoTeste();
                    lista = p.PedidosLista();
                    
                    session.setAttribute("pedidos",lista);
                    int i = 0;
                    %>
                    <c:forEach var="pedidos" items="${pedidos}">
                        <%
                            PedidoTeste t = new PedidoTeste();
                            t = lista.get(i);
                            if (t.getStatusPedido() == "EM ABERTO"){
                        %>
                        <tr>
                            <td>${pedidos.numero}</td>
                            <td>${pedidos.dataCriacao}</td>
                            <td>${pedidos.statusPedido}</td>
                            <td><a href="#" class="btn btn-primary">Recolhido</a></td>
                        </tr> 
                        <%
                            }
                            i++;
                        %>
                    </c:forEach>
=======
                    <% // tabela dinâmica com adição do botão para "Recolher Pedido"
                        %>
>>>>>>> ef843d8643274b18c1e26a6ff7a9e39269500c36
                </tbody>
            </table>
        </div>
    </body>
    
    
</html>
