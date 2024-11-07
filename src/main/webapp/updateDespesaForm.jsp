<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="br.com.fiap.fintech.Entities.Despesa" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Expense</title>
</head>
<body>

<h2>Edit Expense</h2>

<!-- Form to update a despesa -->
<form action="/insertDespesa" method="POST">
    <input type="hidden" name="id_despesa" value="${despesa.id_despesa}" />

    Description: <input type="text" name="descricao" value="${despesa.descricao}" required><br>
    Value: <input type="text" name="valor" value="${despesa.valor}" required><br>
    Category: <input type="text" name="categoria" value="${despesa.categoria}" required><br>
    Payment Status: <input type="text" name="statusPagamento" value="${despesa.status_pagamento}" required><br>
    Payment Date: <input type="text" name="dataPagamento" value="${despesa.data_pagamento}" required><br>
    User ID: <input type="text" name="usuarioId" value="${despesa.usuario_id}" required><br>

    <input type="submit" value="Update Expense">
</form>

</body>
</html>
