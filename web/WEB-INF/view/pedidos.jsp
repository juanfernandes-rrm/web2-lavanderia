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
        <nav class="navbar navbar-expand-lg navbar-light shadow-sm" id="mainNav">
            <div class="container px-5">
                <span class="navbar-brand mb-0 h1">LOL</span>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto me-4 my-3 my-lg-0">
                        <li class="nav-item"><a class="nav-link me-lg-2 mt-1" href="controller?action=HomeFuncionario">Home</a></li>
                        <li class="nav-item"><a class="me-lg-2 mt-1 btn btn-primary" href="controller?action=PedidoForm">Fazer pedido</a></li>
                        <li class="nav-item"><a class="me-lg-2 mt-1 btn btn-primary" href="controller?action=Logout">Sair</a></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="container text-end col-7">
                
            <div class="mb-3 mt-3">
                
                <div class="btn-group align-content-center mb-3" role="group">       
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
                
                <!-- PEsquisar como acionar esse evento (talvez ajax)-->
                <select class="form-select" name="filtro-status" aria-label="Todos os pedidos" onchange="controller?action=OrcamentoLista">
                    <option selected value="EmAnalise">Em análise</option>
                    <option value="Rejeitado">Rejeitado</option>
                    <option value="EmAberto">Em aberto</option>
                    <option value="Cancelado">Cancelado</option>
                    <option value="Recolhido">Recolhido</option>
                    <option value="AguardandoPagamento">Aguardando pagamento</option>
                    <option value="Pago">Pago</option>
                    <option value="Finalizado">Finalizado</option>
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
                                <c:if test="${pedido.statusPedido.status() != 'Rejeitado'}">
                                    <a href="#" class="btn btn-danger">Cancelar pedido</a>
                                    <a href="#" class="btn btn-primary">Pagar pedido</a> 
                                </c:if> 
                            </div>
                        </div>
                    </div>
                </c:forEach>
            
        </div>
    </body>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</html>
