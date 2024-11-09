<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Insert Investment</title>
</head>
<body>
<h1>Insert New Investment</h1>

<form action="${pageContext.request.contextPath}/investimentos" method="post">
    <input type="hidden" name="acao" value="insert">

    <label for="tipoInvestimento">Investment Type:</label>
    <select id="tipoInvestimento" name="tipoInvestimento" required>
        <option value="Stock">Stock</option>
        <option value="Bond">Bond</option>
        <option value="Real Estate">Real Estate</option>
        <!-- Add more investment types if necessary -->
    </select><br>

    <label for="valorInvestido">Amount Invested:</label>
    <input type="text" id="valorInvestido" name="valorInvestido" required><br>

    <label for="dataInicio">Start Date (yyyy-MM-dd HH:mm:ss):</label>
    <input type="text" id="dataInicio" name="dataInicio" required><br>

    <label for="dataResgate">Rescue Date (yyyy-MM-dd HH:mm:ss):</label>
    <input type="text" id="dataResgate" name="dataResgate" required><br>

    <label for="usuarioId">User ID:</label>
    <input type="text" id="usuarioId" name="usuarioId" required><br>

    <input type="submit" value="Insert">
</form>

</body>
</html>
