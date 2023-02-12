<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar roupa</title>
    </head>
    <body>
        <div class="container">
            <div>
                <h1>Editar roupa</h1>
            </div>
            <form class="row g-3" action="controller?action=RoupaUpdate&id=${roupa.id}" method="post">
                <div class="col">
                    <label for="peca" class="form-label">Nome da peça</label>
                    <input type="text" class="form-control" id="peca" name="peca" value="${roupa.peca}">
                </div>
                
                <div class="col">
                    <label for="valor" class="form-label">Valor</label>
                    <input type="text" class="form-control" id="valor" name="valor" value="${roupa.valor}">
                </div>
                
                <div class="col">
                    <label for="prazo-entrega" class="form-label">Prazo de entrega (dias)</label>
                    <input type="number" class="form-control" id="prazo-entrega" name="prazo-entrega" value="${roupa.prazoEntrega}">
                </div>
                
                <div class="col-12">
                    <button type="submit" class="btn btn-primary">Cadastrar</button>
                </div>
            </form>
        </div> 
    </body>
</html>
