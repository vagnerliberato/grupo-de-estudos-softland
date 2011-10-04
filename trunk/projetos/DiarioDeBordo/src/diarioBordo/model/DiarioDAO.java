package diarioBordo.model;

import diarioBordo.bean.DiarioBean;
import diarioBordo.main.DataLocal;
import globalproject.generic.Funcoes;
import globalproject.persist.PersistData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

public class DiarioDAO extends PersistData {

    private DiarioBean diarioBean;
    private final String insert =
            "insert into diario ("
            + "id_diario, "
            + "observacao, "
            + "datainicio, "
            + "datafim, "
            + "horainicio, "
            + "horafim, "
            + "id_analista) "
            + "values (?, ?, ?, ?, ?, ?, ?)";
    private final String delete =
            "delete from diario where (id_diario = ?)";
    private final String update =
            "update diario set "
            + "observacao = ?, "
            + "datainicio = ?, "
            + "datafim = ?, "
            + "horainicio = ?, "
            + "horafim = ?, "
            + "id_analista = ? "
            + "where (id_diario = ?)";

    public DiarioDAO(Connection conexao) {
        super(conexao);
    }

    public DiarioBean getDiarioBean() {
        return diarioBean;
    }

    public void setDiarioBean(DiarioBean diarioBean) {
        this.diarioBean = diarioBean;
    }

    public boolean isDiaAberto(Date AData) throws Exception {

        ResultSet resultSet = null;

        try {
            resultSet =
                    executeQuery("select d.datainicio "
                    + "from diario d "
                    + "where d.datainicio = ? and d.id_analista = ?",
                    Funcoes.getDataSQL(AData),
                    DataLocal.getAnalistaBean().getId());

            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            throw new Exception("Problemas ao verificar se já existi um diario aberto hoje: \n\n" + ex.getMessage());
        } finally {
            resultSet.close();
        }
    }

    public boolean isValidaAberturaFechamento(Date AData) throws Exception {

        ResultSet resultSet = null;

        try {
            resultSet = executeQuery("select d.datainicio "
                    + "from diario d "
                    + "where d.datainicio = ? and d.datafim is null",
                    Funcoes.getDataSQL(AData));

            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            throw new Exception("Problemas ao verificar se já existi um diario aberto hoje: \n\n" + ex.getMessage());
        } finally {
            resultSet.close();
        }
    }

    public int abrirNovoDia() throws Exception {
        try {
            return executeCommand(
                    this.insert,
                    ultimoID("DIARIO", "ID_DIARIO"),
                    this.diarioBean.getObservacao(),
                    Funcoes.getDataSQL(this.diarioBean.getDataInicio()),
                    this.diarioBean.getDataFim(),
                    this.diarioBean.getHoraInicio(),
                    this.diarioBean.getHoraFim(),
                    this.diarioBean.getAnalista().getId());

        } catch (Exception ex) {
            throw new Exception("Problemas para abrir um novo diário: \n\n" + ex.getMessage());
        } finally {
            fechaTransacao();
        }
    }

    public int fecharDia(Date dData) throws Exception {

        try {
            ResultSet diarioAtual = executeQuery("select "
                    + "id_diario, "
                    + "observacao, "
                    + "datainicio, "
                    + "datafim, "
                    + "horainicio, "
                    + "horafim, "
                    + "id_analista "
                    + "from diario "
                    + "where datainicio = ?", Funcoes.getDataSQL(dData));

            diarioAtual.next();

            return executeCommand(
                    this.update,
                    diarioAtual.getString("OBSERVACAO"),
                    diarioAtual.getDate("DATAINICIO"),
                    Funcoes.getDataSQL(dData),
                    diarioAtual.getString("HORAINICIO"),
                    Funcoes.getHoraAtual(),
                    diarioAtual.getString("ID_ANALISTA"),
                    diarioAtual.getString("ID_DIARIO"));

        } catch (Exception ex) {
            throw new Exception("Problemas para fechar o diário atual: \n\n" + ex.getMessage());
        } finally {
            fechaTransacao();
        }
    }

    public int getIdDiarioAtual(Date AData) throws Exception {
        
        ResultSet resultSet = null;

        try {
            resultSet =
                    executeQuery("select d.id_diario "
                    + "from diario d "
                    + "where d.datainicio = ? and d.id_analista = ?",
                    Funcoes.getDataSQL(AData),
                    DataLocal.getAnalistaBean().getId());

            if (resultSet.next()) {
                
                int idDiario = resultSet.getInt("ID_DIARIO");
                
                return idDiario;
                
            } else {
                throw new Exception("Não existe um diário aberto para o dia de hoje! \n"
                        + "Abra um novo dia antes de cadastrar tarefas!");
            }
        } catch (Exception ex) {
            throw new Exception("Problemas ao verificar se já existi um diario aberto hoje: \n\n" + ex.getMessage());
        }
    }
}
