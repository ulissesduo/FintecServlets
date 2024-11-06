<%@ page import="br.com.fiap.fintech.Entities.InvestmentType" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Insert Investimento</title>
</head>
<body>
<form action="insertInvestimento" method="post">
<%--  <label for="tipoInvestimento">Tipo Investimento:</label>--%>
<%--  <select id="tipoInvestimento" name="tipoInvestimento" required>--%>
<%--    <%--%>
<%--      List<InvestmentType> investmentTypes = (List<InvestmentType>) request.getAttribute("listInvestmentType");--%>
<%--      for (InvestmentType tipo : investmentTypes) {--%>
<%--    %>--%>
<%--    <option value="<%= tipo.getId() %>"><%= tipo.getDescription() %></option>--%>
<%--    <%--%>
<%--      }--%>
<%--    %>--%>
<%--  </select>--%>
  <br><br>

  <label for="valor">Valor:</label>
  <input type="number" id="valor" name="valor" step="0.01" required>
  <br><br>

  <label for="dataInicio">Data de Início:</label>
  <input type="date" id="dataInicio" name="dataInicio" required>
  <br><br>

  <label for="dataResgate">Data de Resgate:</label>
  <input type="date" id="dataResgate" name="dataResgate" required>
  <br><br>
  <input type="hidden" name="usuarioId" value="1">

  <input type="submit" value="Insert Investimento">
</form>
</body>
</html>
