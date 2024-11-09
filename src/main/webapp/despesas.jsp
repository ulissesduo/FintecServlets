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
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />
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
  <div class="d-sm-none d-md-block desktop">
    <div class="navbar navbar-expand-lg navbar-black bg-black nav-top-menu">
      <a class="navbar-brand" href="#">Home</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
              aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
          <a class="nav-item nav-link" href="#">Finance <span class="sr-only">(current)</span></a>
          <a class="nav-item nav-link" href="#">New Expense</a>
          <a class="nav-item nav-link" href="#">Profile</a>
        </div>
      </div>
    </div>
  </div>
  <div class="p-3 mb-2 text-white rounded-bottom-4 d-md-none mobile">
    <h3 class="d-flex justify-content-center">Despesa</h3>
    <div class="d-flex justify-content-between">
      <p>Disponível para resgate</p>
      <p>R$ 3.200,00</p>
    </div>
    <p class="text-success">Resgatar</p>
  </div>
</nav>

<div class="container mt-5 form-container">
  <h2>Despesas</h2>

  <c:choose>
    <c:when test="${not empty despesaList}">
      <div class="list-group d-flex">
        <c:forEach items="${despesaList}" var="despesa">
          <div class="d-flex justify-content-between align-items-center border-bottom p-3 w-100">
            <div class="col-2 text-center">
             </div>
            <div class="col-6">
              <p class="fw-bold mb-0">${despesa.descricao}</p>
              <p class="mb-0">${despesa.categoria}</p>
            </div>
            <div class="col-4 text-end">
              <p class="fw-bold mb-0">Banco Inter</p>
              <p class="text-danger mb-0">- R$ ${despesa.valor}</p>
            </div>
          </div>
        </c:forEach>
      </div>
    </c:when>
    <c:otherwise>
      <p>No expenses found.</p>
    </c:otherwise>
  </c:choose>
</div>

<nav>
</nav>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>