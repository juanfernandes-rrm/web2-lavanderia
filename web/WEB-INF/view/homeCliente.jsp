<%-- 
    Document   : homeCliente.jsp
    Created on : 19 de nov. de 2022, 17:05:44
    Author     : juann
--%>

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
        <title>Home Cliente</title>
    </head>
    <body>
        <div class="text-center my-3">
        <h1>PEDIDOS</h1>
        </div>
        <div class="container text-end col-7">
            <div class="mb-3">
                <a href="controller?action=PedidoForm" class="btn btn-primary">Fazer pedido</a> 
            </div>
            <div class="mb-3">
                <select class="form-select" aria-label="Todos os pedidos">
                    <option selected>Todos os pedidos</option>
                    <option value="1">Pedidos Em aberto</option>
                    <option value="2">Pedidos Cancelados</option>
                    <option value="3">pedidos Entregues</option>
                  </select>
            </div>
            
            <c:forEach var="pedido" items="${listPedido}">
                    <div class="card mb-3">
                        <div class="card-header text-center">
                            Pedido #${pedido.numero} - ${pedido.statusPedido.status()}
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="col-5 card-text text-start"">
                                    <p class="mb-0">Realizado em: <tags:localDateTime date="${pedido.dataCriacao}"/></p>
                                    <p>Prazo - <tags:localDate date="${pedido.orcamento.prazo}"/></p></p>
                                </div>
                                <div class="col-7">
                                    <div class="row align-items-start justify-content-between">
                                        <div class="col text-start">Subtotal</div>
                                        <div class="col "><fmt:formatNumber value="0" minFractionDigits="2" type="currency" /></div>
                                    </div>
                                    <div class="row align-items-start justify-content-between">
                                        <div class="col text-start">Frete</div>
                                        <div class="col"><fmt:formatNumber value="0" minFractionDigits="2" type="currency" /></div>
                                    </div>
                                    <div class="row align-items-start justify-content-between">
                                        <div class="col text-start">Total</div>
                                        <div class="col"><fmt:formatNumber value="${pedido.orcamento.valor}" minFractionDigits="2" type="currency" /></div>
                                    </div>
                                </div>
                            </div>
                            <div class="row mt-2">
                                <div class="text-center">
                                    <h3>Itens do pedido</h3>
                                </div>
                                <ul class="text-start" style="list-style-type:none">
                                    <c:forEach var="roupa" items="${pedido.roupas}">
                                        <li>${roupa.qtdPeca}x - ${roupa.peca} = <fmt:formatNumber value="${roupa.qtdPeca * roupa.peca.preco}" minFractionDigits="2" type="currency" /></li>
                                    </c:forEach>
                                </ul>
                            </div>
                            <div class="text-end">
                                <a href="#" class="btn btn-danger">Cancelar pedido</a>
                                <a href="#" class="btn btn-primary">Pagar pedido</a>   
                            </div>
                        </div>
                    </div>
                </c:forEach>
            
        </div>
    </body>
</html>

<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

