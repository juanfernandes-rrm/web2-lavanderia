<%-- 
    Document   : cadastraPedido
    Created on : 22 de nov. de 2022, 21:01:30
    Author     : juann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/css/bootstrap.css">
        <title>Pedido</title>
    </head>
    <body>
        <div class="text-center my-3">
            <h1>PEDIDO</h1>
            </div>
        <div class="container text-end col-7 mt-5">
            
            <form action="controller?action=PedidoCadastrar" method="POST">
                
                <c:forEach var="roupa" items="${listRoupa}">
                    <div class="card">
                    <div class="card-body">
                        <div class="row text-start">
                            <div class="col-10">${roupa}</div>
                            <div class="col">
                                <input type="number" min="0" class="form-control" name="${roupa}" placeholder="0">
                            </div>
                        </div>  
                    </div>  
                </div>
                </c:forEach>
                
                <div class="row mt-5">
                    <div class="col">
                        <input class="btn btn-primary" type="submit" value="Fazer Orçamento" />
                    </div>
                </div>
            </form>

            
        </div>
    </body>
</html>

<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
