<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <title>Insert Gastos Recorrentes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-dark text-light">

<div class="container mt-5">
    <h1 class="text-center mb-4">Insert Gastos Recorrentes</h1>
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
