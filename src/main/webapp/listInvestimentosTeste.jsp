<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Investment List</title>
</head>
<body>
<h2>List of Investment Tests</h2>
<table border="1">
  <tr>
    <th>ID</th>
    <th>Value</th>
  </tr>
  <c:forEach var="investimento" items="${investimentos}">
    <tr>
      <td>${investimento.id}</td>
      <td>${investimento.valor}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
