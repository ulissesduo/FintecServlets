<%@ page import="br.com.fiap.fintech.Entities.Despesa" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Despesas</title>
</head>
<body>
<h2>List of Expenses</h2>
<%
  List<Despesa> despesaList = (List<Despesa>) request.getAttribute("despesaList");
  if (despesaList != null && !despesaList.isEmpty()) {
%>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Description</th>
    <th>Value</th>
    <th>Payment Date</th>
    <th>Payment Status</th>
    <th>Category</th>
    <th>User ID</th>
  </tr>
  <% for (Despesa despesa : despesaList) { %>
  <tr>
    <td><%= despesa.getId_despesa() %></td>
    <td><%= despesa.getDescricao() %></td>
    <td><%= despesa.getValor() %></td>
    <td><%= despesa.getData_pagamento() %></td>
    <td><%= despesa.getStatus_pagamento() %></td>
    <td><%= despesa.getCategoria() %></td>
    <td><%= despesa.getUsuario_id() %></td>
  </tr>
  <% } %>
</table>
<%
} else {
%>
<p>No expenses found.</p>
<%
  }
%>
</body>
</html>
