package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Profissional;
import br.ufac.sgcm.dao.UnidadeDao;

public class ProfissionalDao implements IDao<Profissional> {
    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;
    private EspecialidadeDao eDao;
    private UnidadeDao uDao;

    public ProfissionalDao(Connection conexao) {
        this.conexao = ConexaoDB.getConexao();
    }
    @Override
    public int delete(Profissional objeto) {
        return 0;
    }
    @Override
    public List<Profissional> get() {
        List<Profissional> registros = new ArrayList<Profissional>();
        String sql = "SELECT * FROM profissional";
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Profissional registro = new Profissional();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEmail(rs.getString("email"));
                registro.setRegistro(rs.getString("registro_conselho"));
                registro.setTelefone(rs.getString("telefone"));
                eDao = new EspecialidadeDao();
                registro.setEspecialidade(eDao.getById(rs.getLong("especialidade_id")));
                uDao = new UnidadeDao();
                registro.setUnidade(uDao.get(rs.getLong("unidade_id")));
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
        return null;
    }
    @Override
    public List<Profissional> get(String termoBusca) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public int insert(Profissional objeto) {
        int registrosAfetados = 0;
        String sql = "INSERT INTO profissional (email, nome, registro_conselho, telefone, especialidade_id, unidade_id) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getEmail());
            ps.setString(2, objeto.getNome());
            ps.setString(3, objeto.getRegistro());
            ps.setString(4, objeto.getTelefone());
            ps.setLong(5, objeto.getEspecialidade().getId());
            ps.setLong(6, objeto.getUnidade().getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }
    @Override
    public int update(Profissional objeto) {
        int registrosAfetados = 0;
        String sql = "UPDATE profissional SET email = ?, nome = ?, registro_conselho = ?, telefone = ?, especialidade_id = ?, unidade_id = ? WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getEmail());
            ps.setString(2, objeto.getNome());
            ps.setString(3, objeto.getRegistro());
            ps.setString(4, objeto.getTelefone());
            ps.setLong(5, objeto.getEspecialidade().getId());
            ps.setLong(6, objeto.getUnidade().getId());
            ps.setLong(7, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registrosAfetados;
    }    
}
