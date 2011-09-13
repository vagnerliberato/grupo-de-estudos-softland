package diarioBordo.model;

import diarioBordo.bean.DiarioBean;
import globalproject.interfaces.InterfaceData;

public class DiarioDAO implements InterfaceData {

    private DiarioBean diarioBean;

    public DiarioDAO() {
        this.diarioBean = new DiarioBean();
    }

    public DiarioBean getDiarioBean() {
        return diarioBean;
    }

    public void setDiarioBean(DiarioBean diarioBean) {
        this.diarioBean = diarioBean;
    }
    
    @Override
    public String insert() {
        return "insert into diario (id_diario, observacao, datainicio, datafim, horainicio, horafim, id_analista) "
                + "values (?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String delete() {
        return "delete from diario "
                + "where (id_diario = ?)";
    }

    @Override
    public String update() {
        return "update diario set "
                + "observacao = ?, "
                + "datainicio = ?, "
                + "datafim = ?, "
                + "horainicio = ?, "
                + "horafim = ?, "
                + "id_analista = ? "
                + "where (id_diario = ?)";
    }
    
    public String diaAberto() {
        return "select * from diario d where d.datainicio = :data";
    }
}
