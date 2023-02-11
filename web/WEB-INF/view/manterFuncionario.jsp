<%-- 
    Document   : materFuncionario
    Created on : Dec 8, 2022, 4:30:48 PM
    Author     : Felipe
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="br.com.tads.model.Funcionario" %>
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
    </head>
    <body>
        <div class="container col-md-3">
            <h1>Cadastro de Funcionários</h1>
        </div>
        <div class="container" style="margin-top:100px">
            <div class="card">
                <div class="card-body">
                    <table class="table">
                        <thead class="table-primary">
                          <tr>
                            <th scope="col">Nome</th>
                            <th scope="col">Email</th>
                            <th scope="col">Nascimento</th>
                            <th scope="col"></th>
                            <th scope="col"></th>
                          </tr>
                        </thead>
                        <tbody>
                            <%                    
                            ArrayList<Funcionario> lista = new ArrayList<>();
                            Funcionario f = new Funcionario();
                            lista = f.listaFuncionario();

                            session.setAttribute("funcionario",lista);
                            %>
                            <c:forEach var="funcionario" items="${funcionario}">
                                <tr>
                                    <td>${funcionario.nome}</td>
                                    <td>${funcionario.email}</td>
                                    <td>${funcionario.nascimento}</td>
                                    <td><a href="#" class="btn btn-secondary col-5">editar</a></td>
                                    <td><a href="#" class="btn btn-danger col-5">excluir</a></td>
                                </tr> 
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <hr class="bg-primary border-4 border-top border-primary">
        <div class="container">
            <div class="card">
                <div class="card-body">
                    <form class="row g-3" action="controller?action=ManterFuncionario" method="post">
                        <div class="col-md-6">
                            <label for="inputEmail4" class="form-label">Email</label>
                            <input type="email" class="form-control" id="inputEmail4">
                        </div>
                        <div class="col-md-6">
                            <label for="inputPassword4" class="form-label">Senha</label>
                            <input type="password" class="form-control" id="inputPassword4">
                        </div>
                        <div class="col-md-6">
                            <label for="inputAddress" class="form-label">Nome</label>
                            <input type="text" class="form-control" id="inputName">
                        </div>
                        <div class="col-md-6">
                            <label for="inputAddress2" class="form-label">Nascimeto</label>
                            <input type="date" class="form-control" id="inputBirth">
                        </div>
                        <div class="col-12">
                            <button type="submit" class="btn btn-primary">Salvar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>