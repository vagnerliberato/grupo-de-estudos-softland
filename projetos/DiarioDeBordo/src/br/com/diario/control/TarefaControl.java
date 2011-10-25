package br.com.diario.control;

import br.com.diario.bean.DiarioBean;
import br.com.diario.bean.TarefaBean;
import br.com.diario.main.DataLocal;
import br.com.diario.model.TarefaDAO;
import globalproject.generic.Funcoes;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

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

    public ResultSet carregaDados(Date AData) throws Exception {
        try {
            ResultSet rs = tarefaDao.carregaTarefas(AData);
            return rs;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public void cadastraTarefa(TarefaBean tarefa) throws Exception {
        try {
            DiarioControl diarioControl = new DiarioControl();

            DiarioBean diario = new DiarioBean();

            diarioControl.getDiarioAtual(diario);

            tarefaDao.multiTransacao(true);

            int idTarefa = tarefaDao.cadastraTarefa(tarefa);

            tarefaDao.cadastraControle(idTarefa, diario.getId());

            tarefaDao.commit();

            tarefa.setId(idTarefa);
        } catch (Exception ex) {
            if (!conexaoSingleton().getAutoCommit()) {
                tarefaDao.rollBack();
            }

            throw new Exception(ex.getMessage());
        }
    }

    public void finalizaTarefa(TarefaBean tarefa) throws Exception {
        try {
            tarefaDao.multiTransacao(true);

            tarefa.setStatus("" + 2);

            tarefa.setHoraFim(Funcoes.getHoraAtual());

            tarefaDao.atualizaTarefa(tarefa);

            tarefaDao.commit();
        } catch (Exception ex) {
            tarefaDao.rollBack();
            throw new Exception(ex.getMessage());
        }
    }

    public void cancelaTarefa(TarefaBean tarefa) throws Exception {
        try {
            tarefaDao.multiTransacao(true);

            tarefa.setStatus("" + 0);

            tarefa.setHoraFim(Funcoes.getHoraAtual());

            tarefaDao.atualizaTarefa(tarefa);

            tarefaDao.commit();
        } catch (Exception ex) {
            tarefaDao.rollBack();
            throw new Exception(ex.getMessage());
        }
    }

    public void alteraTarefa(TarefaBean tarefa) throws Exception {
        try {
            tarefaDao.multiTransacao(true);

            tarefa.setStatus("" + 1);

            tarefa.setHoraFim(null);

            tarefaDao.atualizaTarefa(tarefa);

            tarefaDao.commit();
        } catch (Exception ex) {
            tarefaDao.rollBack();
            throw new Exception(ex.getMessage());
        }
    }

    public void excluiTarefa(final int idTarefa) throws Exception {
        try {
            DiarioControl diarioControl = new DiarioControl();

            DiarioBean diario = new DiarioBean();

            diarioControl.getDiarioAtual(diario);

            tarefaDao.multiTransacao(true);

            tarefaDao.deletaControle(idTarefa, diario.getId());

            tarefaDao.deletaTarefa(idTarefa);

            tarefaDao.commit();
        } catch (Exception ex) {
            if (!conexaoSingleton().getAutoCommit()) {
                tarefaDao.rollBack();
            }

            throw new Exception(ex.getMessage());
        }
    }
}
