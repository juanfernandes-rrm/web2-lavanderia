<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Lavanderia</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/css/bootstrap.css">
    </head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-4 offset-md-4" style="margin-top: 50px;">
                <div class="card">
                    <div class="card-body">
                        <h3 class="card-title text-center">Login - Lavanderia On-Line</h3>
                            <form action="controller?action=Login" method="post">
                            <div class="form-group">
                                <label for="email">E-mail</label>
                                <input type="email" class="form-control" id="email" name="login" placeholder="seu@email.com">
                            </div>
                            <div class="form-group">
                                <label for="senha">Senha</label>
                                <input type="password" class="form-control" id="senha" name="senha" placeholder="Senha">
                            </div>
                            <button type="submit" class="btn btn-primary btn-block mt-3">Logar</button>
                            <a href="cadastro.jsp" class="btn btn-secondary btn-block mt-3" role="button">Não possui login? Cadastre-se</a>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
