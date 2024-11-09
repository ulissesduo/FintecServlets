<%@ page import="br.com.fiap.fintech.Entities.TipoInvestimento" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="br.com.fiap.fintech.Factory.ConnectionFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Insert Investimento</title>
</head>
<body>
<form action="investimentos" method="post">
  <label for="tipoInvestimento">Investment Type:</label>
  <select id="tipoInvestimento" name="tipoInvestimento" required>
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
  <br><br>


  <label for="valor">Valor:</label>
  <input type="number" id="valor" name="valor" step="0.01" required><br><br>

  <label for="dataInicio">Data de Início:</label>
  <input type="date" id="dataInicio" name="dataInicio" required><br><br>

  <label for="dataResgate">Data de Resgate:</label>
  <input type="date" id="dataResgate" name="dataResgate" required><br><br>

  <input type="hidden" name="usuarioId" value="1">
  <input type="submit" value="Insert Investimento">
</form>

</body>
</html>
