package br.com.diario.main;

import br.com.diario.bean.AnalistaBean;
import br.com.diario.forms.Principal;
import globalproject.conect.Firebird;
import globalproject.generic.Funcoes;
import java.sql.Connection;
import java.sql.SQLException;

public class Main extends DataLocal {

    public static void main(String[] args) {

        try {
            setConexao(new Firebird());
            getClasseConexao().setUrl("jdbc:firebirdsql:Arthemus-PC/3050:C:/Bancos/AGENDA.FDB");
            getClasseConexao().setUsuario("SYSDBA");
            getClasseConexao().setSenha("buana");

            setAnalistaBean(new AnalistaBean());
            getAnalistaBean().setId("09");
            getAnalistaBean().setNome("Arthemus");
            getAnalistaBean().setSenha("carol");

            Connection con = conexaoSingleton();

            if (con != null) {
                Principal sistema = new Principal();
                sistema.setVisible(true);
            } else {
                Funcoes.alerta(null, "N�o a conex�o com o banco de dados");
            }
        } catch (ClassNotFoundException ex) {
            Funcoes.alerta(null, ex.getMessage());
        } catch (SQLException ex) {
            Funcoes.alerta(null, ex.getMessage());
        }
    }
}
