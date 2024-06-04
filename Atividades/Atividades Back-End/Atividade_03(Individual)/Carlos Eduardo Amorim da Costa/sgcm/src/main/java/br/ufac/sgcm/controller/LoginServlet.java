import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Verificação simples (substitua isso por uma lógica de autenticação real)
        if("admin".equals(username) && "admin".equals(password)) {
            response.sendRedirect("success.jsp");
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
