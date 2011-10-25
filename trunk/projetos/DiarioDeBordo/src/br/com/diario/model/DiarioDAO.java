package br.com.diario.model;

import br.com.diario.bean.DiarioBean;
import br.com.diario.main.DataLocal;
import globalproject.generic.Funcoes;
import globalproject.persist.PersistData;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;

public class DiarioDAO extends PersistData {

    private final String INSERT =
            "insert into diario (" + "id_diario, " + "observacao, " + "data, " + "hora, " + "id_analista) " + "values (?, ?, ?, ?, ?)";

    public DiarioDAO(Connection conexao) {
        super(conexao);
    }

    public boolean isDiaAberto(Date AData) throws Exception {

        ResultSet resultSet = null;

        try {
            resultSet =
                    executeQuery("select d.data " + "from diario d " + "where d.data = ? and d.id_analista = ?",
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

    public int abrirNovoDia(DiarioBean diario) throws Exception {
        try {
            return executeCommand(
                    this.INSERT,
                    ultimoID("DIARIO", "ID_DIARIO"),
                    diario.getObservacao(),
                    Funcoes.getDataSQL(diario.getData()),
                    diario.getHora(),
                    diario.getAnalista().getId());

        } catch (Exception ex) {
            throw new Exception("Problemas para abrir um novo diario: \n\n" + ex.getMessage());
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
            result = executeQuery("select d.ID_DIARIO, "
                    + "d.OBSERVACAO, "
                    + "d.DATA, "
                    + "d.HORA, "
                    + "d.ID_ANALISTA "
                    + "from diario d "
                    + "where d.data = ? and d.id_analista = ?",
                    Funcoes.getDataSQL(new Date()),
                    DataLocal.getAnalistaBean().getId());

            if (result.next()) {
                diario.setId(result.getInt("ID_DIARIO"));
                diario.setData(result.getDate("DATA"));
                diario.setHora(result.getString("HORA"));
                diario.setObservacao(result.getString("OBSERVACAO"));
            } else {
                throw new Exception("Não foi possivel carregar o diário atual, verifique!");
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
