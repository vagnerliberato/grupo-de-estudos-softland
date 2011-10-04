package diarioBordo.model;

import diarioBordo.bean.TarefaBean;
import diarioBordo.main.DataLocal;
import globalproject.generic.Funcoes;
import globalproject.persist.PersistData;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Arthemus
 */
public class TarefaDAO extends PersistData {

    private final String insert =
            "insert into tarefa ("
            + "id_tarefa, "
            + "descricao, "
            + "horainicio, "
            + "observacoes, "
            + "status, "
            + "ficha) "
            + "values (?, ?, ?, ?, ?, ?)";
    private final String delete =
            "delete from tarefa where id_tarefa = ?";
    private final String update =
            "update tarefa set "
            + "descricao = ?, "
            + "horainicio = ?, "
            + "horafim = ?, "
            + "observacoes = ?, "
            + "status = ?,"
            + "ficha = ? "
            + "where (id_tarefa = ?)";
    private final String insertControle =
            "insert into controle_diario_tarefa ("
            + "id_diario, "
            + "id_tarefa) "
            + "values (?, ?)";
    private final String deleteControle =
            "delete from controle_diario_tarefa "
            + "where (id_diario = ?) and (id_tarefa = ?)";

    public TarefaDAO(Connection conexao) {
        super(conexao);
    }

    public ResultSet carregaTarefas() throws Exception {

        ResultSet rs;

        try {
            rs = executeQuery("select "
                    + "tr.id_tarefa, "
                    + "tr.descricao, "
                    + "tr.horainicio, "
                    + "tr.horafim, "
                    + "tr.observacoes, "
                    + "tr.status, "
                    + "tr.ficha "
                    + "from tarefa tr "
                    + "inner join controle_diario_tarefa cr on (cr.id_tarefa = tr.id_tarefa) "
                    + "inner join diario d on (d.id_diario = cr.id_diario) "
                    + "where d.datainicio = ? "
                    + "and d.id_analista = ?",
                    Funcoes.getDataSQL(Funcoes.getDataAtual()),
                    DataLocal.getAnalistaBean().getId());

            return rs;

        } catch (Exception ex) {
            throw new Exception("Problemas para buscar tarefas: \n\n Erro: " + ex.getMessage());
        }
    }

    public int cadastraTarefa(TarefaBean tarefa) throws Exception {

        try {
            int id = ultimoID("TAREFA", "ID_TAREFA");

            int result = executeCommand(
                    this.insert,
                    id,
                    tarefa.getDescricao(),
                    tarefa.getHoraInicio(),
                    tarefa.getObservacao(),
                    tarefa.getStatus(),
                    tarefa.getFicha());

            if (result <= 0) {
                throw new Exception("Não consegui gravar essa tarefa! \n Verifique os valores e tente novamente.");
            } else {
                return id;
            }

        } catch (Exception ex) {
            throw new Exception("Problemas para cadastrar a nova tarefa: \n\n Erro: " + ex.getMessage());
        }
    }

    public void cadastraControle(int idTarefa, int idDiario) throws Exception {

        try {
            int result = executeCommand(
                    this.insertControle,
                    idDiario,
                    idTarefa);

            if (result <= 0) {
                throw new Exception("Não consegui gravar o controle dessa tarefa! \n Verifique os valores e tente novamente.");
            }

        } catch (Exception ex) {
            throw new Exception("Problemas para incluir o controle dessa tarefa: \n\n Erro: " + ex.getMessage());
        }
    }
}
