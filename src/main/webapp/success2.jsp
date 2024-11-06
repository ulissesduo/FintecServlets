<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="br.com.fiap.fintech.Entities.InvestmentFIAP" %>


<html>
<head>
    <title>Investment Data</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
<h2>Investment Data</h2>

<table>
    <thead>
    <tr>
        <th>Investment ID</th>
        <th>Description</th>
        <th>Type</th>
        <th>Amount</th>
        <th>Date</th>
        <th>User ID</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${investmentFIAPList}" var="investmentFIAP">
        <tr>
            <td>${investmentFIAP.InvestmentID}</td>
            <td>${investmentFIAP.Description}</td>
            <td>${investmentFIAP.Type}</td>
            <td>${investmentFIAP.Amount}</td>
            <td>${investmentFIAP.Date}</td>
            <td>${investmentFIAP.UserId}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<br>
<a href="investmentFIAPForm.jsp">Go back to the form</a>
</body>
</html>
