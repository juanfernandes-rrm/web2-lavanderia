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
<!------------------------------------------------------------------------------------------------------------------------------------------------------------------->
        
        <div class="container">
        <div class="row">
            <div class="col-md-12 offset-lg-0 mx-auto" style="margin-top: 50px;">
                <div class="card">
                    <div class="card-body">
                        <h3 class="card-title text-center">Login - Lavanderia On-Line</h3>
                        <form class="row g-3" action="controller?action=CadastroFuncionario" method="post">
                            
                            <div class="col-md-6">
                                <label for="cpf">CPF</label>
                                <input type="text" class="form-control" id="cpf" name="cpf" placeholder="***.***.***-**">
                            </div>
                            
                            <div class="col-md-6">
                                <label for="nome">Nome</label>
                                <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome completo">
                            </div>
                            
                            <div class="col-md-6">
                                <label for="email">E-mail</label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="seu@email.com">
                            </div>
                            
                            <div class="col-md-6">
                                <label for="cep">CEP</label>
                                <input type="text" class="form-control" id="cep" name="cep" placeholder="CEP">
                            </div>
                            
                            <div class="col-md-6">
                                <label for="estado">Estado</label>
                                <input type="text" class="form-control" id="estado" name="estado" placeholder="Estado">
                            </div>
                            
                            <div class="col-md-6">
                                <label for="cidade">Cidade</label>
                                <input type="text" class="form-control" id="cidade" name="cidade" placeholder="Cidade">
                            </div>
                            
                            <div class="col-md-6">
                                <label for="bairro">Bairro</label>
                                <input type="text" class="form-control" id="bairro" name="bairro" placeholder="Bairro">
                            </div>
                            
                            <div class="col-md-6">
                                <label for="rua">Rua</label>
                                <input type="text" class="form-control" id="rua" name="rua" placeholder="Rua">
                            </div>
                            
                            <div class="col-md-6">
                                <label for="numero">Número da casa</label>
                                <input type="text" class="form-control" id="numero" name="numero" placeholder="Número da casa">
                            </div>
                            
                            <div class="col-md-6">
                                <label for="telefone">Telefone</label>
                                <input type="fone" class="form-control" id="telefone" name="telefone" placeholder="(**) 9 ****-****">
                            </div>
                            <input type="hidden" name="iscliente" value="false">
                            <button type="submit" class="btn btn-primary btn-block mt-3">Cadastrar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<!------------------------------------------------------------------------------------------------------------------------------------------------------------------->       

        <div class="container" style="margin-top:2em">
            <div class="card">               
                <div class="card-body" style="margin-bottom:1em">
                    <form class="row g-0" method="POST" action="controller?action=ListarFuncionario">
                        <button type="submit" class="btn btn-outline-secondary">Listar</button>
                    </form> 
                    <table style="margin-top:1em" class="table">
                        <thead class="table-primary">
                          <tr>
                            <th scope="col">Nome</th>
                            <th scope="col">Email</th>
                            <th scope="col">CPF</th>
                            <th scope="col"></th>
                            <th scope="col"></th>
                          </tr>
                        </thead>
                        <tbody>
                        <c:if test="${not empty funcionarios}">
                            <c:forEach var="funcionario" items="${funcionarios}">
                              <tr>
                                <td>${funcionario.nome}</td>
                                <td>${funcionario.email}</td>
                                <td>${funcionario.cpf}</td>
                                <input type="hidden" name="id" value="${funcionario.id}"/>
                                <td><a href="controller?action=EditarFuncionario" class="btn btn-secondary col-5">editar</a></td>
                                <td><a href="controller?action=ExcluirFuncionario" class="btn btn-danger col-5">excluir</a></td>
                              </tr> 
                            </c:forEach>
                        </c:if> 
                        <c:if test="${empty funcionarios}">
                            <div style="margin-top:1em" class="alert alert-danger" role="alert">
                                <p>Lista de funcionarios vazia!</p>
                            </div>
                        </c:if>      
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
    <script type="text/javascript" src="static/js/viacep-webservice.js"></script>
</html>