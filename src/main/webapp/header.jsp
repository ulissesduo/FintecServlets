<nav class="navbar navbar-dark navbar-expand-lg bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="index.jsp">FIAPStore</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="produtos?acao=abrir-form-cadastro">Cadastro</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="produtos?acao=listar">Produtos</a>
                </li>
            </ul>
            <c:if test="${empty user}">
                <span class="navbar-text text-danger me-2">${erro}</span>
                <form class="d-flex form-dark" action="login" method="post">
                    <input class="form-control me-2" type="text" name="email" placeholder="E-mail">
                    <input class="form-control me-2" type="password" name="senha" placeholder="Senha">
                    <button class="btn btn-outline-success" type="submit">Entrar</button>
                </form>
            </c:if>
            <c:if test="${not empty user}">
                <span class="navbar-text me-2">${user}</span>
                <a href="login" class="btn btn-outline-primary">Sair</a>
            </c:if>
        </div>
    </div>
</nav>
