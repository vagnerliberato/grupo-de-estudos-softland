package br.com.diario.bean;

import br.com.diario.main.DataLocal;
import java.util.Date;

public class DiarioBean {

    private int id;
    private String observacao;
    private Date data;
    private String hora;
    private AnalistaBean analista;

    public DiarioBean() {
        this.id = 0;
        this.observacao = "";
        this.data = new Date();
        this.hora = "";
        this.analista = DataLocal.getAnalistaBean();
    }

    public AnalistaBean getAnalista() {
        return analista;
    }

    public void setAnalista(AnalistaBean analista) {
        this.analista = analista;
    }

    public Date getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
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
}
