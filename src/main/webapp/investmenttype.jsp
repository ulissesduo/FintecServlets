<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.fiap.fintech.Entities.InvestmentType" %>

<html>
<head>
  <title>Investment Types</title>
  <style>
    body { font-family: Arial, sans-serif; }
    table { width: 50%; margin-top: 20px; border-collapse: collapse; }
    table, th, td { border: 1px solid black; padding: 10px; }
    th { background-color: #f2f2f2; }
    .form-container { margin-top: 20px; }
  </style>
</head>
<body>

<h2>List of Investment Types</h2>

<%
  List<InvestmentType> listInvestmentType = (List<InvestmentType>) request.getAttribute("listInvestmentType");
  if (listInvestmentType != null && !listInvestmentType.isEmpty()) {
%>
<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Description</th>
  </tr>
  </thead>
  <tbody>
  <% for (InvestmentType type : listInvestmentType) { %>
  <tr>
    <td><%= type.getId() %></td>
    <td><%= type.getDescription() %></td>
  </tr>
  <% } %>
  </tbody>
</table>
<%
} else {
%>
<p>No investment types found.</p>
<%
  }
%>

<div class="form-container">
  <h2>Add New Investment Type</h2>
  <form action="addInvestmentType" method="post">
    <label for="description">Description:</label>
    <input type="text" id="description" name="description" required>
    <button type="submit">Add Investment Type</button>
  </form>
</div>

</body>
</html>
