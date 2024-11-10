<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Gastos Recorrentes</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
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

<div class="container mt-5">
    <h2>Insert Gastos Recorrentes</h2>
    <form action="insertGastosRecorrentes" method="post">
        <div class="form-group">
            <label for="idDespesa">ID Despesa:</label>
            <input type="number" class="form-control" id="idDespesa" name="idDespesa" required>
        </div>
        <div class="form-group">
            <label for="descricao">Descrição:</label>
            <input type="text" class="form-control" id="descricao" name="descricao" required>
        </div>
        <div class="form-group">
            <label for="valor">Valor:</label>
            <input type="number" step="0.01" class="form-control" id="valor" name="valor" required>
        </div>
        <div class="form-group">
            <label for="dataPagamento">Data de Pagamento:</label>
            <input type="date" class="form-control" id="dataPagamento" name="dataPagamento" required>
        </div>

        <div class="form-group">
            <label for="statusPagamento">Status de Pagamento:</label>
            <input type="text" class="form-control" id="statusPagamento" name="statusPagamento" required maxlength="1">
        </div>
        <div class="form-group">
            <label for="categoria">Categoria:</label>
            <input type="text" class="form-control" id="categoria" name="categoria" required>
        </div>
        <div class="form-group">
            <label for="usuarioId">ID do Usuário:</label>
            <input type="number" class="form-control" id="usuarioId" name="usuarioId" required>
        </div>
        <div class="form-group">
            <label for="endDate">Data de Término:</label>
            <input type="date" class="form-control" id="endDate" name="endDate" required>
        </div>
        <div class="form-group">
            <label for="nextPaymentDate">Próxima Data de Pagamento:</label>
            <input type="date" class="form-control" id="nextPaymentDate" name="nextPaymentDate" required>
        </div>
        <div class="form-group">
            <label for="autoPay">Autopagamento (1 para sim, 0 para não):</label>
            <input type="number" class="form-control" id="autoPay" name="autoPay" required>
        </div>
        <div class="form-group">
            <label for="recurringNote">Nota Recorrente:</label>
            <textarea class="form-control" id="recurringNote" name="recurringNote"></textarea>
        </div>
        <div class="form-group">
            <label for="isCanceled">Status Cancelado (1 para sim, 0 para não):</label>
            <input type="number" class="form-control" id="isCanceled" name="isCanceled" required>
        </div>
        <div class="form-group">
            <label for="frequencia">Frequência:</label>
            <select class="form-control" id="frequencia" name="frequencia" required>
                <option value="mensal">Mensal</option>
                <option value="anual">Anual</option>
                <option value="semanal">Semanal</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Inserir Gastos Recorrentes</button>
    </form>
</div>
</body>
</html>
