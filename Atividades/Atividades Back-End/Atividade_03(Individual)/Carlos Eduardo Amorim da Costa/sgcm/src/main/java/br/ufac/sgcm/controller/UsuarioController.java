package br.ufac.sgcm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.dao.UsuarioDao;
import br.ufac.sgcm.model.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UsuarioController implements IController<Usuario> {

    private UsuarioDao uDao;

    public UsuarioController() {
        uDao = new UsuarioDao();
    }

    @Override
    public int delete(Usuario objeto) {
        int registrosAfetados = uDao.delete(objeto);
        return registrosAfetados;
    }

    @Override
    public List<Usuario> get() {
        List<Usuario> registros = uDao.get();
        return registros;
    }

    @Override
    public Usuario get(Long id) {
        Usuario registro = uDao.get(id);
        return registro;
    }

    @Override
    public List<Usuario> get(String termoBusca) {
        List<Usuario> registros = uDao.get(termoBusca);
        return registros;
    }

    @Override
    public int save(Usuario objeto) {
        int registrosAfetados = 0;
        if (objeto.getId() == null)
            registrosAfetados = uDao.insert(objeto);
        else
            registrosAfetados = uDao.update(objeto);
        return registrosAfetados;
    }

    // Metodos do Servlet
    public List<Usuario> processListRequest(HttpServletRequest req) {
        List<Usuario> registros = new ArrayList<>();
        String paramExcluir = req.getParameter("excluir");// excluir
        if (paramExcluir != null && !paramExcluir.isEmpty()) {
            Usuario esp = new Usuario();
            Long id = Long.parseLong(paramExcluir);
            esp = this.get(id);
            this.delete(esp);
        }
        registros = this.get();
        return registros;
    }

    public Usuario processFormRequest(HttpServletRequest req, HttpServletResponse res){
        Usuario item = new Usuario();
        String submit = req.getParameter("submit");
        String paramId = req.getParameter("id");
        if (paramId != null && !paramId.isEmpty()) {
            Long id = Long.parseLong(paramId);
            item.setId(id);
        }
        // if (submit != null) {
        //     item.setNome(req.getParameter("nome"));
        //     this.save(item);
        // }
        try{
            res.sendRedirect("usuario.jsp");
        }catch(IOException e){
            e.printStackTrace();
        }
        return item;
    }
}
