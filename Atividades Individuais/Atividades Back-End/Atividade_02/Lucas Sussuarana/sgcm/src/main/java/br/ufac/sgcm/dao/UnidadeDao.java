package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Unidade;

public class UnidadeDao {
    Connection conexao;
    PreparedStatement ps;
    ResultSet rs;
    
    public UnidadeDao() {
        conexao = new ConexaoDB().getConexao();
    }
    
    // TRAZ TODOS OS DADOS DA UNIDADE
    public List<Unidade> get() {
        List<Unidade> registros = new ArrayList<>();
        String sql = "SELECT * FROM unidade";
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Unidade registro = new Unidade();
                registro.setId(rs.getLong("id"));
                registro.setEndereco(rs.getString("endereco"));
                registro.setNome(rs.getString("nome"));
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    // TRAZ UM RETORNO DE ACORDO COM O ID
    public Unidade get(Long id) {
        Unidade registro = new Unidade();
        String sql = "SELECT * FROM unidade WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()) {
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEndereco(rs.getString("endereco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;
    }

    // TRAZ CONFORME UMA DETERMINADA BUSCA
    public List<Unidade> get(String termoDeBusca) {
        List<Unidade> registros = new ArrayList<>();
        String sql = "SELECT * FROM unidade WHERE nome LIKE ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%" + termoDeBusca + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Unidade registro = new Unidade();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEndereco(rs.getString("enderco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    // INSERE UMA NOVA UNIDADE
    public int insert(Unidade objeto) {
        int registrosAfetados = 0;
        String sql = "INSERT INTO unidade (endereco, nome) VALUES (?, ?)";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getEndereco());
            ps.setString(2, objeto.getNome());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    // ATUALIZA OS DADOS DE UMA UNIDADE
    public int update(Unidade objeto) {
        String sql = "UPDATE unidade SET endereco = ?, nome = ? WHERE id = ?";
        int registrosAfetados = 0;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getEndereco());
            ps.setString(2, objeto.getNome());
            ps.setLong(3, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    // APAGA UMA UNIDADE
    public int delete(Unidade obejeto) {
        String sql = "DELETE FROM unidade WHERE id = ?";
        int registrosAfetados = 0;
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, obejeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }
}