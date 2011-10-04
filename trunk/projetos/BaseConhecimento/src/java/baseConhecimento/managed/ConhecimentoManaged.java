package baseConhecimento.managed;

import baseConhecimento.bean.ConhecimentoBean;
import baseConhecimento.dao.ConhecimentoDAO;
import globalproject.conect.Firebird;
import globalproject.generic.Funcoes;
import globalproject.persist.PersistData;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean(name = "conhecimento")
@ViewScoped
public class ConhecimentoManaged {

    private ConhecimentoBean conhecimentoBean;

    public ConhecimentoManaged() {
        this.conhecimentoBean = new ConhecimentoBean();
        this.carregaAnalistas(this.conhecimentoBean.getListaAnalistas());
    }

    public ConhecimentoBean getConhecimentoBean() {
        return conhecimentoBean;
    }

    public void setConhecimentoBean(ConhecimentoBean conhecimento) {
        this.conhecimentoBean = conhecimento;
    }

    public void addConhecimento() {
        try {
            PersistData persist = new PersistData(Firebird.getConexao());
            ConhecimentoDAO dao = new ConhecimentoDAO();

            this.conhecimentoBean.setId_conhecimento(Funcoes.ultimoId(Firebird.getConexao(), "CONHECIMENTO", "ID_CONHECIMENTO"));
            this.conhecimentoBean.setData(new java.sql.Date(new Date().getTime()));

            persist.executeCommand(
                    dao.insert(),
                    this.conhecimentoBean.getId_conhecimento(),
                    this.conhecimentoBean.getAnalista().getCodigo(),
                    this.conhecimentoBean.getReferencia(),
                    this.conhecimentoBean.getFato(),
                    this.conhecimentoBean.getEsclarecimento(),
                    this.conhecimentoBean.getVisual(),
                    Funcoes.gerarCampo(this.conhecimentoBean.getAnalista().getCodigo()),
                    this.conhecimentoBean.getData(),
                    this.conhecimentoBean.getArquivo());

            persist.finalData();

            Funcoes.alertaMsg(FacesMessage.SEVERITY_INFO, "Legal, seu conhecimento foi Gravado com sucesso!");

        } catch (Exception e) {

            Funcoes.alertaMsg(FacesMessage.SEVERITY_ERROR, "Mas que coisa, ocorreu um erro na gravação: " + e.getMessage());
        }
    }

    private void carregaAnalistas(List<SelectItem> lista) {
        try {
            PersistData persist = new PersistData(Firebird.getConexao());

            ResultSet result = persist.executeQuery("select codigo, descricao from analista order by descricao");

            if (result.next()) {

                lista.clear();

                while (result.next()) {
                    SelectItem item = new SelectItem(result.getString("codigo"), result.getString("descricao"));
                    lista.add(item);
                }

                result.close();

            } else {

                result.close();

                Funcoes.alertaMsg(FacesMessage.SEVERITY_WARN,
                        "Não foi encontrado nenhum Analista, isso esta certo? \n "
                        + "Verifique o cadastro de analistas!");
            }
        } catch (Exception e) {
            Funcoes.alertaMsg(FacesMessage.SEVERITY_ERROR,
                    "Problemas amigo! Os analista não foram carregados, veja a descrição do erro: \n "
                    + e.getMessage());
        }
    }
}