package baseConhecimento.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.model.SelectItem;

public class ConhecimentoBean {

    private int id_conhecimento;
    private int visual;
    private AnalistaBean analista;
    private List<SelectItem> listaAnalistas;
    private List<TagBean> tags;
    private String referencia;
    private String fato;
    private String esclarecimento;
    private String campo;
    private String arquivo;
    private Date data;

    public ConhecimentoBean() {
        this.listaAnalistas = new ArrayList<SelectItem>();
        this.id_conhecimento = 0;
        this.visual = 0;
        this.analista = new AnalistaBean();
        this.tags = new ArrayList<TagBean>();
        this.referencia = null;
        this.fato = null;
        this.esclarecimento = null;
        this.campo = null;
        this.arquivo = null;
        this.data = new Date();
    }

    public AnalistaBean getAnalista() {
        return analista;
    }

    public void setAnalista(AnalistaBean analista) {
        this.analista = analista;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getEsclarecimento() {
        return esclarecimento;
    }

    public void setEsclarecimento(String esclarecimento) {
        this.esclarecimento = esclarecimento;
    }

    public String getFato() {
        return fato;
    }

    public void setFato(String fato) {
        this.fato = fato;
    }

    public int getId_conhecimento() {
        return id_conhecimento;
    }

    public void setId_conhecimento(int id_conhecimento) {
        this.id_conhecimento = id_conhecimento;
    }

    public List<SelectItem> getListaAnalistas() {
        return this.listaAnalistas;
    }

    public void setListaAnalistas(List<SelectItem> listaAnalistas) {
        this.listaAnalistas = listaAnalistas;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public List<TagBean> getTags() {
        return tags;
    }

    public void setTags(List<TagBean> tags) {
        this.tags = tags;
    }

    public int getVisual() {
        return visual;
    }

    public void setVisual(int visual) {
        this.visual = visual;
    }
}