<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Insert Objetivo Futuro</title>
</head>
<body>
<form action="insertObjetivoFuturo" method="post">
    <label for="descricao">Descrição:</label>
    <input type="text" id="descricao" name="descricao" required><br><br>

    <label for="quantidadeAlvo">Quantidade Alvo:</label>
    <input type="number" id="quantidadeAlvo" name="quantidadeAlvo" required><br><br>

    <label for="valorAtual">Valor Atual:</label>
    <input type="number" step="0.01" id="valorAtual" name="valorAtual" required><br><br>

    <label for="tipo">Tipo:</label>
    <input type="text" id="tipo" name="tipo" required><br><br>

    <input type="hidden" name="usuarioIdUsuario" value="1">

    <input type="submit" value="Insert Objetivo Futuro">
</form>
</body>
</html>
