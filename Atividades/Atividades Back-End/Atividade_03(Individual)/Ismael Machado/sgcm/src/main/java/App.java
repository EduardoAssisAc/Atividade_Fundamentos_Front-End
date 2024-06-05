


import java.sql.Connection;
import java.util.List;

import br.ufac.sgcm.dao.ConexaoDB;
import br.ufac.sgcm.dao.EspecialidadeDao;
import br.ufac.sgcm.model.Especialidade;
import br.ufac.sgcm.model.Profissional;
import br.ufac.sgcm.model.Unidade;

public class App {
    public static void main(String[] args) {
        Profissional p1 = new Profissional();
        p1.setId(13L);
        p1.setNome("Maelzinho da Web");
        p1.setEmail("ismael.silva@sou.ufac.br");
        p1.setTelefone("68999223344");
        p1.setRegistro("CRM-777");

        Unidade u1 = new Unidade();
        u1.setId(1L);
        u1.setNome("Pronto atendimento");
        u1.setEndereco("Av. Rocha Viana");

        Especialidade e1 = new Especialidade();
        e1.setId(1L);
        e1.setNome("Otorrinolaringologia");

        p1.setEspecialidade(e1);
        p1.setUnidade(u1);

        System.out.println(p1.getNome());
        System.out.println(p1.getEmail());
        System.out.println(p1.getUnidade().getNome());
        System.out.println(p1.getEspecialidade().getNome());

        ConexaoDB conexao = new ConexaoDB();  
        Connection instancia = conexao.getConexao();     
        
        if(instancia != null) {
            System.out.println("Deu certo! :)");
        } else {
            System.out.println("Deu ruim! :(");
        }

        EspecialidadeDao eDao = new EspecialidadeDao();
        List<Especialidade> listaespecialidade = eDao.get();
        System.out.println("Lista de especialidades:");
        for (Especialidade item : listaespecialidade) {
            System.out.println("ID: " + item.getId() + " | Nome: " + item.getNome());
        }
        System.out.println("Especialidade:");
        Especialidade esp = eDao.getById(1L);
        System.out.println("ID: " + esp.getId() + " | Nome: " + esp.getNome());
        
        
        List<Especialidade> listaBusca = eDao.getBySearch("geriatria");
        System.out.println("Lista com termo de busca:");
        for (Especialidade item : listaBusca) {
            System.out.println("ID: " + item.getId() + " | Nome: " + item.getNome());
        }

        // int verifica = eDao.insert(e1);
        // if(verifica == 1) {
        //     System.out.println("Especialidade inserida com sucesso!");
        // }

        // Especialidade e2 = new Especialidade();
        // e2.setId(8L);
        // e2.setNome("Onto alterado");

        // eDao.update(e2);
        // System.out.println("Especialidade alterada:");
        // Especialidade esp2 = eDao.getById(8L);
        // System.out.println("ID: " + esp2.getId() + " | Nome: " + esp2.getNome());

        int exclui = eDao.delete(e1);
        if(exclui == 1) {
            System.out.println("Excluído com sucesso!");
        }


    }
}
