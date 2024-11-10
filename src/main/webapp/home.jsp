<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>FiapStore - Home</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="./resources/css/bootstrap.css">
</head>
<body class="bg-dark text-light"> <!-- Applying dark mode background and text color -->

<%@include file="header.jsp" %>

<div class="container mt-5">
  <c:if test="${empty user}">
    <h1 class="mt-3">Você não está autenticado!</h1>
    <h5>Para acessar o sistema, identifique-se!</h5>
  </c:if>
  <c:if test="${not empty user}">
    <h1 class="mt-3">Bem-vindo!</h1>
    <h5>Seu login foi efetuado com sucesso!</h5>


    <form action="/" method="post" class="mt-3">
      <button type="submit" class="btn btn-outline-light">Sair</button>
    </form>
  </c:if>
</div>

<script src="resources/js/bootstrap.bundle.js"></script>
</body>
</html>
