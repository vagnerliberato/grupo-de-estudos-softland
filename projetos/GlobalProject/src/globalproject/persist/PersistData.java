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
 * @since Esta classe deve ser herdada por qualquer classe que venha a
 *   realizar operações no banco de dados, como por exemplo, as classes DAO.
 */
public class PersistData {

    private static Connection conect;
    private PreparedStatement statement;

    protected PersistData(Connection conexao) {
        PersistData.conect = conexao;
    }

    private PreparedStatement GetStatement(String st) throws SQLException {
        return PersistData.conect.prepareStatement(st);
    }

    public void MultiTransacao(Boolean multi) throws Exception {
        try {
            PersistData.conect.setAutoCommit(multi);
        } catch (Exception ex) {
            throw new Exception("Erro na abertura de transação com o banco de dados" + ex.getMessage());
        }
    }

    public void FinalizarTransacao() throws Exception {
        try {
            this.statement.close();
        } catch (Exception ex) {
            throw new Exception("Erro na finalização da chamada ao banco" + ex.getMessage());
        }
    }

    /**
     * Em operações de inserção ou alteração (INSERT, UPDATE, DELETE), finalização a 
     * transação com um Commit.
     * 
     * @throws Exception 
     */
    public void Commit() throws Exception {
        try {
            PersistData.conect.commit();
        } catch (Exception ex) {
            throw new Exception("Erro ao finalizar transação" + ex.getMessage());
        }
    }

    public void RollBack() throws Exception {
        try {
            PersistData.conect.rollback();
        } catch (Exception ex) {
            throw new Exception("Erro ao estornar transação" + ex.getMessage());
        }
    }

    /**
     * Executa um Script diretamente no banco de dados.
     * 
     * @param query Script a ser executado.
     * @param params Parametros a serem utilizados. (Obs. A quantidade de paramentros 
     *   não é fixa e pode variar independente do Script).
     * @throws Exception 
     */
    public Integer ExecuteCommand(String query, Object... params) throws Exception {
        try {
            this.statement = GetStatement(query);

            for (int i = 0; i < params.length; i++) {
                this.statement.setObject(i + 1, params[i]);
            }

            return this.statement.executeUpdate();

        } catch (Exception e) {
            throw new Exception("Erro na execução do comando no banco de dados: \n\n" + e.getMessage());
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
    public ResultSet ExecuteQuery(String query, Object... params) throws Exception {
        try {
            this.statement = GetStatement(query);

            for (int i = 0; i < params.length; i++) {
                this.statement.setObject(i + 1, params[i]);
            }

            return this.statement.executeQuery();

        } catch (Exception e) {
            throw new Exception("Erro na execução da pesquisa no banco de dados: \n\n" + e.getMessage());
        }
    }

    /**
     * Determina um novo ID para uma tabela.
     *
     * @param conexao Conexão com o banco de dados, uma instancia da classe Firebird por exemplo.
     * @param tableName Tabela para qual deseja-se gerar o novo ID.
     * @param id Nome do campo ID da tabela.
     * @return O próximo ID possivel da tabela.
     * @throws Exception
     */
    public Integer UltimoId(String tableName, String id) throws Exception {

        ResultSet rs = ExecuteQuery("SELECT MAX(" + id + ") from " + tableName);

        rs.next();

        Object result = rs.getObject(1);

        try {
            if (result == null) {
                return 1;
            } else {
                return (Integer) result + 1;
            }
        } finally {
            rs.close();
        }
    }
}
