package br.ufac.sgcm;

import java.sql.Connection;
import java.util.List;

import br.ufac.sgcm.dao.ConexaoDB;
import br.ufac.sgcm.dao.EspecialidadeDao;
import br.ufac.sgcm.model.Especialidade;
// import br.ufac.sgcm.model.Profissional;
// import br.ufac.sgcm.model.Unidade;

public class App {
    public static void main(String[] args) {
        // Profissional p1 = new Profissional();
        // p1.setId(1L);
        // p1.setNome("Limeira");
        // p1.setEmail("limeira@ufac.br");
        // p1.setTelefone("999999999");
        // p1.setRegistro("CRM-123");

        // Unidade u1 = new Unidade();
        // u1.setId(1L);
        // u1.setNome("Pronto Atendimento");
        // u1.setEndereco("Av. Rocha Viana");

        Especialidade e1 = new Especialidade();
        e1.setId(1L);
        e1.setNome("Uncologia Alterado");

        // p1.setUnidade(u1);
        // p1.setEspecialidade(e1);

        // System.out.println(p1.getNome());
        // System.out.println(p1.getUnidade().getNome());
        // System.out.println(p1.getEspecialidade().getNome());
        ConexaoDB conexao = new ConexaoDB();
        Connection instancia = conexao.getConexao();
        if (instancia != null) {
            System.out.println("Conectou");
        } else {
            System.out.println("Falhou");
        }

        System.out.println("\nLista de Especialidades");
        EspecialidadeDao eDao = new EspecialidadeDao();
        List<Especialidade> listaEspecialidade = eDao.get();
        for (Especialidade item : listaEspecialidade){
            System.out.println(item.getId() + "|" + item.getNome());
        }

        System.out.println("\nUma Especialidade");
        Especialidade esp = eDao.get(2L);
        System.out.println(esp.getId() + "|" + esp.getNome());
        
        System.out.println("\nLista com termo de busca");
        List<Especialidade> listaBusca = eDao.get("tria");
        for (Especialidade item : listaBusca){
            System.out.println(item.getId() + "|" + item.getNome());
        }
        System.out.println();

        // Inserindo uma especialidade
        // if (eDao.insert(e1) == 1){
        //     System.out.println("Especialidade inserida com sucesso!");
        // } else {
        //     System.out.println("Falha ao inseriar a Especialidade");
        // }
        
        System.out.println("Lista de Especialidades");
        listaEspecialidade = eDao.get();
        for (Especialidade item : listaEspecialidade){
            System.out.println(item.getId() + "|" + item.getNome());
        }
        
        // Atualizando uma especialidade
        // eDao.update(e1);
        // if (eDao.update(e1) == 1){
        //     System.out.println("Especialidade Alterada: " + eDao.get(10L).getNome());
        // } else {
        //     System.out.println("Falha ao atualizar a Especialidade");
        // }
        // System.out.println("Especialidade Alterada: " + eDao.get(10L).getNome());

        
        eDao.delete(e1);
        System.out.println("Lista de Especialidades");
        listaEspecialidade = eDao.get();
        for (Especialidade item : listaEspecialidade){
            System.out.println(item.getId() + "|" + item.getNome());
        }

    }
}
