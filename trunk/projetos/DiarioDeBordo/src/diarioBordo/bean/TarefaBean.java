package diarioBordo.bean;

import java.util.Date;

public class TarefaBean {

    private int id;
    private String descricao;
    private String observacao;
    private String status;
    private Date horaInicio;
    private Date horaFim;
    private String ficha;

    public TarefaBean() {
        this.id = 0;
        this.descricao = null;
        this.observacao = null;
        this.status = null;
        this.horaInicio = new Date();
        this.horaFim = new Date();
        this.ficha = null;
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

    public Date getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Date horaFim) {
        this.horaFim = horaFim;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}