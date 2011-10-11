package br.com.diario.control;

import br.com.diario.bean.TarefaBean;
import br.com.diario.main.DataLocal;
import br.com.diario.model.DiarioDAO;
import br.com.diario.model.TarefaDAO;
import globalproject.generic.Funcoes;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TarefaControl extends DataLocal {

    private TarefaDAO tarefaDao;

    public TarefaControl() throws Exception {
        try {
            tarefaDao = new TarefaDAO(conexaoSingleton());
        } catch (ClassNotFoundException ex) {
            throw new Exception(ex.getMessage());
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public ResultSet carregaDados() throws Exception {
        try {
            ResultSet rs = tarefaDao.carregaTarefas();
            return rs;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public TarefaBean cadastraTarefa(TarefaBean tarefa) throws Exception {
        try {
            tarefaDao.multiTransacao(true);

            int idTarefa = tarefaDao.cadastraTarefa(tarefa);

            DiarioDAO diarioDao = new DiarioDAO(conexaoSingleton());

            tarefaDao.cadastraControle(idTarefa, diarioDao.getIdDiarioAtual(Funcoes.getDataAtual()));

            tarefaDao.commit();

            tarefa.setId(idTarefa);

            return tarefa;

        } catch (Exception ex) {
            tarefaDao.rollBack();
            throw new Exception(ex.getMessage());
        }
    }

    public void finalizaTarefa(TarefaBean tarefa) throws Exception {
        try {
            tarefaDao.multiTransacao(true);
            tarefaDao.finalizaTarefa(tarefa);
            tarefaDao.commit();
        } catch (Exception ex) {
            tarefaDao.rollBack();
            throw new Exception(ex.getMessage());
        }
    }

    public void cancelaTarefa(TarefaBean tarefa) throws Exception {
        try {
            tarefaDao.multiTransacao(true);
            tarefaDao.cancelaTarefa(tarefa);
            tarefaDao.commit();
        } catch (Exception ex) {
            tarefaDao.rollBack();
            throw new Exception(ex.getMessage());
        }
    }
}
