package globalproject.conect;

import java.sql.*;

/**
 * Classe para conexão com um banco de dados Firebird.
 *
 * @author Arthemus C. Moreira
 * @version 1.0.0
 * @since Deve-se alterar manualmente os atributos URL, LOGIN e SENHA.
 *        Não é possível instanciar diretamente a classe Firebird, para utiliza-la
 *        deve-se chamar o método Singleton.
 */
public class Firebird {

    private static Firebird firebird = null;
    private static String driver = null;
    private static String url = null;
    private static String login = null;
    private static String senha = null;

    private Firebird() {
    }

    /**
     * 
     * @return Conexão com o banco de dados.
     */
    public static Connection getConexao() throws ClassNotFoundException, SQLException {

        driver = "org.firebirdsql.jdbc.FBDriver";
        url = "jdbc:firebirdsql:arthemus/3060:C:/ArvoreDeTrabalho/Bancos/AGENDA.FDB";
        login = "SYSDBA";
        senha = "masterkey";

        try {
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, login, senha);

            return con;

        } catch (ClassNotFoundException erro) {
            throw new ClassNotFoundException("Erro com a implementação do Driver de conexão: \n\n" + erro.getMessage());
        } catch (SQLException erro) {
            throw new SQLException("Erro com a String de conexão: \n\n" + erro.getMessage());
        }
    }

    /**
     * 
     * @return Uma instancia da Classe Firebird.
     */
    public static Firebird Singleton() {

        if (Firebird.firebird == null) {
            Firebird.firebird = new Firebird();
        }

        return Firebird.firebird;
    }
}