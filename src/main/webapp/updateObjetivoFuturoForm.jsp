<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="br.com.fiap.fintech.Entities.ObjetivoFuturo" %>
<html>
<head>
    <title>Update Objetivo Futuro</title>
</head>
<body>
<h2>Update Objetivo Futuro</h2>

<form action="insertObjetivoFuturo" method="post">
    <input type="hidden" name="idObjetivo" value="${objetivoFuturo.idObjetivo}" />

    <label for="descricao">Description:</label>
    <input type="text" id="descricao" name="descricao" value="${objetivoFuturo.descricao}" required /><br><br>

    <label for="quantidadeAlvo">Target Quantity:</label>
    <input type="number" id="quantidadeAlvo" name="quantidadeAlvo" value="${objetivoFuturo.quantidadeAlvo}" required /><br><br>

    <label for="valorAtual">Current Value:</label>
    <input type="number" id="valorAtual" name="valorAtual" step="0.01" value="${objetivoFuturo.valorAtual}" required /><br><br>

    <label for="tipo">Type:</label>
    <input type="text" id="tipo" name="tipo" value="${objetivoFuturo.tipo}" required /><br><br>

    <label for="usuarioIdUsuario">User ID:</label>
    <input type="number" id="usuarioIdUsuario" name="usuarioIdUsuario" value="${objetivoFuturo.usuarioIdUsuario}" required /><br><br>

    <button type="submit">Update</button>
</form>

</body>
</html>
