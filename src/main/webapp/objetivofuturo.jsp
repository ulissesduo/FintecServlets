<%@ page import="br.com.fiap.fintech.Entities.ObjetivoFuturo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Future Goals</title>
</head>
<body>
<h2>List of Future Goals</h2>
<%
  List<ObjetivoFuturo> objFuturo = (List<ObjetivoFuturo>) request.getAttribute("objFuturo");
  if (objFuturo != null && !objFuturo.isEmpty()) {
%>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Description</th>
    <th>Target Quantity</th>
    <th>Current Value</th>
    <th>Type</th>
    <th>User ID</th>
  </tr>
  <% for (ObjetivoFuturo of : objFuturo) { %>
  <tr>
    <td><%= of.getIdObjetivo() %></td>
    <td><%= of.getDescricao() %></td>
    <td><%= of.getQuantidadeAlvo() %></td>
    <td><%= of.getValorAtual() %></td>
    <td><%= of.getTipo() %></td>
    <td><%= of.getUsuarioIdUsuario() %></td>
  </tr>
  <% } %>
</table>
<%
} else {
%>
<p>No future goals found.</p>
<%
  }
%>
</body>
</html>
