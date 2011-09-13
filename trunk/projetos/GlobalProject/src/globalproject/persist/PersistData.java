package globalproject.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe responsavel pela persistencia dos dados.
 *
 * @author Arthemus C. Moreira
 * @version 1.0.0
 * @since Esta classe deve ser instancia e utilizada para qualquer chamada ao banco de dados.
 */
public class PersistData {

    private static Connection conect;
    private PreparedStatement statement;

    public PersistData(Connection conexao) {
        PersistData.conect = conexao;
    }

    private PreparedStatement getStatement(String st) throws SQLException {
        return PersistData.conect.prepareStatement(st);
    }

    private void openData() throws Exception {
        PersistData.conect.setAutoCommit(false);

        throw new Exception("Abertura da transação com o banco de dados");
    }

    private void closeData() throws Exception {
        this.statement.close();

        throw new Exception("Finalização da chamada ao banco");
    }

    /**
     * Em operações de inserção ou alteração (INSERT, UPDATE, DELETE), finalização a 
     * transação com um Commit.
     * 
     * @throws Exception 
     */
    public void finalData() throws Exception {
        PersistData.conect.commit();

        throw new Exception("Finalização da transação");
    }

    private void backData() throws Exception {
        PersistData.conect.rollback();

        throw new Exception("Estornar da transação");
    }

    /**
     * Executa um Script diretamente no banco de dados.
     * 
     * @param query Script a ser executado.
     * @param params Parametros a serem utilizados. (Obs. A quantidade de paramentros 
     *   não é fixa e pode variar independente do Script).
     * @throws Exception 
     */
    public void executeCommand(String query, Object... params) throws Exception {
        try {
            openData();

            this.statement = getStatement(query);

            for (int i = 0; i < params.length; i++) {
                this.statement.setObject(i + 1, params[i]);
            }

            int result = this.statement.executeUpdate();

            backData();

        } catch (Exception e) {

            throw new Exception("Erro na execução do comando no banco de dados: \n\n" + e.getMessage());

        } finally {

            closeData();
        }
    }

    /**
     * Utilizado exclusivamente para Script de pesquisa no banco de dados (SELECT).
     * 
     * @param query Script a ser executado.
     * @param params Parametros a serem utilizados. (Obs. A quantidade de paramentros 
     *   não é fixa e pode variar independente do Script).
     * @return Um ResultSet contendo os registros da pesquisa.
     * @throws Exception 
     */
    public ResultSet executeQuery(String query, Object... params) throws Exception {
        try {
            this.statement = getStatement(query);

            for (int i = 0; i < params.length; i++) {
                this.statement.setObject(i + 1, params[i]);
            }

            return this.statement.executeQuery();

        } catch (Exception e) {

            throw new Exception("Erro na execução da pesquisa no banco de dados: \n\n" + e.getMessage());

        } finally {

            closeData();
        }
    }
}