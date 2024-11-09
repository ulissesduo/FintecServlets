<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Insert Despesa</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">  <div class="row justify-content-center">  <div class="col-md-6">  <h1 class="text-center mb-4">Insert Despesa</h1>  <form action="insertDespesa" method="post">
  <div class="form-group">  <label for="descricao" class="form-label">Descrição:</label>  <input type="text" class="form-control" id="descricao" name="descricao" required>  </div>
  <div class="form-group">
    <label for="valor" class="form-label">Valor:</label>
    <input type="number" step="0.01" class="form-control" id="valor" name="valor" required>
  </div>
  <div class="form-group">
    <label for="dataPagamento" class="form-label">Data de Pagamento:</label>
    <input type="date" class="form-control" id="dataPagamento" name="dataPagamento" required>
  </div>
  <div class="form-group">
    <label for="statusPagamento" class="form-label">Status de Pagamento (P/Paid or U/Unpaid):</label>
    <input type="text" class="form-control" id="statusPagamento" name="statusPagamento" maxlength="1" required>
  </div>
  <div class="form-group">
    <label for="categoria" class="form-label">Categoria:</label>
    <input type="text" class="form-control" id="categoria" name="categoria" required>
  </div>
  <div class="form-group">
    <label for="usuarioId" class="form-label">ID do Usuário:</label>
    <input type="number" class="form-control" id="usuarioId" name="usuarioId" required>
  </div>
  <button type="submit" class="btn btn-primary">Insert Despesa</button>  </form>
</div>
</div>
</div>
</body>
</html>