package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Profissional;

public class ProfissionalDao implements IDao<Profissional> {
    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;

    public ProfissionalDao(){
        this.conexao = ConexaoDB.getConexao();
    }

    @Override
    public List<Profissional> get() {
        List<Profissional> registros = new ArrayList<>();
        String sql = "SELECT * FROM profissional";
        // String sql2 = "SELECT p.id, p.nome, p.email, p.registro_conselho, p.telefone, e.nome, u.nome FROM profissional AS p,"+ 
        // "especialidade AS e, unidade AS u JOIN e.id ON p.especialidade_id AND JOIN u.id ON p.unidade_id";
        try{
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Profissional registro = new Profissional();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setRegistro(rs.getString("registro_conselho"));
                registro.setEmail(rs.getString("email"));
                registro.setTelefone(rs.getString("telefone"));
                
                EspecialidadeDao especialidadeDao = new EspecialidadeDao();
                registro.setEspecialidade(especialidadeDao.get(rs.getLong("especialidade_id")));

                UnidadeDao unidadeDao = new UnidadeDao();
                registro.setUnidade(unidadeDao.get(rs.getLong("unidade_id")));
                registros.add(registro);

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return registros;
    }
    // Retorna u objeto do tipo Especialidade
    @Override
    public Profissional get(Long id) {
        Profissional registro = new Profissional();
        String sql = "SELECT * FROM profissional WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setRegistro(rs.getString("registro_conselho"));
                registro.setEmail(rs.getString("email"));
                registro.setTelefone(rs.getString("telefone"));
                
                EspecialidadeDao especialidadeDao = new EspecialidadeDao();
                registro.setEspecialidade(especialidadeDao.get(rs.getLong("especialidade_id")));

                UnidadeDao unidadeDao = new UnidadeDao();
                registro.setUnidade(unidadeDao.get(rs.getLong("unidade_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;
    }

    @Override
    public List<Profissional> get(String termoBusca) {
        List<Profissional> registros = new ArrayList<>();
        String sql = "SELECT * FROM profissional WHERE nome LIKE ? OR email LIKE ? OR telefone LIKE ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1,"%" + termoBusca + "%");
            ps.setString(2,"%" + termoBusca + "%");
            ps.setString(3, "%" + termoBusca + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Profissional registro = new Profissional();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setRegistro(rs.getString("registro_conselho"));
                registro.setEmail(rs.getString("email"));
                registro.setTelefone(rs.getString("telefone"));
                
                EspecialidadeDao especialidadeDao = new EspecialidadeDao();
                registro.setEspecialidade(especialidadeDao.get(rs.getLong("especialidade_id")));

                UnidadeDao unidadeDao = new UnidadeDao();
                registro.setUnidade(unidadeDao.get(rs.getLong("unidade_id")));
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    @Override
    public int insert(Profissional objeto) {
        int registrosAfetados = 0;
        String sql = "INSERT INTO unidade (nome, email, registro, telefone, especialidade_id, unidade_id) VALUES (?,?,?,?,?,?)";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getEmail());
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
        String sql = "UPDATE profissional SET nome = ?, email = ?, registro = ?, telefone = ?, especialidade_id = ?, unidade_id WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getEmail());
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

    @Override
    public int delete(Profissional objeto) {
        int registrosAfetados = 0;
        String sql = "DELETE FROM Profissional WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }
}
