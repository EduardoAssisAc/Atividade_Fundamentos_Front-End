package br.ufac.sgcm.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ufac.sgcm.model.Usuario;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class UsuarioServlet extends HttpServlet {
    public void service(ServletRequest req, ServletResponse res) throws IOException {
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        String paramBusca = req.getParameter("busca");
        UsuarioController controller = new UsuarioController();
        List<Usuario> usuarios = controller.get(paramBusca);
        ObjectMapper mapper = new ObjectMapper();
        try {
            PrintWriter saida = res.getWriter();
            String json = mapper.writeValueAsString(usuarios);
            saida.println(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}