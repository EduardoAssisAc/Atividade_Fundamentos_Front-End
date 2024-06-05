package br.ufac.sgcm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ufac.sgcm.model.Usuario;

public class UsuarioDao implements IDao<Usuario> {
    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;

    public UsuarioDao() {
        this.conexao = ConexaoDB.getConexao();
    }

    @Override
    public int delete(Usuario objeto) {
        int registrosAfetados = 0;
        String sql = "DELETE FROM usuario WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    @Override
    public List<Usuario> get() {
        List<Usuario> registros = new ArrayList<>();
        String sql = "SELECT * FROM usuario";
        try {
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario registro = new Usuario();
                registro.setId(rs.getLong("id"));
                registro.setNomeCompleto("nome_completo");
                registro.setNomeUsuario("nome_usuario");
                registro.setAtivo(Boolean.parseBoolean("ativo"));
                registro.setPapel("papel");
                registro.setSenha("senha");
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    @Override
    public Usuario get(Long id) {
        Usuario registro = new Usuario();
        String sql = "SELECT * FROM usuario WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                registro.setId(rs.getLong("id"));
                registro.setNomeCompleto("nome_completo");
                registro.setNomeUsuario("nome_usuario");
                registro.setAtivo(Boolean.parseBoolean("ativo"));
                registro.setPapel("papel");
                registro.setSenha("senha");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;
    }

    @Override
    public List<Usuario> get(String termoBusca) {
        List<Usuario> registros = new ArrayList<>();
        String sql = "SELECT * FROM usuario WHERE nome_completo LIKE ? OR nome_usuario LIKE ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%" + termoBusca + "%");
            ps.setString(2, "%" + termoBusca + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuario registro = new Usuario();
                registro.setId(rs.getLong("id"));
                registro.setNomeCompleto("nome_completo");
                registro.setNomeUsuario("nome_usuario");
                registro.setAtivo(Boolean.parseBoolean("ativo"));
                registro.setPapel("papel");
                registro.setSenha("senha");
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }

    @Override
    public int insert(Usuario objeto) {
        int registrosAfetados = 0;
        String sql = "INSERT INTO usuario (nome_completo,nome_usuario,ativo,papel,senha) VALUES (?,?,?,?,?)";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNomeCompleto());
            ps.setString(2, objeto.getNomeUsuario());
            ps.setBoolean(3, objeto.isAtivo());
            ps.setString(4, objeto.getPapel());
            ps.setString(5, objeto.getSenha());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    @Override
    public int update(Usuario objeto) {
        int registrosAfetados = 0;
        String sql = "UPDATE usuario SET nome_completo = ?, nome_usuario = ?, ativo = ?, papel = ?, senha = ? " +
                "WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNomeCompleto());
            ps.setString(2, objeto.getNomeUsuario());
            ps.setBoolean(3, objeto.isAtivo());
            ps.setString(4, objeto.getPapel());
            ps.setString(5, objeto.getSenha());
            ps.setLong(6, objeto.getId());
            registrosAfetados = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    public boolean validate(String nomeUsuario, String senha) {
        boolean status = false;
        String sql = "SELECT * FROM usuario WHERE nome_usuario = ? AND senha = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, nomeUsuario);
            ps.setString(2, senha);
            rs = ps.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;

    }
}
