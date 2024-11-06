<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Insert Gastos Recorrentes</title>
</head>
<body>
<h1>Insert Gastos Recorrentes</h1>
<form action="insertGastosRecorrentes" method="post">
    <label for="descricao">Descrição:</label>
    <input type="text" id="descricao" name="descricao" required><br><br>

    <label for="valor">Valor:</label>
    <input type="number" step="0.01" id="valor" name="valor" required><br><br>

    <label for="dataPagamento">Data de Pagamento:</label>
    <input type="date" id="dataPagamento" name="dataPagamento" required><br><br>

    <label for="frequencia">Frequência:</label>
    <input type="number" id="frequencia" name="frequencia" required><br><br>

    <label for="dataInicio">Data de Início:</label>
    <input type="date" id="dataInicio" name="dataInicio" required><br><br>

    <label for="dataFim">Data de Fim:</label>
    <input type="date" id="dataFim" name="dataFim" required><br><br>

    <label for="usuarioIdUsuario">ID do Usuário:</label>
    <input type="number" id="usuarioIdUsuario" name="usuarioIdUsuario" required><br><br>

    <input type="submit" value="Insert Gastos Recorrentes">
</form>
</body>
</html>
