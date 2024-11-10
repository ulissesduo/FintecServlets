<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Update User</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
  <style>
    body {
      background-color: #121212;
      color: #e0e0e0;
      display: flex;
      justify-content: center;
      align-items: center;
      height: 100vh;
      margin: 0;
    }
    .form-container {
      background-color: #333;
      padding: 30px;
      border-radius: 8px;
      width: 100%;
      max-width: 400px;
    }
  </style>
</head>
<body>
<div class="form-container">
  <h2 class="text-center text-light mb-4">Update User</h2>

  <form action="updateUser" method="post">
    <div class="mb-3">
      <label for="emailAntigo" class="form-label">Current Email</label>
      <input type="email" class="form-control" id="emailAntigo" name="emailAntigo" required>
    </div>

    <div class="mb-3">
      <label for="novoEmail" class="form-label">New Email</label>
      <input type="email" class="form-control" id="novoEmail" name="novoEmail" required>
    </div>

    <div class="mb-3">
      <label for="novaSenha" class="form-label">New Password</label>
      <input type="password" class="form-control" id="novaSenha" name="novaSenha" required>
    </div>

    <div class="d-grid">
      <button type="submit" class="btn btn-outline-light">Update</button>
    </div>

    <c:if test="${not empty error}">
      <p class="text-danger mt-3">${error}</p>
    </c:if>
  </form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
