<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="br.com.fiap.fintech.Entities.Despesa" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Expense</title>
</head>
<body>

<nav>
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-none col-md-block d-flex flex-column desktop">
                <div class="navbar navbar-expand-lg navbar-dark bg-dark nav-top-menu">
                    <a class="navbar-brand" href="home.jsp">Home</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div class="navbar-nav">
                            <li class="nav-item">
                                <a href="investimentos" class="nav-link">investimentos</a>
                            </li>
                            <li class="nav-item">
                                <a href="insertDespesa" class="nav-link">Despesa</a>
                            </li>
                            <li class="nav-item">
                                <a href="insertObjetivoFuturo" class="nav-link">Objetivos</a>
                            </li>
                            <li class="nav-item">
                                <a href="insertDespesa" class="nav-link">Gastos</a>
                            </li>
                        </div>
                    </div>
                    <c:if test="${not empty user}">
                        <span class="navbar-text me-2">${user}</span>
                        <a href="login" class="btn btn-outline-primary">Sair</a>
                    </c:if>
                </div>
            </div>
            <div class="col-12 d-md-none mobile p-3 mb-2 text-white rounded-bottom-4">
                <h3 class="d-flex justify-content-center">Investimentos</h3>
            </div>

        </div>
    </div>
</nav>
<h2>Edit Expense</h2>

<!-- Form to update a despesa -->
<form action="/insertDespesa" method="POST">
    <input type="hidden" name="id_despesa" value="${despesa.id_despesa}" />

    Description: <input type="text" name="descricao" value="${despesa.descricao}" required><br>
    Value: <input type="text" name="valor" value="${despesa.valor}" required><br>
    Category: <input type="text" name="categoria" value="${despesa.categoria}" required><br>
    Payment Status: <input type="text" name="statusPagamento" value="${despesa.status_pagamento}" required><br>
    Payment Date: <input type="date" name="dataPagamento" value="${despesa.data_pagamento}" required><br>

    User ID: <input type="text" name="usuarioId" value="${despesa.usuario_id}" required><br>

    <input type="submit" value="Update Expense">
</form>

</body>
</html>
