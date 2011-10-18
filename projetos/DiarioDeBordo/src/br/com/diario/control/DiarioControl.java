package br.com.diario.control;

import br.com.diario.bean.DiarioBean;
import br.com.diario.main.DataLocal;
import br.com.diario.model.DiarioDAO;
import java.sql.SQLException;
import java.util.Date;

public class DiarioControl extends DataLocal {

    private DiarioDAO diarioDao;

    public DiarioControl() throws Exception {
        try {
            diarioDao = new DiarioDAO(conexaoSingleton());
        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public void getDiarioAtual(DiarioBean diario) throws Exception {
        try {
            if (diarioDao.isDiaAberto(new Date())) {
                diarioDao.getDiarioAtual(diario);
            } else {
                throw new Exception("Abra um diário antes de continuar!");
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
