<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">

<head>
    <title>Investimentos</title>
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
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-none col-md-block d-flex flex-column desktop">
                <div class="navbar navbar-expand-lg navbar-dark bg-dark nav-top-menu">
                    <a class="navbar-brand" href="#">Home</a>
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                        <div class="navbar-nav">
                            <a class="nav-item nav-link" href="#">Finance <span class="sr-only">(current)</span></a>
                            <a class="nav-item nav-link" href="#">New Investment</a>
                            <a class="nav-item nav-link" href="#">Profile</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-12 d-md-none mobile p-3 mb-2 text-white rounded-bottom-4">
                <h3 class="d-flex justify-content-center">Investimentos</h3>
            </div>
        </div>
    </div>
</nav>

<div class="container mt-5 form-container">
    <h2>Investimentos</h2>
    <!-- Redirect button -->
    <div class="text-end mb-3">
        <a href="insert_Investimento.jsp" class="btn btn-primary">
            <i class="fa fa-plus"></i> Add New Investment
        </a>
    </div>
    <c:choose>
        <c:when test="${not empty investimentos}">
            <div class="list-group d-flex">
                <c:forEach items="${investimentos}" var="investimento">
                    <div class="d-flex justify-content-between align-items-center border-bottom p-3 w-100">
                        <div class="col-2 text-center">
                        </div>
                        <div class="col-6">
                            <p class="fw-bold mb-0">${investimento.tipoDescricao}</p> <!-- Display description -->
                            <p class="mb-0">Valor Investido: R$ ${investimento.valorInvestido}</p>
                            <p class="mb-0">Data Início: ${investimento.dataInicio}</p>
                            <p class="mb-0">Data Resgate: ${investimento.dataResgate}</p>
                        </div>
                        <div class="col-4 text-end">
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:when>
        <c:otherwise>
            <p>No investments found.</p>
        </c:otherwise>
    </c:choose>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C89scichPD02hX1v7vAxqF08+LT7DcnB6BspAsl9KMnqGWgDkCMq9A9F9DNCQ65" crossorigin="anonymous"></script>
</body>

</html>