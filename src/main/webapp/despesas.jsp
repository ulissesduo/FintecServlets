<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="br.com.fiap.fintech.Entities.Despesa" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">

<head>
  <title>Despesas</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="style.css">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
<div class="container mt-5">
  <h2>List of Expenses</h2>

  <!-- Button to add a new expense -->
  <div class="text-end mb-3">
    <a href="insert_despesa.jsp" class="btn btn-primary">
      <i class="fa fa-plus"></i> Nova Despesa
    </a>
  </div>

  <c:choose>
    <c:when test="${not empty despesaList}">
      <div class="table-responsive">
        <table class="table table-striped table-bordered">
          <thead class="table-dark">
          <tr>
            <th>ID</th>
            <th>Description</th>
            <th>Value</th>
            <th>Payment Date</th>
            <th>Payment Status</th>
            <th>Category</th>
            <th>User ID</th>
            <th>Edit</th>
            <th>Delete</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${despesaList}" var="despesa">
            <tr>
              <td>${despesa.id_despesa}</td>
              <td>${despesa.descricao}</td>
              <td>R$ ${despesa.valor}</td>
              <td>${despesa.data_pagamento}</td>
              <td>${despesa.status_pagamento}</td>
              <td>${despesa.categoria}</td>
              <td>${despesa.usuario_id}</td>
              <td>
                <a href="/insertDespesa?acao=abrir-form-edicao&codigo=${despesa.id_despesa}" class="btn btn-warning btn-sm">
                  <i class="fa fa-edit"></i> Edit
                </a>
              </td>
              <td>
                <!-- Delete button form -->
                <form action="/insertDespesa" method="get" onsubmit="return confirm('Are you sure you want to delete this expense?');" style="display:inline;">
                  <input type="hidden" name="acao" value="deletar" />
                  <input type="hidden" name="codigo" value="${despesa.id_despesa}" />
                  <button type="submit" class="btn btn-danger btn-sm">
                    <i class="fa fa-trash"></i> Delete
                  </button>
                </form>
              </td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </div>
    </c:when>
    <c:otherwise>
      <p class="text-center">No expenses found.</p>
    </c:otherwise>
  </c:choose>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
