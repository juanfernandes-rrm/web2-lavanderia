<%-- 
    Document   : cadastro
    Created on : 6 de nov. de 2022, 09:04:01
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro</title>
        <link rel="stylesheet" href="resources/css/bootstrap.css">
    </head>
    <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="row">
            <div class="col-lg-4 col-lg-offset-4">
                <div class="input-group">
                    <form action="controller?action=Cadastro" method="post">
                        Login: <input type="text" name="login" /><br/>
                        Senha: <input type="password" name="senha" /><br/>
                        CPF: <input type="text" name="cpf" /><br/>
                        E-mail: <input type="text" name="email" /><br/>
                        Logradouro: <input type="text" name="logradouro" /><br/>
                        CEP: <input type="text" name="cep" /><br/>
                        Telefone: <input type="text" name="telefone" /><br/>
                        <input type="hidden" value="Cadastrar" name="action"></br>
                        <input type="submit" value="Cadastrar" /><br/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</html>
