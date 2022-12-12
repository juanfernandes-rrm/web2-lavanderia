<html>
   <head>
        <title>Cadastro de Roupas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="resources/css/bootstrap.css">
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
        <div class="container">
            <h1 class="mx-auto" style="width: 50%;">Cadastro de Roupas</h1>
            <div class="card">
               <div class="card-body">
                  <form action="add_item" method="post">
                     <div class="form-group">
                        <label for="item">Item</label>
                        <input type="text" class="form-control" id="item" placeholder="Nome da peça">
                     </div>
                     <div class="form-group">
                        <label for="valor">Preço</label>
                        <input type="number" class="form-control" id="valor" placeholder="Valor da lavagem">
                     </div>
                     <div class="form-group">
                        <label for="prazo">Prazo (dias)</label>
                        <input type="number" class="form-control" id="prazo" placeholder="Prazo de entrega">
                     </div>
                      <br>
                     <button type="submit" class="btn btn-primary">Adicionar</button>
                  </form>
               </div>
            </div>
            <br>
            <div class="card">
               <div class="card-body">
                  <table class="table">
                     <thead>
                        <tr>
                           <th>Nome</th>
                           <th>Preço</th>
                           <th>Prazo (em dias)</th>
                           <th>Ações</th>
                        </tr>
                     </thead>
                     <tbody>
                        <tr>
                           <td>Calça Jeans</td>
                           <td>R$10</td>
                           <td>5</td>
                           <td>
                              <a href="" class="btn btn-secondary" role="button">Editar</a>
                              <a href="" class="btn btn-danger" role="button">Remover</a>
                           </td>
                        </tr>
                     </tbody>
               </div>
          </div>
        </div>    
   </body>
</html>
