<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="br.com.fiap.fintech.Entities.ObjetivoFuturo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">

<head>
  <title>Future Goals</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <style>
    .form-container {
      padding-bottom: 80px; /* Adjust as needed to ensure button visibility */
    }
    .modal {
      z-index: 1050; /* Adjust this value as necessary */
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
  <h2>Objetivos Futuros</h2>
  <!-- Redirect button -->
  <div class="text-end mb-3">
    <a href="insert_ObjetivoFuturo.jsp" class="btn btn-primary">
      <i class="fa fa-plus"></i> Add New Goal
    </a>
  </div>

  <c:choose>
    <c:when test="${not empty objFuturo}">
      <div class="list-group d-flex">
        <c:forEach items="${objFuturo}" var="of">
          <div class="d-flex justify-content-between align-items-center border-bottom p-3 w-100">
            <div class="col-8">
              <p class="fw-bold mb-0">${of.descricao}</p>
              <p class="mb-0">Target Quantity: ${of.quantidadeAlvo}</p>
              <p class="mb-0">Current Value: R$ ${of.valorAtual}</p>
              <p class="mb-0">Type: ${of.tipo}</p>
              <p class="mb-0">User ID: ${of.usuarioIdUsuario}</p>
            </div>

            <div class="col-4 text-end">
              <a href="/insertObjetivoFuturo?acao=abrir-form-edicao&codigo=${of.idObjetivo}" class="btn btn-warning btn-sm">
                <i class="fa fa-pencil"></i> Edit
              </a>

              <form action="/insertObjetivoFuturo" method="get" onsubmit="return confirm('Are you sure you want to delete this goal?');" style="display:inline;">
                <input type="hidden" name="acao" value="deletar" />
                <input type="hidden" name="codigo" value="${of.idObjetivo}" />
                <button type="submit" class="btn btn-danger btn-sm">
                  <i class="fa fa-trash"></i> Delete
                </button>
              </form>
            </div>
          </div>
        </c:forEach>
      </div>
    </c:when>
    <c:otherwise>
      <p>No future goals found.</p>
    </c:otherwise>
  </c:choose>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
