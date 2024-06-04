<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="br.ufac.sgcm.model.Usuario" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página de Login</title>
    <link rel="stylesheet" type="text/css" href="./css/register_login.css">
</head>
<body>
    <div class="container">
        <div class="login-container">
            <h2>Login</h2>
            <form action="login" method="post">
                <div class="form-group">
                    <label for="username">Usuário:</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="password">Senha:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div class="form-group">
                    <input type="submit" name="submit" value="Entrar">
                    <input type="button" value="Cancelar" data-url="index.jsp" onclick="window.location.href='index.jsp'">
                </div>
            </form>
            <p>Não tem uma conta? <a href="register.jsp">Cadastre-se</a></p>
        </div>
    </div>
</body>
</html>
