package br.com.diario.model;

import br.com.diario.bean.DiarioBean;
import br.com.diario.main.DataLocal;
import globalproject.generic.Funcoes;
import globalproject.persist.PersistData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

public class DiarioDAO extends PersistData {

    private final String insert =
            "insert into diario (" + "id_diario, " + "observacao, " + "datainicio, " + "datafim, " + "horainicio, " + "horafim, " + "id_analista) " + "values (?, ?, ?, ?, ?, ?, ?)";
    private final String delete =
            "delete from diario where (id_diario = ?)";
    private final String update =
            "update diario set " + "observacao = ?, " + "datainicio = ?, " + "datafim = ?, " + "horainicio = ?, " + "horafim = ?, " + "id_analista = ? " + "where (id_diario = ?)";

    public DiarioDAO(Connection conexao) {
        super(conexao);
    }

    public boolean isDiaAberto(Date AData) throws Exception {

        ResultSet resultSet = null;

        try {
            resultSet =
                    executeQuery("select d.datainicio " + "from diario d " + "where d.datainicio = ? and d.id_analista = ?",
                    Funcoes.getDataSQL(AData),
                    DataLocal.getAnalistaBean().getId());

            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            throw new Exception("Problemas ao verificar se ja existi um diario aberto hoje: \n\n" + ex.getMessage());
        } finally {
            resultSet.close();
        }
    }

    public boolean isValidaAberturaFechamento(Date AData) throws Exception {

        ResultSet resultSet = null;

        try {
            resultSet = executeQuery("select d.datainicio " + "from diario d " + "where d.datainicio = ? and d.datafim is null",
                    Funcoes.getDataSQL(AData));

            if (resultSet.next()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            throw new Exception("Problemas ao verificar se ja existi um diario aberto hoje: \n\n" + ex.getMessage());
        } finally {
            resultSet.close();
        }
    }

    public int abrirNovoDia(DiarioBean diario) throws Exception {
        try {
            return executeCommand(
                    this.insert,
                    ultimoID("DIARIO", "ID_DIARIO"),
                    diario.getObservacao(),
                    Funcoes.getDataSQL(diario.getDataInicio()),
                    diario.getDataFim(),
                    diario.getHoraInicio(),
                    diario.getHoraFim(),
                    diario.getAnalista().getId());

        } catch (Exception ex) {
            throw new Exception("Problemas para abrir um novo diario: \n\n" + ex.getMessage());
        } finally {
            fechaTransacao();
        }
    }

    public int fecharDia(Date dData) throws Exception {

        try {
            ResultSet diarioAtual = executeQuery("select " + "id_diario, " + "observacao, " + "datainicio, " + "datafim, " + "horainicio, " + "horafim, " + "id_analista " + "from diario " + "where datainicio = ?", Funcoes.getDataSQL(dData));

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
            throw new Exception("Problemas para fechar o diario atual: \n\n" + ex.getMessage());
        } finally {
            fechaTransacao();
        }
    }

    public int getIdDiarioAtual(Date AData) throws Exception {
        ResultSet resultSet = null;

        try {
            resultSet =
                    executeQuery("select d.id_diario " + "from diario d " + "where d.datainicio = ? and d.id_analista = ?",
                    Funcoes.getDataSQL(AData),
                    DataLocal.getAnalistaBean().getId());

            if (resultSet.next()) {
                int idDiario = resultSet.getInt("ID_DIARIO");
                return idDiario;
            } else {
                throw new Exception("Abra um diário para o dia de hoje");
            }
        } catch (Exception ex) {
            throw new Exception("Problemas ao verificar se ja existi um diario aberto hoje: \n\n" + ex.getMessage());
        }
    }

    public void getDiarioAtual(DiarioBean diario) throws Exception {
        try {
            ResultSet result = null;
            result = executeQuery("select d.ID_DIARIO, " +
                    "d.OBSERVACAO, " +
                    "d.DATAINICIO, " +
                    "d.DATAFIM, " +
                    "d.HORAINICIO, " +
                    "d.HORAFIM, " +
                    "d.ID_ANALISTA " +
                    "from diario d " +
                    "where d.datainicio = ? and d.id_analista = ?",
                    Funcoes.getDataSQL(new Date()),
                    DataLocal.getAnalistaBean().getId());

            if (result.next()) {
                diario.setId(result.getInt("ID_DIARIO"));
                diario.setDataInicio(result.getDate("DATAINICIO"));
                diario.setDataFim(result.getDate("DATAFIM"));
                diario.setHoraInicio(result.getString("HORAINICIO"));
                diario.setHoraFim(result.getString("HORAFIM"));
                diario.setObservacao(result.getString("OBSERVACAO"));
            } else {
                throw new Exception("Não foi possivel carregar o diário atual, verifique!");
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
