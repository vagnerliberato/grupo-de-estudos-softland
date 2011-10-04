package diarioBordo.bean;

public class TarefaBean {

    private int id;
    private String descricao;
    private String observacao;
    private Integer status;
    private String horaInicio;
    private String horaFim;
    private Integer ficha;

    public TarefaBean() {
        this.id = 0;
        this.descricao = "";
        this.observacao = "";
        this.status = 0;
        this.horaInicio = "";
        this.horaFim = "";
        this.ficha = 0;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getFicha() {
        return ficha;
    }

    public void setFicha(Integer ficha) {
        this.ficha = ficha;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}