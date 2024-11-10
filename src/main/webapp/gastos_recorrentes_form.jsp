<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <title>Adicionar Gastos Recorrentes</title>
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
    <h1 class="text-center mb-4">Adicionar Gastos Recorrentes</h1>
    <form action="insertGastosRecorrentes" method="post" class="bg-secondary p-4 rounded">

        <div class="mb-3">
            <label for="descricao" class="form-label">Descrição:</label>
            <input type="text" id="descricao" name="descricao" class="form-control" required>
        </div>


        <div class="mb-3">
            <label for="valor" class="form-label">Valor:</label>
            <input type="number" step="0.01" id="valor" name="valor" class="form-control" required>
        </div>

        <div class="mb-3">
            <label for="dataPagamento" class="form-label">Data de Pagamento:</label>
            <input type="date" id="dataPagamento" name="dataPagamento" class="form-control" required>
        </div>


        <div class="mb-3">
            <label for="frequencia" class="form-label">Frequência:</label>
            <input type="number" id="frequencia" name="frequencia" class="form-control" required>
        </div>


        <div class="mb-3">
            <label for="dataInicio" class="form-label">Data de Início:</label>
            <input type="date" id="dataInicio" name="dataInicio" class="form-control" required>
        </div>


        <div class="mb-3">
            <label for="dataFim" class="form-label">Data de Fim:</label>
            <input type="date" id="dataFim" name="dataFim" class="form-control" required>
        </div>


        <div class="mb-3">
            <label for="usuarioIdUsuario" class="form-label">ID do Usuário:</label>
            <input type="number" id="usuarioIdUsuario" name="usuarioIdUsuario" class="form-control" required>
        </div>


        <div class="d-grid">
            <button type="submit" class="btn btn-primary">Adicionar</button>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
