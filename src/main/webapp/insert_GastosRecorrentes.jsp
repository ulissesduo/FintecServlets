<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert Gastos Recorrentes</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
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
