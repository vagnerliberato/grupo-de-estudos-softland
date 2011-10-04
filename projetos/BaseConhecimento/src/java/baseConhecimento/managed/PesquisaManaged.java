package baseConhecimento.managed;

import baseConhecimento.bean.ConhecimentoBean;
import baseConhecimento.dao.ConhecimentoDAO;
import globalproject.generic.Funcoes;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "pesquisa")
@ViewScoped
public class PesquisaManaged {

    private List<ConhecimentoBean> listaConhecimentos;
    private ConhecimentoBean conhecimentoSelecionado;
    private String textoPesquisa;

    public PesquisaManaged() {
        this.listaConhecimentos = new ArrayList<ConhecimentoBean>();
        this.conhecimentoSelecionado = null;
        this.textoPesquisa = null;
    }

    public List<ConhecimentoBean> carregaPesquisa() {

        if (getTextoPesquisa().isEmpty()) {
            return null;
        }

        try {
            ConhecimentoDAO dao = new ConhecimentoDAO();

            //this.setListaConhecimentos(dao.BuscaConhecimento(this.getTextoPesquisa()));

            if (getListaConhecimentos().isEmpty()) {
                Funcoes.alertaMsg(FacesMessage.SEVERITY_INFO, "Que pena, não foi encontrado nenhum resultado para"
                        + "sua pesquisa. \n Reescreva seu titulo e tente novamente.");

                return null;
            } else {
                return this.getListaConhecimentos();
            }

        } catch (Exception error) {
            Funcoes.alertaMsg(FacesMessage.SEVERITY_INFO, error.getMessage());
            return null;
        }
    }

    public void updateConhecimento() {
        try {
            ConhecimentoDAO dao = new ConhecimentoDAO();
            //dao.updateConhecimento(this.getListaConhecimentos().get(0));
        } catch (Exception error) {
            Funcoes.alertaMsg(FacesMessage.SEVERITY_ERROR, error.getMessage());
        }
    }

    public List<ConhecimentoBean> getListaConhecimentos() {
        return listaConhecimentos;
    }

    public void setListaConhecimentos(List<ConhecimentoBean> listaConhecimentos) {
        this.listaConhecimentos = listaConhecimentos;
    }

    public ConhecimentoBean getConhecimentoSelecionado() {
        return conhecimentoSelecionado;
    }

    public void setConhecimentoSelecionado(ConhecimentoBean conhecimentoSelecionado) {
        this.conhecimentoSelecionado = conhecimentoSelecionado;
    }

    public String getTextoPesquisa() {
        return textoPesquisa;
    }

    public void setTextoPesquisa(String textoPesquisa) {
        this.textoPesquisa = textoPesquisa;
    }
}
