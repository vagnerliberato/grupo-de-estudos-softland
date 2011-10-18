package br.com.diario.control;

import br.com.diario.bean.AnalistaBean;
import br.com.diario.main.DataLocal;
import br.com.diario.model.LoginDAO;
import java.sql.SQLException;

public class LoginControl extends DataLocal {

    private LoginDAO tarefaDao;

    public LoginControl() throws Exception {
        try {
            tarefaDao = new LoginDAO(conexaoSingleton());
        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public void buscaAnalista(AnalistaBean analista) throws Exception {
        try {
            tarefaDao.buscaAnalista(analista);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
