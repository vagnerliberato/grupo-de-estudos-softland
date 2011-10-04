package diarioBordo.main;

import diarioBordo.bean.AnalistaBean;
import globalproject.conect.InterfaceConexao;
import java.sql.Connection;
import java.sql.SQLException;

public abstract class DataLocal {

    private static AnalistaBean analistaBean;
    private static InterfaceConexao classeConexao;
    private static Connection conexao;

    public DataLocal() {
        DataLocal.conexao = null;
    }

    protected static void setAnalistaBean(AnalistaBean analistaBean) {
        DataLocal.analistaBean = analistaBean;
    }

    protected static void setConexao(InterfaceConexao conexao) {
        DataLocal.classeConexao = conexao;
    }

    protected static InterfaceConexao getClasseConexao() {
        return classeConexao;
    }
    
    public static AnalistaBean getAnalistaBean() {
        return analistaBean;
    }
    
    public static Connection conexaoSingleton() throws ClassNotFoundException, SQLException {

        if (DataLocal.conexao == null) {

            try {
                DataLocal.conexao = classeConexao.getConexao();
                
                return DataLocal.conexao;
                
            } catch (ClassNotFoundException ex) {
                throw new ClassNotFoundException(ex.getMessage());
            } catch (SQLException ex) {
                throw new SQLException(ex.getMessage());
            }
        } else {
            return DataLocal.conexao;
        }
    }
}
