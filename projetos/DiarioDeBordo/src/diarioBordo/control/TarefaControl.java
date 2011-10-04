package diarioBordo.control;

import diarioBordo.bean.TarefaBean;
import diarioBordo.main.DataLocal;
import diarioBordo.model.DiarioDAO;
import diarioBordo.model.TarefaDAO;
import globalproject.generic.Funcoes;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Arthemus
 */
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
}
