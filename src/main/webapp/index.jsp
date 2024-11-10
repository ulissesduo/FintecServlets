<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Form</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
    <style>
        body {
            background-color: #121212; /* Dark background */
            color: #e0e0e0; /* Light text */
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0;
        }

        .form-container {
            background-color: #333; /* Dark form background */
            padding: 30px;
            border-radius: 8px;
            width: 100%;
            max-width: 400px;
        }

        .form-dark .form-control {
            background-color: #444;
            border: 1px solid #555;
            color: #e0e0e0;
        }

        .form-dark .form-control::placeholder {
            color: #bbb;
        }

        .form-dark .btn-outline-light {
            color: #fff;
            border-color: #fff;
        }

        .form-dark .btn-outline-light:hover {
            background-color: #fff;
            color: #121212;
        }
    </style>
</head>
<body>

<div class="form-container">
    <form class="form-dark" action="login" method="post">
        <h2 class="text-center text-light mb-4">Login</h2>

        <div class="mb-3">
            <label for="email" class="form-label text-light">E-mail</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Insira seu E-mail" required>
        </div>

        <div class="mb-3">
            <label for="password" class="form-label text-light">Password</label>
            <input type="password" class="form-control" id="password" name="senha" placeholder="Insira sua senha" required>
        </div>


        <div class="d-grid">
            <button type="submit" class="btn btn-outline-light">Login</button>
        </div>
        <div>
            <a href="Register.jsp">Cadastre-se aqui</a>
        </div>
    </form>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
