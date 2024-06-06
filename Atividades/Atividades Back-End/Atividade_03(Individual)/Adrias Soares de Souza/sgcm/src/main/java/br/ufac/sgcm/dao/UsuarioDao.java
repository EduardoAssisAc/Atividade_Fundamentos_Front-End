package main.java.br.ufac.sgcm.dao;

public class UsuarioDao implements IDao<Usuario> {
    private Connection conexao;
    private PreparedStatement ps;
    private ResultSet rs;

    public UsuarioDao() {
        conexao = ConexaoDB.getConexao();
    }

    @Override
    public List<Usuario> get() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
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
                registro.setNomeUsuario(rs.getString("nome_usuario"));
                registro.setSenha(rs.getString("senha"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;
    }

    @Override
    public List<Usuario> get(String termoBusca) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public int insert(Usuario objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public int update(Usuario objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public int delete(Usuario objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
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

