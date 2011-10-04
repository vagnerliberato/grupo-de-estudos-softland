package aula.dao;

import globalproject.persist.PersistData;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class DAO extends PersistData {

    public DAO(Connection conexao) {
        super(conexao);
    }

    public ResultSet ConsultaCliente(String codigo) throws Exception {
        try {
            String sql = "select ALMOX, ALMOXDES from ALMOX";

            ResultSet rs = executeQuery(sql);

            return rs;

        } catch (Exception erro) {
            throw new Exception("Erro na execução da pesquisa no banco de dados: \n\n" + erro.getMessage());
        }
    }

    public void deletaID(Integer id) throws Exception {
        try {
            String sql = "DELETE FROM ALMOX WHERE ALMOX = ?";

            int registros = executeCommand(sql, id);

            if (registros > 0) {
                JOptionPane.showMessageDialog(null, "Registro deletado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Problemas...");
            }

        } catch (Exception erro) {
            throw new Exception("Erro na execução da pesquisa no banco de dados: \n\n" + erro.getMessage());
        }
    }
}
