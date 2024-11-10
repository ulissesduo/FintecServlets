<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" data-bs-theme="dark">
<head>
    <title>Insert Objetivo Futuro</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .form-container {
            padding-bottom: 80px;
        }
        .form-container input,
        .form-container select {
            margin-bottom: 15px;
        }
    </style>
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

<div class="container mt-5 form-container">
    <h2>Insert Objetivo Futuro</h2>
    <form action="insertObjetivoFuturo" method="post" class="bg-dark p-4 rounded">
        <div class="mb-3">
            <label for="descricao" class="form-label text-white">Descrição:</label>
            <input type="text" id="descricao" name="descricao" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="quantidadeAlvo" class="form-label text-white">Quantidade Alvo:</label>
            <input type="number" id="quantidadeAlvo" name="quantidadeAlvo" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="valorAtual" class="form-label text-white">Valor Atual:</label>
            <input type="number" step="0.01" id="valorAtual" name="valorAtual" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="tipo" class="form-label text-white">Tipo:</label>
            <input type="text" id="tipo" name="tipo" class="form-control" required>
        </div>

        <input type="hidden" name="usuarioIdUsuario" value="1">

        <div class="text-center">
            <button type="submit" class="btn btn-primary">
                <i class="fa fa-plus"></i> Insert Objetivo Futuro
            </button>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
