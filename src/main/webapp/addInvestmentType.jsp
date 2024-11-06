<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Investment Type</title>
</head>
<body>
<h2>Add New Investment Type</h2>
<form action="/addInvestmentType" method="post">
  <label for="description">Description:</label>
  <input type="text" name="description" id="description" required>
  <button type="submit">Add Investment Type</button>
</form>
</body>
</html>
