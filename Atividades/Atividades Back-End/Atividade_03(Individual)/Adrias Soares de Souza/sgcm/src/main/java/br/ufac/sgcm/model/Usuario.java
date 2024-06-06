package main.java.br.ufac.sgcm.model;

public class Usuario implements Serializable {
    private long id;
    // private boolean ativo;
    private String nome_usuario;
    private String senha;

    public Usuario() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nome_usuario;
    }

    public void setNomeUsuario(String usuario) {
        this.nome_usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
