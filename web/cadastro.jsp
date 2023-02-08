<%-- 
   Document   : cadastro
   Created on : 6 de nov. de 2022, 09:04:01
   Author     : Gabriel
   --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <title>Cadastro</title>
      <link rel="stylesheet" href="resources/css/bootstrap.css">
      <style>
         body {
         width: 50%;
         margin: 0 auto;
         }
      </style>
   </head>
   <body>
      <h1 class = "mx-auto" style="width: 20%;">Cadastro</h1>
      <div class="card">
      <div class="card-body">
         <form action="CadastrarUsuario" method="post" class="mx-auto" style="width: 75%;">
            <div class="row">
               <div class="col">
                  <div class="form-group">
                     <label for="email">E-mail</label>
                     <input type="email" class="form-control" id="email" placeholder="Insira seu e-mail">
                  </div>
                  <div class="form-group">
                     <label for="cpf">CPF</label>
                     <input type="text" class="form-control" id="cpf" placeholder="Insira seu CPF">
                  </div>
               </div>
               <div class="col">
                  <div class="form-group">
                     <label for="telefone">Telefone</label>
                     <input type="tel" class="form-control" id="telefone" placeholder="Insira seu telefone">
                  </div>
                  <div class="form-group">
                     <label for="cep">CEP</label>
                     <input type="text" class="form-control" id="cep" placeholder="Insira seu CEP">
                  </div>
               </div>
            </div>
            <div class="form-group">
               <label for="endereco">Endereço</label>
               <input type="text" class="form-control" id="endereco" placeholder="Insira seu endereço">
            </div>
            <div class="text-center">
                <br>
               <button type="submit" class="btn btn-primary">Cadastrar</button>
               <br>
               <a href="." class="btn btn-secondary btn-block mt-3" role="button">Voltar</a>
            </div>
      </div>
      </form>
   </body>
</html>