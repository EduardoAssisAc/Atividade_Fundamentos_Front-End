<%@ page pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Objects" %>
<%@ page import="br.ufac.sgcm.model.Usuario" %>

<jsp:useBean id="controller" class="br.ufac.sgcm.controller.UsuarioController"/>

<%
    List<Usuario> registro = controller.processListRequest(request);
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Página de Cadastro</title>
    <link rel="stylesheet" type="text/css" href="./css/register_login.css">
</head>
<body>
    <div class="container">
        <div class="register-container">
            <h2>Cadastro</h2>
            <form action="register" method="post">
                <div class="form-group">
                    <label for="id">ID:</label>
                    <input type="hidden" id="id" name="id" value="<%=Objects.toString(registro.getId())%>">
                </div>
                <div class="form-group">
                    <label for="nome">Nome:</label>
                    <input type="text" id="nome" name="nome" value="<%=Objects.toString(registro.getNome())%>" required>
                </div>
                <div class="form-group">
                    <label for="username">Usuário:</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="form-group">
                    <label for="password">Senha:</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div class="form-group">
                    <input type="submit" name="submit" value="Salvar">
                    <input type="button" value="Cancelar" data-url="index.jsp" onclick="window.location.href='index.jsp'">
                </div>
            </form>
        </div>
    </div>
</body>
</html>
