// Data Acess Object

package main.java.br.ufac.sgcm.dao;

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

    // Construtor
    public UnidadeDao(){
        conexao = new ConexaoDB().getConexao();
    }
    
    // Retornar todas as Unidade
    public List<Unidade> get(){
        List<Unidade> registros = new ArrayList<>();
        String sql = "SELECT * FROM Unidade ORDER BY id";
        try{
            ps = conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Unidade registro = new Unidade();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registros.add(registro);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return registros;
    }

    // Retornar um objeto do tipo Especialiadae
    public Unidade get(Long id){
        Unidade registro = new Unidade();
        String sql = "SELECT * FROM Unidade WHERE id = ?";

        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, id);
            rs= ps.executeQuery();  
            if (rs.next()){
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registro;
    }

    // Retornar conforme um termo de busca
    public List<Unidade> get(String termoBusca){
        List<Unidade> registros = new ArrayList<>();
        String sql = "SELECT * FROM Unidade WHERE nome LIKE ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, "%"+termoBusca+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                Unidade registro = new Unidade();
                registro.setId(rs.getLong("id"));
                registro.setNome(rs.getString("nome"));
                registros.add(registro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registros;
    }
    
    // Inserir uma Unidade
    public int insert(Unidade objeto){
        int registrosAfetados = 0;
        String sql = "INSERT INTO Unidade (nome) VALUES (?)";
        try{
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            registrosAfetados = ps.executeUpdate();
        } catch(SQLException e){
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    // Atualizar uma Unidade
    public int update(Unidade objeto){
        int registrosAfetados = 0;
        String sql = "UPDATE Unidade SET nome = ? WHERE id = ?";
        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setLong(2, objeto.getId());
            registrosAfetados = ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return registrosAfetados;
    }

    // Excluir uma Unidade
    public int delete(Unidade objeto){
        int registrosAfetados = 0;
        String sql = "DELETE FROM Unidade WHERE id = ?";

        try {
            ps = conexao.prepareStatement(sql);
            ps.setLong(1, objeto.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return registrosAfetados;
    }

}
