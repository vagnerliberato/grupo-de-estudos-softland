package diarioBordo.bean;

public class TarefaBean {

    private int id;
    private String descricao;
    private String observacao;
    private String ficha;
    private String status;

    public TarefaBean() {
        this.id = 0;
        this.descricao = null;
        this.observacao = null;
        this.ficha = null;
        this.status = null;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFicha() {
        return ficha;
    }

    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}