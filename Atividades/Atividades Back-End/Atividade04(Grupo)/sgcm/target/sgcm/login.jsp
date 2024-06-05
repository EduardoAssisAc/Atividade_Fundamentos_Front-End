<%@ page pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, user-scalable=no">
        <title>SGCM - Login</title>
        <link rel="stylesheet" href="./css/estilo.css">
        <link rel="stylesheet" href="./css/estilo-tema-azul.css" id="link-tema">
        <script src="./js/script.js" defer></script>
    </head>
    <body>
        <header>
            <div id="logo">
                <img src="imagens/logo_branco.png" alt="Logo SGCM">
                <span id="titulo">SGCM</span>
            </div>
        </header>
        <main>
            <form action="LoginServlet" method="post">
                <div class="grid">
                    <label for="username">Usuário</label>
                    <input type="text" id="username" name="username" required>
                </div>
                <div class="grid">
                    <label for="password">Senha</label>
                    <input type="password" id="password" name="password" required>
                </div>
                <div>
                    <input type="submit" value="Login">
                </div>
                <div>
                    <label for="tema">Tema</label>
                    <select id="tema">
                        <option value="">Escolha um tema</option>
                        <option value="azul">Azul</option>
                        <option value="vermelho">Vermelho</option>
                        <option value="amarelo">Amarelo</option>
                    </select>
                </div>
            </form>
        </main>
        <footer>
            <span>SGCM - Sistema de Gerenciamento de Clínica Médica</span>
            <span>Telefone de contato: (68) 3333-3333 | <a href="mailto:suporte.sgcm@ufac.br">suporte.sgcm@ufac.br</a></span>
        </footer>
    </body>
</html>
