<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="br.com.fiap.fintech.Entities.Despesa" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Despesas</title>
</head>
<body>
<h2>List of Expenses</h2>

<!-- Checking if the list is empty or null using JSTL -->
<c:choose>
  <c:when test="${not empty despesaList}">
    <table border="1">
      <tr>
        <th>ID</th>
        <th>Description</th>
        <th>Value</th>
        <th>Payment Date</th>
        <th>Payment Status</th>
        <th>Category</th>
        <th>User ID</th>
        <th>Edit</th>
        <th>Delete</th> <!-- New column header for delete button -->
      </tr>

      <!-- Iterating over the despesaList -->
      <c:forEach items="${despesaList}" var="despesa">
        <tr>
          <td>${despesa.id_despesa}</td>
          <td>${despesa.descricao}</td>
          <td>${despesa.valor}</td>
          <td>${despesa.data_pagamento}</td>
          <td>${despesa.status_pagamento}</td>
          <td>${despesa.categoria}</td>
          <td>${despesa.usuario_id}</td>
          <td>
            <a href="/insertDespesa?acao=abrir-form-edicao&codigo=${despesa.id_despesa}">Editar</a>
          </td>
          <td>
            <!-- Delete button form -->
            <form action="/insertDespesa" method="get" onsubmit="return confirm('Are you sure you want to delete this expense?');">
              <input type="hidden" name="acao" value="deletar" />
              <input type="hidden" name="codigo" value="${despesa.id_despesa}" />
              <button type="submit">Delete</button>
            </form>
          </td>
        </tr>
      </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
    <p>No expenses found.</p>
  </c:otherwise>
</c:choose>

</body>
</html>
