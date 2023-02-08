<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/css/bootstrap.css">
        <title>Cadastro de conta</title>
    </head>
    <body>
        <div class="container">
        <div class="row">
            <div class="col-md-4 offset-md-4" style="margin-top: 50px;">
                <div class="card">
                    <div class="card-body">
                        <h3 class="card-title text-center">Login - Lavanderia On-Line</h3>
                        <form action="controller?action=Cadastro" method="post">
                            
                            <div class="form-group">
                                <label for="cpf">CPF</label>
                                <input type="text" class="form-control" id="cpf" name="cpf" placeholder="***.***.***-**">
                            </div>
                            
                            <div class="form-group">
                                <label for="nome">Nome</label>
                                <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome completo">
                            </div>
                            
                            <div class="form-group">
                                <label for="email">E-mail</label>
                                <input type="email" class="form-control" id="email" name="email" placeholder="seu@email.com">
                            </div>
                            
                            <div class="form-group">
                                <label for="cep">CEP</label>
                                <input type="text" class="form-control" id="cep" name="cep" placeholder="CEP">
                            </div>
                            
                            <div class="form-group">
                                <label for="estado">Estado</label>
                                <input type="text" class="form-control" id="estado" name="estado" placeholder="Estado">
                            </div>
                            
                            <div class="form-group">
                                <label for="cidade">Cidade</label>
                                <input type="text" class="form-control" id="cidade" name="cidade" placeholder="Cidade">
                            </div>
                            
                            <div class="form-group">
                                <label for="bairro">Bairro</label>
                                <input type="text" class="form-control" id="bairro" name="bairro" placeholder="Bairro">
                            </div>
                            
                            <div class="form-group">
                                <label for="rua">Rua</label>
                                <input type="text" class="form-control" id="rua" name="rua" placeholder="Rua">
                            </div>
                            
                            <div class="form-group">
                                <label for="numero">Número da casa</label>
                                <input type="text" class="form-control" id="numero" name="numero" placeholder="Número da casa">
                            </div>
                            
                            <div class="form-group">
                                <label for="telefone">Telefone</label>
                                <input type="fone" class="form-control" id="telefone" name="telefone" placeholder="(**) 9 ****-****">
                            </div>
                            
                            <button type="submit" class="btn btn-primary btn-block mt-3">Cadastrar</button>
                            <a href="controller?action=LoginForm" class="btn btn-secondary btn-block mt-3" role="button">Logar</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
   
    <script type="text/javascript" src="static/js/viacep-webservice.js"></script>
    
</html>
