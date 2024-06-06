package main.java.br.ufac.sgcm.controller;

public class LoginServlet extends HttpServlet{
    
    
    private static final long serialVersionUID = 1L;
    private UsuarioDao usuarioDao;

    @Override
    public void init() {
        usuarioDao = new UsuarioDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (usuarioDao.validate(username, password)) {
            request.getSession().setAttribute("user", username);
            response.sendRedirect("index.jsp");
        } else {
            response.sendRedirect("login.jsp?error=true");
        }
    }
}
