<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Despesa</title>
</head>
<body>
<h2>Update Despesa</h2>
<form action="updateDespesa" method="post">
    <!-- Hidden field to hold the despesa ID -->
    <input type="hidden" name="id_despesa" value="${despesa.id_despesa}">

    <!-- Descricao field -->
    <label for="descricao">Descrição:</label>
    <input type="text" id="descricao" name="descricao" value="${despesa.descricao}" required>
    <br>

    <!-- Valor field -->
    <label for="valor">Valor:</label>
    <input type="number" step="0.01" id="valor" name="valor" value="${despesa.valor}" required>
    <br>



    <label for="dataPagamento" class="form-label">Data de Pagamento:</label>
    <input type="date" class="form-control" id="dataPagamento" name="dataPagamento" required>

    <!-- Status Pagamento field -->
    <label for="status_pagamento">Status Pagamento (P/U):</label>
    <input type="text" id="status_pagamento" name="status_pagamento" value="${despesa.status_pagamento}" required maxlength="1">
    <br>

    <!-- Categoria field -->
    <label for="categoria">Categoria:</label>
    <input type="text" id="categoria" name="categoria" value="${despesa.categoria}" required>
    <br>

    <!-- Usuario ID field -->
    <label for="usuario_id">Usuário ID:</label>
    <input type="number" id="usuario_id" name="usuario_id" value="${despesa.usuario_id}" required>
    <br>

    <!-- Submit button -->
    <button type="submit">Update</button>
</form>
</body>
</html>
