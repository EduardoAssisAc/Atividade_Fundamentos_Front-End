package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Unidade;

public class UnidadeDaoAtiv {
    Connection conexao;
    PreparedStatement ps;
    ResultSet rs;

    public UnidadeDaoAtiv() {
        conexao = ConexaoDB.getConexao();
    }

    public List<Unidade> get() {
        List<Unidade> registros = new ArrayList<Unidade>();
        String sql = "SELECT * FROM unidade";
        try{
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Unidade registro = new Unidade();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEndereco(rs.getString("endereco"));
                registros.add(registro);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public Unidade getById(Long id) {
        Unidade registro = new Unidade();
        String sql = "SELECT * FROM unidade WHERE id = ?";
        try{
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEndereco(rs.getString("endereco"));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return registro;
    }

    public List<Unidade> getBySearch(String termoBusca) {
        List<Unidade> registros = new ArrayList<Unidade>();
        String sql = "SELECT * FROM unidade WHERE nome LIKE ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%" + termoBusca  + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Unidade registro = new Unidade();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registro.setEndereco(rs.getString("endereco"));
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registros;
    }

    public int insert(Unidade uni) {
        int registrosAfetados = 0;
        String sql = "INSERT INTO unidade (endereco, nome) VALUES (?, ?)";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, uni.getEndereco());
            ps.setString(2, uni.getNome());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registrosAfetados;
    }

    public int update(Unidade uni) {
        int registrosAfetados = 0;
        String sql = "UPDATE unidade SET nome = ?, endereco = ? WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, uni.getNome());
            ps.setString(2, uni.getEndereco());
            ps.setLong(3, uni.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registrosAfetados;
    }

    public int delete(Unidade uni) {
        int registrosAfetados = 0;
        String sql = "DELETE FROM unidade WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, uni.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registrosAfetados;
    }
}
