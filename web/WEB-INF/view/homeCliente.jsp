<%-- 
    Document   : homeCliente.jsp
    Created on : 19 de nov. de 2022, 17:05:44
    Author     : juann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

            <div class="card mb-3">
                <div class="card-header text-center">
                    Pedido #00001 - Em aberto
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-5 card-text text-start"">
                            <p class="mb-0">Realizado em 01/01/01</p>
                            <p>Prazo - 2 dias</p>
                        </div>
                        <div class="col-7">
                            <div class="row align-items-start justify-content-between">
                                <div class="col text-start">Subtotal</div>
                                <div class="col ">R$ 00,00</div>
                            </div>
                            <div class="row align-items-start justify-content-between">
                                <div class="col text-start">Frete</div>
                                <div class="col">R$ 00,00</div>
                            </div>
                            <div class="row align-items-start justify-content-between">
                                <div class="col text-start">Total</div>
                                <div class="col">R$ 00,00</div>
                            </div>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="text-center">
                            <h3>Itens do pedido</h3>
                        </div>
                        <ul class="text-start" style="list-style-type:none">
                            <li>1x - Calça</li>
                            <li>2x - Camiseta</li>
                            <li>1x - Jaqueta</li>
                            <li>6x - Meias</li>
                        </ul>
                    </div>
                    <div class="text-end">
                        <a href="#" class="btn btn-danger">Cancelar pedido</a>
                        <a href="#" class="btn btn-primary">Pagar pedido</a>   
                    </div>
                </div>
            </div>

            <div class="card mb-3">
                <div class="card-header text-center">
                    Pedido #00001 - Aguardando Pagamento
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-5 card-text text-start"">
                            <p class="mb-0">Realizado em 01/01/01</p>
                            <p>Prazo - 2 dias</p>
                        </div>
                        <div class="col-7">
                            <div class="row align-items-start justify-content-between">
                                <div class="col text-start">Subtotal</div>
                                <div class="col ">R$ 00,00</div>
                            </div>
                            <div class="row align-items-start justify-content-between">
                                <div class="col text-start">Frete</div>
                                <div class="col">R$ 00,00</div>
                            </div>
                            <div class="row align-items-start justify-content-between">
                                <div class="col text-start">Total</div>
                                <div class="col">R$ 00,00</div>
                            </div>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="text-center">
                            <h3>Itens do pedido</h3>
                        </div>
                        <ul class="text-start" style="list-style-type:none">
                            <li>1x - Calça</li>
                            <li>2x - Camiseta</li>
                            <li>1x - Jaqueta</li>
                            <li>6x - Meias</li>
                        </ul>
                    </div>
                    <div class="text-end">
                        <a href="#" class="btn btn-primary">Pagar pedido</a>   
                    </div>
                </div>
            </div>

            <div class="card mb-3">
                <div class="card-header text-center">
                    Pedido #00001 - Concluído
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col-5 card-text text-start"">
                            <p class="mb-0">Realizado em 01/01/01</p>
                            <p>Prazo - 2 dias</p>
                        </div>
                        <div class="col-7">
                            <div class="row align-items-start justify-content-between">
                                <div class="col text-start">Subtotal</div>
                                <div class="col ">R$ 00,00</div>
                            </div>
                            <div class="row align-items-start justify-content-between">
                                <div class="col text-start">Frete</div>
                                <div class="col">R$ 00,00</div>
                            </div>
                            <div class="row align-items-start justify-content-between">
                                <div class="col text-start">Total</div>
                                <div class="col">R$ 00,00</div>
                            </div>
                        </div>
                    </div>
                    <div class="row mt-2">
                        <div class="text-center">
                            <h3>Itens do pedido</h3>
                        </div>
                        <ul class="text-start" style="list-style-type:none">
                            <li>1x - Calça</li>
                            <li>2x - Camiseta</li>
                            <li>1x - Jaqueta</li>
                            <li>6x - Meias</li>
                        </ul>
                    </div>
                </div>
            </div>
            
        </div>
    </body>
</html>

<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>

