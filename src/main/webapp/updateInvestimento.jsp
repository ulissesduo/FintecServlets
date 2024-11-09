<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <title>Update Investment</title>
</head>
<body>
<h1>Update Investment</h1>

<form action="${pageContext.request.contextPath}/investimentos" method="post">
  <input type="hidden" name="acao" value="update">
  <input type="hidden" name="idInvestimento" value="${investimento.idInvestimento}">

  <label for="tipoInvestimento">Investment Type:</label>
  <select id="tipoInvestimento" name="tipoInvestimento" required>
    <option value="${investimento.tipoInvestimento}">${investimento.tipoInvestimento}</option>
    <!-- You can add more options here if needed -->
  </select><br>

  <label for="valorInvestido">Amount Invested:</label>
  <input type="text" id="valorInvestido" name="valorInvestido" value="${investimento.valorInvestido}" required><br>

  <label for="dataInicio">Start Date (yyyy-MM-dd HH:mm:ss):</label>
  <input type="text" id="dataInicio" name="dataInicio" value="${investimento.dataInicio}" required><br>

  <label for="dataResgate">Rescue Date (yyyy-MM-dd HH:mm:ss):</label>
  <input type="text" id="dataResgate" name="dataResgate" value="${investimento.dataResgate}" required><br>

  <label for="usuarioId">User ID:</label>
  <input type="text" id="usuarioId" name="usuarioId" value="${investimento.usuarioId}" required><br>

  <input type="submit" value="Update">
</form>

</body>
</html>