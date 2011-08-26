package diarioBordo.bean;

import java.util.Date;

public class DiarioBean {

    private int id;
    private String observacao;
    private Date dataInicio;
    private Date dataFim;
    private Date horaInicio;
    private Date horaFim;
    private TarefaBean tarefa;
    private UsuarioBean usuario;

    public DiarioBean() {
        this.id = 0;
        this.observacao = null;
        this.dataInicio = null;
        this.dataFim = null;
        this.horaInicio = null;
        this.horaFim = null;
        this.tarefa = null;
        this.usuario = null;
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

    public TarefaBean getTarefa() {
        return tarefa;
    }

    public void setTarefa(TarefaBean tarefa) {
        this.tarefa = tarefa;
    }

    public UsuarioBean getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBean usuario) {
        this.usuario = usuario;
    }
}