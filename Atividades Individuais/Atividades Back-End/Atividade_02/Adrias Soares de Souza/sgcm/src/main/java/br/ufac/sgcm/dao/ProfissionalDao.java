package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Profissional;
import br.ufac.sgcm.model.Unidade;

public class ProfissionalDao implements IDao<Profissional>{

    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;
    private EspecialidadeDao eDao;
    private UnidadeDao uDao;

    public ProfissionalDao(){
        conexao = ConexaoDB.getConexao();
    }

    @Override
    public List<Profissional> get() {
        List<Profissional> registros = new ArrayList<>();
        String sql = "SELECT (id, nome, email, registro_conselho, telefone, especialidade_id, unidade_id) FROM profissional, unidade, especialidade WHERE";
        String sql2 = "SELECT p.id, p.nome, p.registro_conselho, p.telefone, e.nome, u.nome FROM profissional AS p, especialidade AS e, unidade AS u JOIN e.id ON p.especialidade_id AND u.id ON p.unidade_id";

        try{
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Profissional registro = new Profissional();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEmail(rs.getString("email"));
                registro.setRegistro(rs.getString("registro_conselho"));
                registro.setTelefone(rs.getString("telefone"));
                eDao = new EspecialidadeDao();
                registro.setEspecialidade(eDao.get(rs.getLong("especialidade_id")));
                uDao = new UnidadeDao();
                Unidade u = uDao.get(rs.getLong("unidade_id"));
                registro.setUnidade(u);
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    @Override
    public Profissional get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List<Profissional> get(String termoBusca) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public int insert(Profissional objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public int update(Profissional objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(Profissional objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
