<%@ page import="br.com.fiap.fintech.Entities.TipoInvestimento" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="br.com.fiap.fintech.Factory.ConnectionFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" data-bs-theme="dark">
<head>
  <title>Insert Investimento</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .form-container {
      padding-bottom: 80px;
    }
    .form-container input,
    .form-container select {
      margin-bottom: 15px;
    }
  </style>
</head>
<body>
<nav>
  <div class="container-fluid">
    <div class="row">
      <div class="col-12 text-center p-3 mb-2 text-white rounded-bottom-4 bg-dark">
        <h3>Insert New Investimento</h3>
      </div>
    </div>
  </div>
</nav>

<div class="container mt-5 form-container">
  <h2 class="text-white">Insert Investimento</h2>
  <form action="investimentos" method="post" class="bg-dark p-4 rounded">

    <div class="mb-3">
      <label for="tipoInvestimento" class="form-label text-white">Investment Type:</label>
      <select id="tipoInvestimento" name="tipoInvestimento" class="form-select" required>
        <option value="">Select</option>
        <%
          try {
            Connection con = ConnectionFactory.getConnection();
            Statement stmt = con.createStatement();
            String query = "SELECT * FROM tipos_investimentos";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
        %>
        <option value="<%= rs.getInt("ID") %>"><%= rs.getString("Description") %></option>
        <%
            }
            rs.close();
            stmt.close();
            con.close();
          } catch (Exception e) {
            e.printStackTrace(); // Log the error for debugging if needed
          }
        %>
      </select>
    </div>

    <div class="mb-3">
      <label for="valor" class="form-label text-white">Valor:</label>
      <input type="number" id="valor" name="valor" class="form-control" step="0.01" required>
    </div>

    <div class="mb-3">
      <label for="dataInicio" class="form-label text-white">Data de Início:</label>
      <input type="date" id="dataInicio" name="dataInicio" class="form-control" required>
    </div>

    <div class="mb-3">
      <label for="dataResgate" class="form-label text-white">Data de Resgate:</label>
      <input type="date" id="dataResgate" name="dataResgate" class="form-control" required>
    </div>

    <input type="hidden" name="usuarioId" value="1">

    <div class="text-center">
      <button type="submit" class="btn btn-primary">
        <i class="fa fa-plus"></i> Insert Investimento
      </button>
    </div>
  </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
