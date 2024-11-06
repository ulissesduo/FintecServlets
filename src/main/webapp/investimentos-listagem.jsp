<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>List of Investments</title>
</head>
<body>
<h1>Investments List</h1>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tipo Investimento</th>
        <th>Valor Investido</th>
        <th>Data Inicio</th>
        <th>Data Resgate</th>
        <th>Usuario ID</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="investimento" items="${investimentos}">
        <tr>
            <td>${investimento.idInvestimento}</td>
            <td>${investimento.tipoInvestimento}</td>
            <td>${investimento.valorInvestido}</td>
            <td>${investimento.dataInicio}</td>
            <td>${investimento.dataResgate}</td>
            <td>${investimento.usuarioId}</td>
        </tr>
    </c:forEach>
    <c:if test="${empty investimentos}">
        <tr>
            <td colspan="6">No investments found.</td>
        </tr>
    </c:if>
    </tbody>
</table>

<h2>Adicionar Investimento</h2>
<form action="${pageContext.request.contextPath}/investimentos" method="post">
<%--    <label for="tipoInvestimento">Investment Type:</label>--%>
<%--    <input type="number" id="tipoInvestimento" name="tipoInvestimento" required><br>--%>

    <jsp:include page="dropdown.jsp" /><br>

    <label for="valorInvestido">Amount Invested:</label>
    <input type="text" id="valorInvestido" name="valorInvestido" required><br>

    <label for="dataInicio">Start Date (yyyy-MM-dd HH:mm:ss):</label>
    <input type="text" id="dataInicio" name="dataInicio" required><br>

    <label for="dataResgate">Rescue Date (yyyy-MM-dd HH:mm:ss):</label>
    <input type="text" id="dataResgate" name="dataResgate" required><br>

    <label for="usuarioId">User ID:</label>
    <input type="text" id="usuarioId" name="usuarioId" required><br>

    <input type="submit" value="Submit">
</form>
<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

</body>
</html>
