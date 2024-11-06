<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Investimentos</title>
</head>
<body>
<h1>Investimentos</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tipo</th>
        <th>Valor</th>
        <th>Data Início</th>
        <th>Data Resgate</th>
        <th>Usuário</th>
    </tr>
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
</table>
<h2>Adicionar Investimento</h2>
<form action="${pageContext.request.contextPath}/investimentos" method="post">
    <label for="tipoInvestimento">Investment Type:</label>
    <input type="number" id="tipoInvestimento" name="tipoInvestimento" required><br>

    <label for="tipoInvestimento">Investment Type:</label>
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
