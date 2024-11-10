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
