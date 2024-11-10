<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="br.com.fiap.fintech.Factory.ConnectionFactory" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" data-bs-theme="dark">

<head>
    <meta charset="UTF-8">
    <title>Edit Investment</title>
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
    <h1 class="text-center mb-4">Edit Investment</h1>
    <form action="investimentos" method="POST" class="bg-secondary p-4 rounded">
        <!-- Hidden input field to pass the investment ID -->
        <input type="hidden" name="id" value="${investimento.idInvestimento}" />

        <!-- Field for Tipo Investimento -->
        <div class="mb-3">
            <label for="tipoInvestimento" class="form-label">Tipo Investimento:</label>
            <select id="tipoInvestimento" name="tipoInvestimento" class="form-select" required>
                <option value="">Select</option>
                <%
                    try {
                        Connection con = ConnectionFactory.getConnection();
                        Statement stmt = con.createStatement();
                        String query = "SELECT * FROM tipos_investimentos";
                        ResultSet rs = stmt.executeQuery(query);
                        while (rs.next()) {
                            String selected = "";
                            Long tipoInvestimentoId = (Long) request.getAttribute("investimento.tipoInvestimento");

                            if (tipoInvestimentoId != null && rs.getLong("ID") == tipoInvestimentoId) {
                                selected = "selected";
                            }
                %>
                <option value="<%= rs.getInt("ID") %>" <%= selected %>><%= rs.getString("Description") %></option>
                <%
                        }
                        rs.close();
                        stmt.close();
                        con.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                %>
            </select>
        </div>

        <!-- Field for Valor Investido -->
        <div class="mb-3">
            <label for="valorInvestido" class="form-label">Valor Investido:</label>
            <input type="text" id="valorInvestido" name="valorInvestido" class="form-control" value="${investimento.valorInvestido}" required />
        </div>

        <!-- Field for Data Início -->
        <div class="mb-3">
            <label for="dataInicio" class="form-label">Data Início:</label>
            <input type="date" id="dataInicio" name="dataInicio" class="form-control" value="${investimento.dataInicio}" required />
        </div>

        <!-- Field for Data Resgate -->
        <div class="mb-3">
            <label for="dataResgate" class="form-label">Data Resgate:</label>
            <input type="date" id="dataResgate" name="dataResgate" class="form-control" value="${investimento.dataResgate}" required />
        </div>

        <!-- Field for User ID -->
        <div class="mb-3">
            <label for="usuarioIdUsuario" class="form-label">User ID:</label>
            <input type="number" id="usuarioIdUsuario" name="usuarioIdUsuario" class="form-control" value="${investimento.usuarioId}" required />
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
