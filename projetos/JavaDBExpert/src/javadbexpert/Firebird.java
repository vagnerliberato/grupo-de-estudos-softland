package javadbexpert;

import java.sql.*;

public class Firebird {

    private String url = "";
    private String login = "";
    private String senha = "";
    private String driver = "";

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLogin(String usuario) {
        this.login = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public Connection getConexao() throws ClassNotFoundException, SQLException {

        try {
            Class.forName(driver);

            Connection con = DriverManager.getConnection(url, login, senha);

            return con;

        } catch (ClassNotFoundException erro) {
            throw new ClassNotFoundException("Problemas para carregar o driver de conexão: \n\n Erro: " + erro.getMessage());
        } catch (SQLException erro) {
            throw new SQLException("Problemas com a String de conexão: \n\n Erro: " + erro.getMessage());
        }
    }
}
