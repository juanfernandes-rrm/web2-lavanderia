<!DOCTYPE html>
<html>
    <head>
        <title>Lavanderia</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/css/bootstrap.css">
    </head>
    <body>
    <div class="h-100 d-flex align-items-center justify-content-center">
        <div class="row">
            <div class="col-lg-4 col-lg-offset-4">
                <div class="input-group">
                    <form action="controller?action=Login" method="post">
                        Login: <input type="text" name="login" /><br/>
                        Senha: <input type="password" name="senha" /><br/>
                        <br/><input type="submit" value="Logar" /><br/><br/>
                    </form>
                <a href=cadastro.jsp>Não possui login? Cadastre-se</a>
                </div>
            </div>
        </div>
    </div>
    </body>
</html>
