<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Item List</title>
</head>
<body>

<h2>List of Items</h2>

<ul>
  <c:forEach items="${itemList}" var="item">
    <li>
      <a href="teste?itemId=${item}">${item}</a>
    </li>
  </c:forEach>
</ul>

</body>
</html>
