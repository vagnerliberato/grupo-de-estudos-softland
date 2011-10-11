package br.com.diario.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DiarioBean {

    private int id;
    private String observacao;
    private Date dataInicio;
    private Date dataFim;
    private String horaInicio;
    private String horaFim;
    private List<TarefaBean> listaTarefas;
    private AnalistaBean analista;

    public DiarioBean() {
        this.id = 0;
        this.observacao = null;
        this.dataInicio = new Date();
        this.dataFim = null;
        this.horaInicio = null;
        this.horaFim = null;
        this.listaTarefas = new ArrayList<TarefaBean>();
        this.analista = new AnalistaBean();
    }

    public AnalistaBean getAnalista() {
        return analista;
    }

    public void setAnalista(AnalistaBean analista) {
        this.analista = analista;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
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

    public List<TarefaBean> getListaTarefas() {
        return listaTarefas;
    }

    public void setListaTarefas(List<TarefaBean> listaTarefas) {
        this.listaTarefas = listaTarefas;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
