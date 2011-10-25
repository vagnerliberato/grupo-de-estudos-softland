package br.com.diario.main;

import br.com.diario.bean.AnalistaBean;
import br.com.diario.forms.PropJDBC;
import br.com.diario.forms.Login;
import br.com.diario.forms.Principal;
import globalproject.conect.Firebird;
import globalproject.generic.Funcoes;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends DataLocal {

    public static void main(String[] args) {

        try {
            Properties prop = new Properties();

            try {
                prop.load(new FileInputStream("firebird.properties"));
            } catch (IOException ex) {

                Funcoes.alerta(null, "Não foi possivel encontrar o "
                        + "arquivo de configuração com as propriedades do banco de dados \nInforme as novas propriedades!");

                PropJDBC jdbc = new PropJDBC();
                jdbc.setVisible(true);
            }

            try {
                prop.load(new FileInputStream("firebird.properties"));
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }

            setConexao(new Firebird());
            getClasseConexao().setUrl(prop.getProperty("jdbc.url"));
            getClasseConexao().setUsuario(prop.getProperty("jdbc.user"));
            getClasseConexao().setSenha(prop.getProperty("jdbc.pass"));

            AnalistaBean analista = new AnalistaBean();

            Login login = new Login(analista);

            login.setVisible(true);

            setAnalistaBean(analista);

            Connection con = conexaoSingleton();

            if (con != null) {
                Principal sistema = new Principal();
                sistema.setVisible(true);
            } else {
                Funcoes.alerta(null, "Não a conexão com o banco de dados");
            }
        } catch (ClassNotFoundException ex) {
            Funcoes.alerta(null, ex.getMessage());
        } catch (SQLException ex) {
            Funcoes.alerta(null, ex.getMessage());
        }
    }
}
