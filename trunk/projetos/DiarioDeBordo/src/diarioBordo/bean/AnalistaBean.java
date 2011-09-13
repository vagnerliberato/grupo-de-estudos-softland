package diarioBordo.bean;

public class AnalistaBean {

    private int id;
    private String nome;
    private String senha;

    public AnalistaBean() {
        this.id = 0;
        this.nome = null;
        this.senha = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
