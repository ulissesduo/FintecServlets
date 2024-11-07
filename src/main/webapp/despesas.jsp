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
            <!-- Create the edit link with dynamic parameters -->
            <c:url value="/insertDespesa" var="link">
              <c:param name="acao" value="abrir-form-edicao"/>
              <c:param name="codigo" value="${despesa.id_despesa}"/>
            </c:url>
            <a href="${link}">Editar</a>
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
