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
            <div class="col-12 text-center p-3 mb-2 text-white rounded-bottom-4 bg-dark">
                <h3>Insert New Future Goal</h3>
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
