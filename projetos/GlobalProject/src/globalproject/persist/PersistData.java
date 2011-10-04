package globalproject.persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Classe responsavel pelo acesso e persistencia no banco de dados.
 *
 * @author Arthemus C. Moreira
 * @version 1.0.0
 * @since Esta classe deve ser herdada por qualquer classe que venha a
 *   realizar operações no banco de dados, como por exemplo, as classes DAO.
 */
public abstract class PersistData {

    private static Connection conexao;
    private PreparedStatement statement;

    protected PersistData(Connection conexao) {
        PersistData.conexao = conexao;
    }

    private PreparedStatement getStatement(String st) throws SQLException {
        return PersistData.conexao.prepareStatement(st);
    }

    /**
     * Por padrão, as transações no banco de dados são finalizadas automaticamente.
     * Usar essa função caso deseje controlar as finalizações (Commit) ou 
     * estornos (RollBack) manualmente.
     * 
     * @param multi True ou False.
     * @throws Exception
     */
    public void multiTransacao(Boolean multi) throws Exception {
        try {
            PersistData.conexao.setAutoCommit(!multi);
        } catch (Exception ex) {
            throw new Exception("Problemas ao abrir uma nova transação no banco de dados: \n\n Erro: " + ex.getMessage());
        }
    }

    /**
     * Fecha a transação atual.
     */
    public void fechaTransacao() throws Exception {
        try {
            this.statement.close();
        } catch (Exception ex) {
            throw new Exception("Problemas para finalizar a transação com o banco de dados: \n\n Erro: " + ex.getMessage());
        }
    }

    /**
     * Em operações dos tipos (INSERT, UPDATE, DELETE), 
     * finaliza a transação com um Commit.
     * 
     * @throws Exception 
     */
    public void commit() throws Exception {
        try {
            PersistData.conexao.commit();
        } catch (Exception ex) {
            throw new Exception("Problemas para finalizar a gravação dos dados: \n\n Erro: " + ex.getMessage());
        }
    }

    /**
     * Estorna uma transação.
     * 
     * @throws Exception 
     */
    public void rollBack() throws Exception {
        try {
            PersistData.conexao.rollback();
        } catch (Exception ex) {
            throw new Exception("Problemas para estornar a transação com o banco de dados: \n\n Erro: " + ex.getMessage());
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
    public Integer executeCommand(String query, Object... params) throws Exception {
        try {
            this.statement = getStatement(query);

            for (int i = 0; i < params.length; i++) {
                this.statement.setObject(i + 1, params[i]);
            }

            return this.statement.executeUpdate();

        } catch (Exception ex) {
            throw new Exception("Problemas com execução do comando no banco de dados: \n\n Erro: " + ex.getMessage());
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

        } catch (Exception ex) {
            throw new Exception("Problemas ao realizar a pesquisa no banco de dados: \n\n Erro: " + ex.getMessage());
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
    public Integer ultimoID(String tableName, String id) throws Exception {

        ResultSet rs = executeQuery("SELECT MAX(" + id + ") from " + tableName);

        try {

            rs.next();

            Object result = rs.getObject(1);

            if (result == null) {
                return 1;
            } else {
                return (Integer) result + 1;
            }

        } catch (Exception ex) {
            throw new Exception("Problemas para obter o próximo ID da Tabela: " + tableName + "\n\n Erro: " + ex.getMessage());
        } finally {
            rs.close();
        }
    }
}
