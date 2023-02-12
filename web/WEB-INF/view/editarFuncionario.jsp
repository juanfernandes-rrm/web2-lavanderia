<%-- 
    Document   : editarFuncionario
    Created on : Feb 12, 2023, 11:01:18 AM
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
        
    <div class="container">
        <div class="row">
            <div class="col-md-12 offset-lg-0 mx-auto" style="margin-top: 50px;">
                <div class="card">
                    <div class="card-body">
                        <h3 class="card-title text-center">Login - Lavanderia On-Line</h3>
                        
                        <form class="row g-3" action="controller?action=AtualizarFuncionario" method="post">

                            <div class="col-md-6">
                                <label for="cpf">CPF</label>
                                <input type="text" class="form-control" id="cpf" name="cpf" value="${funcionario.cpf}" placeholder="***********" required>
                            </div>
                            <script>
                              $(document).ready(function() {
                                    $("#cpf").mask("99999999999");
                              });
                            </script>
                            <div class="col-md-6">
                                <label for="nome">Nome</label>
                                <input type="text" class="form-control" id="nome" name="nome" value="${funcionario.nome}" placeholder="Nome completo" required>
                            </div>

                            <div class="col-md-6">
                                <label for="email">E-mail</label>
                                <input type="email" class="form-control" id="email" name="email" value="${funcionario.email}" placeholder="seu@email.com" required>
                            </div>

                            <div class="col-md-6">
                                <label for="cep">CEP</label>
                                <input type="text" class="form-control" id="cep" name="cep"  placeholder="CEP" required>
                            </div>
                            <script>
                              $(document).ready(function() {
                                    $("#cep").mask("99999999");
                              });
                            </script> 
                            <div class="col-md-6">
                                <label for="estado">Estado</label>
                                <input type="text" class="form-control" id="estado" name="estado" value="${funcionario.endereco.cidade}" placeholder="Estado" required>
                            </div>

                            <div class="col-md-6">
                                <label for="cidade">Cidade</label>
                                <input type="text" class="form-control" id="cidade" name="cidade" value="${funcionario.endereco.estado}" placeholder="Cidade" required>
                            </div>

                            <div class="col-md-6">
                                <label for="bairro">Bairro</label>
                                <input type="text" class="form-control" id="bairro" name="bairro" value="${funcionario.endereco.bairro}" placeholder="Bairro" required>
                            </div>

                            <div class="col-md-6">
                                <label for="rua">Rua</label>
                                <input type="text" class="form-control" id="rua" name="rua" value="${funcionario.endereco.rua}" placeholder="Rua" required>
                            </div>

                            <div class="col-md-6">
                                <label for="numero">Número da casa</label>
                                <input type="text" class="form-control" id="numero" name="numero" value="${funcionario.endereco.numero}" placeholder="Número da casa" required>
                            </div>

                            <div class="col-md-6">
                                <label for="telefone">Telefone</label>
                                <input type="fone" class="form-control" id="telefone" name="telefone" value="${funcionario.telefone}" placeholder="(**) 9 ********" required>
                            </div>
                            <script>
                              $(document).ready(function() {
                                    $("#telefone").mask("99999999999");
                              });
                            </script>
                            <input type="hidden" name="senha" value="${funcionario.senha}">
                            <input type="hidden" name="endereco" value="${funcionario.endereco.id}">
                            <input type="hidden" name="id" value="${funcionario.id}">
                            <button type="submit" class="btn btn-primary btn-block mt-3">Salvar</button>
                        
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
    <script type="text/javascript" src="static/js/viacep-webservice.js"></script>
</html>                       
