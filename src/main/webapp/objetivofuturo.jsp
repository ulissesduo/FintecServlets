<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="br.com.fiap.fintech.Entities.ObjetivoFuturo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Future Goals</title>
</head>
<body>
<h2>List of Future Goals</h2>

<!-- Checking if the list is empty or null using JSTL -->
<c:choose>
  <c:when test="${not empty objFuturo}">
    <table border="1">
      <tr>
        <th>ID</th>
        <th>Description</th>
        <th>Target Quantity</th>
        <th>Current Value</th>
        <th>Type</th>
        <th>User ID</th>
        <th>Edit</th>
        <th>Delete</th> <!-- New column header for delete button -->
      </tr>

      <!-- Iterating over objFuturo -->
      <c:forEach items="${objFuturo}" var="of">
        <tr>
          <td>${of.idObjetivo}</td>
          <td>${of.descricao}</td>
          <td>${of.quantidadeAlvo}</td>
          <td>${of.valorAtual}</td>
          <td>${of.tipo}</td>
          <td>${of.usuarioIdUsuario}</td>
          <td>
            <a href="/insertObjetivoFuturo?acao=abrir-form-edicao&codigo=${of.idObjetivo}">Editar</a>
          </td>
          <td>
            <!-- Delete button form -->
            <form action="/insertObjetivoFuturo" method="get" onsubmit="return confirm('Are you sure you want to delete this goal?');">
              <input type="hidden" name="acao" value="deletar" />
              <input type="hidden" name="codigo" value="${of.idObjetivo}" />
              <button type="submit">Delete</button>
            </form>
          </td>
        </tr>
      </c:forEach>
    </table>
  </c:when>
  <c:otherwise>
    <p>No future goals found.</p>
  </c:otherwise>
</c:choose>

</body>
</html>
