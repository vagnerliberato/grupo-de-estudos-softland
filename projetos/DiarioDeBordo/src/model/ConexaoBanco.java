package model;

import java.sql.*;

public class ConexaoBanco {

    private static String url, usuario, senha, drive;

    public static Connection Conectar() {
        try {
            drive = "org.firebirdsql.jdbc.FBDriver";
            url = "jdbc:firebirdsql:192.168.1.120/3060:D:/Bancos/Agenda/agenda.fdb";
            usuario = "SYSDBA";
            senha = "buana";

            Class.forName(drive);

            Connection con = DriverManager.getConnection(url, usuario, senha);

            return con;

        } catch (Exception e) {
            return null;
        }
    }
}
