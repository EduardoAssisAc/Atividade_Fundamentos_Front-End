// import java.sql.Connection;
import java.util.List;

// import br.ufac.sgcm.dao.ConexaoDB;
import br.ufac.sgcm.dao.EspecialidadeDao;
import br.ufac.sgcm.dao.ProfissionalDao;
// import br.ufac.sgcm.dao.UnidadeDao;
import br.ufac.sgcm.model.Especialidade;
import br.ufac.sgcm.model.Profissional;
// import br.ufac.sgcm.model.Unidade;

   
public class App {
    public static void main(String[] args) {
        // Profissional p1 = new Profissional();
        // p1.setNome("Limeira");
        // p1.setEmail("limeira@ufac.br");
        // p1.setTelefone("123456789");
        // p1.setRegistro("CRM-123");
        
        // Unidade u1 = new Unidade();
        // u1.setId(1L);
        // u1.setNome("Pronto Atendimento");
        // u1.setEndereco("Av. Rocha Viana");

        // Especialidade e1 = new Especialidade();
        // e1.setId(10L);
        // e1.setNome("Oncologista Alterado3");

        // p1.setUnidade(u1);
        // p1.setEspecialidade(e1);

        // System.out.println(p1.getNome());
        // System.out.println(p1.getUnidade().getNome());
        // System.out.println(p1.getEspecialidade().getNome());

        // Connection instancia = ConexaoDB.getConexao();
        // if (instancia != null){
        //     System.out.println("Conectou");
        // } else{
        //     System.out.println("Falhou");
        // }


        //Fazendo a busca de todas as especialidades
        // EspecialidadeDao eDao = new EspecialidadeDao();
        // List<Especialidade>listaEspecialidade = eDao.get();
        // System.out.println("Lista de Especialidades:");
        // for (Especialidade item : listaEspecialidade) {
        //     System.out.println(item.getId() + "| " + item.getNome());
        // }


        //Fazendo a busca de uma especialidade através de um id
        // System.out.println("\nUma Especialidade Específica");
        // Especialidade esp = eDao.get(2L);
        // System.out.println(esp.getId() + "| " + esp.getNome());
        

        
        //Fazendo uma busca por um termo específico
        // List<Especialidade>listaBusca = eDao.get("tria");
        // System.out.println("\nLista com termo de busca: tria");
        // for (Especialidade item : listaBusca) {
        //     System.out.println(item.getId() + "|" + item.getNome());
        // }

        //Inserindo uma especialidades
        //  if (eDao.insert(e1) == 1) {
        //      System.out.println("\nEspecialidade Inserida com Sucesso!");
        //  }

        // listaEspecialidade = eDao.get();
        // for (Especialidade item : listaEspecialidade) {
        //     System.out.println(item.getId() + "| " + item.getNome());
        // }

        // //Atualizando uma Especialidade
        // eDao.update(e1);
        // System.out.println("Especialidade Alterada: " + eDao.get(10L).getNome());

        // listaEspecialidade = eDao.get();
        // for (Especialidade item : listaEspecialidade) {
        //     System.out.println(item.getId() + "| " + item.getNome());
        // }

        //Excluindo uma Especialidade
        //  eDao.delete(e1);
        //  System.out.println("Especialidade Alterada " + eDao.get(10L).getNome());
        //  listaEspecialidade = eDao.get();
        //  for (Especialidade item : listaEspecialidade) {
        //           System.out.println(item.getId() + "| " + item.getNome());
        //       }
        
        
        

         //Fazendo a busca de todas as unidades
        //  UnidadeDao eDao2 = new UnidadeDao();
        //  List<Unidade>listaUnidade = eDao2.get();
        //  System.out.println("Lista de Especialidades:");
        //  for (Unidade item : listaUnidade) {
        //      System.out.println(item.getId() + "| " + item.getNome());
        //  }

        ProfissionalDao profissional1 = new ProfissionalDao();
        List<Profissional> listaProfissional = profissional1.get();
        System.out.println("Lista com todos os Profissionais: ");
        for (Profissional item : listaProfissional) {
            System.out.println(item.getId() + "|" + item.getNome());
            
        }

        EspecialidadeDao especialidade1 = new EspecialidadeDao();
        List<Especialidade> listaEspecialidade = especialidade1.get();
        System.out.println("\nLista com todas as especialidades:");
        for (Especialidade item : listaEspecialidade) {
            System.out.println(item.getId() + "|" + item.getNome());
        }



        }
}

