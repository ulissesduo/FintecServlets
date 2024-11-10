<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Investimentos</title>
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
<h1>Investimentos</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tipo</th>
        <th>Valor</th>
        <th>Data Início</th>
        <th>Data Resgate</th>
        <th>Usuário</th>
    </tr>
    <c:forEach var="investimento" items="${investimentos}">
        <tr>
            <td>${investimento.idInvestimento}</td>
            <td>${investimento.tipoInvestimento}</td>
            <td>${investimento.valorInvestido}</td>
            <td>${investimento.dataInicio}</td>
            <td>${investimento.dataResgate}</td>
            <td>${investimento.usuarioId}</td>
        </tr>
    </c:forEach>
</table>
<h2>Adicionar Investimento</h2>
<form action="${pageContext.request.contextPath}/investimentos" method="post">
    <label for="tipoInvestimento">Investment Type:</label>
    <input type="number" id="tipoInvestimento" name="tipoInvestimento" required><br>

    <label for="tipoInvestimento">Investment Type:</label>
    <jsp:include page="dropdown.jsp" /><br>

    <label for="valorInvestido">Amount Invested:</label>
    <input type="text" id="valorInvestido" name="valorInvestido" required><br>

    <label for="dataInicio">Start Date (yyyy-MM-dd HH:mm:ss):</label>
    <input type="text" id="dataInicio" name="dataInicio" required><br>

    <label for="dataResgate">Rescue Date (yyyy-MM-dd HH:mm:ss):</label>
    <input type="text" id="dataResgate" name="dataResgate" required><br>

    <label for="usuarioId">User ID:</label>
    <input type="text" id="usuarioId" name="usuarioId" required><br>

    <input type="submit" value="Submit">
</form>
<c:if test="${not empty error}">
    <p style="color: red;">${error}</p>
</c:if>

</body>
</html>
