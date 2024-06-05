package br.ufac.sgcm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.dao.ProfissionalDao;
import br.ufac.sgcm.model.Profissional;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProfissionalController implements IController<Profissional> {
    private ProfissionalDao pDao;

    public ProfissionalController() {
        pDao = new ProfissionalDao();
    }

    @Override
    public int delete(Profissional objeto) {
        int registrosAfetados = pDao.delete(objeto);
        return registrosAfetados;
    }

    @Override
    public List<Profissional> get() {
        List<Profissional> registros = pDao.get();
        return registros;
    }

    @Override
    public Profissional get(Long id) {
        Profissional registro = pDao.get(id);
        return registro;
    }

    @Override
    public List<Profissional> get(String termoBusca) {
        List<Profissional> registros = pDao.get(termoBusca);
        return registros;
    }

    @Override
    public int save(Profissional objeto) {
        int registrosAfetados = 0;
        if (objeto.getId() == null)
            registrosAfetados = pDao.insert(objeto);
        else
            registrosAfetados = pDao.update(objeto);
        return registrosAfetados;
    }

    // Métodos do Servlet
    public List<Profissional> processListRequest(HttpServletRequest req) {
        List<Profissional> registros = new ArrayList<>();
        String paramExcluir = req.getParameter("excluir");// Excluir
        if (paramExcluir != null && !paramExcluir.isEmpty()) {
            Profissional esp = new Profissional();
            Long id = Long.parseLong(paramExcluir);
            esp = this.get(id);
            this.delete(esp);
        }
        registros = this.get();
        return registros;
    }

    @Override
    public Profissional processFormRequest(HttpServletRequest request, HttpServletResponse response) {
        Profissional item = new Profissional();
        String submit = request.getParameter("submit");
        String paramId = request.getParameter("id");
        if (paramId != null && !paramId.isEmpty()) {
            Long id = Long.parseLong(paramId);
            item.setId(id);
        }
        if (submit != null) {
            item.setNome(request.getParameter("nome"));
            this.save(item);
        }
        try {
            response.sendRedirect("profissional.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return item;
    } 
}
