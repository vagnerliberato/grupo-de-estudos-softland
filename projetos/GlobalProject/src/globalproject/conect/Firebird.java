package globalproject.conect;

import java.sql.*;

/**
 * Classe para conexão com um banco de dados Firebird.
 *
 * @author Arthemus C. Moreira
 * @version 1.0.0
 */
public class Firebird implements InterfaceConexao {

    private String url = null;
    private String login = null;
    private String senha = null;

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void setUsuario(String usuario) {
        this.login = usuario;
    }

    @Override
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public Connection getConexao() throws ClassNotFoundException, SQLException {

        try {
            Class.forName("org.firebirdsql.jdbc.FBDriver");

            Connection con = DriverManager.getConnection(url, login, senha);

            return con;

        } catch (ClassNotFoundException erro) {
            throw new ClassNotFoundException("Problemas para carregar o driver de conexão: \n\n Erro: " + erro.getMessage());
        } catch (SQLException erro) {
            throw new SQLException("Problemas com a String de conexão: \n\n Erro: " + erro.getMessage());
        }
    }
}