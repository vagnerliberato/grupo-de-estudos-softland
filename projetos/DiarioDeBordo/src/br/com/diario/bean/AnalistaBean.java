package br.com.diario.bean;

public class AnalistaBean {

    private String id;
    private String nome;
    private String senha;

    public AnalistaBean() {
        this.id = null;
        this.nome = null;
        this.senha = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
