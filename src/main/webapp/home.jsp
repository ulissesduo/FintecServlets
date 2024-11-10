<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>FiapStore - Home</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<%--  <link rel="stylesheet" href="./resources/css/bootstrap.css">--%>
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
  <h1 class="mt-3">Bem-Vindo!</h1>

  <c:if test="${empty user}">
    <h5>Você não está autenticado! Para acessar o sistema, identifique-se!</h5>
  </c:if>
  <c:if test="${not empty user}">
    <h5>Seu login foi efetuado com sucesso!</h5>
  </c:if>
</div>

<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>
