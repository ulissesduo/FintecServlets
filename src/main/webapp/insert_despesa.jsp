<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Insert Despesa</title>
</head>
<body>
<h1>Insert Despesa</h1>
<form action="insertDespesa" method="post">
  <label for="descricao">Descrição:</label>
  <input type="text" id="descricao" name="descricao" required><br><br>

  <label for="valor">Valor:</label>
  <input type="number" step="0.01" id="valor" name="valor" required><br><br>

  <label for="dataPagamento">Data de Pagamento:</label>
  <input type="date" id="dataPagamento" name="dataPagamento" required><br><br>

  <label for="statusPagamento">Status de Pagamento (P/Paid or U/Unpaid):</label>
  <input type="text" id="statusPagamento" name="statusPagamento" maxlength="1" required><br><br>

  <label for="categoria">Categoria:</label>
  <input type="text" id="categoria" name="categoria" required><br><br>

  <label for="usuarioId">ID do Usuário:</label>
  <input type="number" id="usuarioId" name="usuarioId" required><br><br>

  <input type="submit" value="Insert Despesa">
</form>
</body>
</html>
