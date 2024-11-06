<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FIAP Investment Form</title>
</head>
<body>
<h2>FIAP Investment Form</h2>
<form action="fiapInvestment" method="post">
    <label for="description">Description:</label><br>
    <input type="text" id="description" name="description" required><br><br>

    <label for="type">Type:</label><br>
    <input type="text" id="type" name="type" required><br><br>

    <label for="amount">Amount:</label><br>
    <input type="number" step="0.01" id="amount" name="amount" required><br><br>

    <label for="userId">User ID:</label><br>
    <input type="number" id="userId" name="userId" required><br><br>

    <input type="submit" value="Submit">
</form>
</body>
</html>
