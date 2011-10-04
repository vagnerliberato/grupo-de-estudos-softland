package baseConhecimento.dao;

import globalproject.interfaces.InterfaceData;

public class ConhecimentoDAO implements InterfaceData {

    private static ConhecimentoDAO conhecimentoDao;

    public ConhecimentoDAO() {
    }

    public static ConhecimentoDAO getSingleton() {
        if (ConhecimentoDAO.conhecimentoDao == null) {
            ConhecimentoDAO.conhecimentoDao = new ConhecimentoDAO();
        }

        return ConhecimentoDAO.conhecimentoDao;
    }

    @Override
    public String insert() {
        return "insert into conhecimento (id_conhecimento, analista, referencia, fato, esclarecimento, visual, campo, data, arquivo) "
                + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String delete() {
        return "delete from conhecimento "
                + "where (id_conhecimento = ?)";
    }

    @Override
    public String update() {
        return "update conhecimento "
                + "set analista = ?, "
                + "referencia = ?, "
                + "fato = ?, "
                + "esclarecimento = ?, "
                + "visual = ?, "
                + "campo = ?, "
                + "data = ?, "
                + "arquivo = ? "
                + "where (id_conhecimento = ?)";
    }
}
