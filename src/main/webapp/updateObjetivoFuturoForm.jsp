<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="br.com.fiap.fintech.Entities.ObjetivoFuturo" %>
<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <title>Update Objetivo Futuro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-dark text-light">

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
<div class="container mt-5">
    <h2 class="text-center mb-4">Update Objetivo Futuro</h2>
    <form action="insertObjetivoFuturo" method="post" class=" p-4 rounded">
        <!-- Hidden input field for ID -->
        <input type="hidden" name="idObjetivo" value="${objetivoFuturo.idObjetivo}" />

        <!-- Description Field -->
        <div class="mb-3">
            <label for="descricao" class="form-label">Description:</label>
            <input type="text" id="descricao" name="descricao" class="form-control" value="${objetivoFuturo.descricao}" required />
        </div>

        <!-- Target Quantity Field -->
        <div class="mb-3">
            <label for="quantidadeAlvo" class="form-label">Target Quantity:</label>
            <input type="number" id="quantidadeAlvo" name="quantidadeAlvo" class="form-control" value="${objetivoFuturo.quantidadeAlvo}" required />
        </div>

        <!-- Current Value Field -->
        <div class="mb-3">
            <label for="valorAtual" class="form-label">Current Value:</label>
            <input type="number" id="valorAtual" name="valorAtual" step="0.01" class="form-control" value="${objetivoFuturo.valorAtual}" required />
        </div>

        <!-- Type Field -->
        <div class="mb-3">
            <label for="tipo" class="form-label">Type:</label>
            <input type="text" id="tipo" name="tipo" class="form-control" value="${objetivoFuturo.tipo}" required />
        </div>

        <!-- User ID Field -->
        <div class="mb-3">
            <label for="usuarioIdUsuario" class="form-label">User ID:</label>
            <input type="number" id="usuarioIdUsuario" name="usuarioIdUsuario" class="form-control" value="${objetivoFuturo.usuarioIdUsuario}" required />
        </div>

        <!-- Submit Button -->
        <div class="d-grid">
            <button type="submit" class="btn btn-primary">Update</button>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
