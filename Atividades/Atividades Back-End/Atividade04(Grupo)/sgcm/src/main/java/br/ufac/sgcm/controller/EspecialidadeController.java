package br.ufac.sgcm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.dao.EspecialidadeDao;
import br.ufac.sgcm.model.Especialidade;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EspecialidadeController implements IController<Especialidade> {

    private EspecialidadeDao eDao;

    public EspecialidadeController() {
        eDao = new EspecialidadeDao();
    }

    @Override
    public int delete(Especialidade objeto) {
        int registrosAfetados = eDao.delete(objeto);
        return registrosAfetados;
    }

    @Override
    public List<Especialidade> get() {
        List<Especialidade> registros = eDao.get();
        return registros;
    }

    @Override
    public Especialidade get(Long id) {
        Especialidade registro = eDao.get(id);
        return registro;
    }

    @Override
    public List<Especialidade> get(String termoBusca) {
        List<Especialidade> registros = eDao.get(termoBusca);
        return registros;
    }

    @Override
    public int save(Especialidade objeto) {
        int registrosAfetados = 0;
        if (objeto.getId() == null)
            registrosAfetados = eDao.insert(objeto);
        else
            registrosAfetados = eDao.update(objeto);
        return registrosAfetados;
    }

    // Métodos do Servlet
    public List<Especialidade> processListRequest(HttpServletRequest req) {
        List<Especialidade> registros = new ArrayList<>();
        String paramExcluir = req.getParameter("excluir");// Excluir
        if (paramExcluir != null && !paramExcluir.isEmpty()) {
            Especialidade esp = new Especialidade();
            Long id = Long.parseLong(paramExcluir);
            esp = this.get(id);
            this.delete(esp);
        }
        registros = this.get();
        return registros;
    }

    @Override
    public Especialidade processFormRequest(HttpServletRequest request, HttpServletResponse response) {
        Especialidade item = new Especialidade();
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
            response.sendRedirect("especialidades.jsp");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return item;
    }
}
