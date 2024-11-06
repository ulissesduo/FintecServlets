
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="InvestimentoTServlet" method="post">
        <label for="tipo_investimento">Tipo de Investimento:</label>
        <select name="tipo_investimento" required>
            <c:forEach var="type" items="${investmentTypes}">
                <option value="${type.id}">${type.typeName}</option>
            </c:forEach>
        </select>

        <label for="valor_investido">Valor Investido:</label>
        <input type="number" step="0.01" name="valor_investido" required>

        <label for="data_inicio">Data de Início:</label>
        <input type="datetime-local" name="data_inicio" required>

        <label for="data_resgate">Data de Resgate:</label>
        <input type="datetime-local" name="data_resgate" required>

        <label for="usuario_id">Usuário ID:</label>
        <input type="number" name="usuario_id" required>

        <button type="submit">Salvar Investimento</button>
    </form>

</body>
</html>
