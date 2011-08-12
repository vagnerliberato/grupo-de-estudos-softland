package bean;

import java.util.Date;

public class DiarioBean {
    
    private int id = 0;
    private String observacao = null;
    private Date dataInicial = null;
    private Date dataFinal = null;
    private Date horaInicio = null;
    private Date horaFim = null;
    private TarefaBean tarefa = null;
    private UsuarioBean usuario = null;

    public DiarioBean() {
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
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
