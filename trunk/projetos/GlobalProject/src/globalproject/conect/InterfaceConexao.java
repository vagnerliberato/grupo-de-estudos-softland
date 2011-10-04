package globalproject.conect;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interface para classe de Conexão com um SGBD.
 * 
 * @author Arthemus
 * @version 1.0.0
 */
public interface InterfaceConexao {

    void setUrl(String url);

    void setUsuario(String usuario);

    void setSenha(String senha);

    Connection getConexao() throws ClassNotFoundException, SQLException;
}
