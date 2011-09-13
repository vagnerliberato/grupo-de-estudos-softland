package globalproject.generic;

import globalproject.persist.PersistData;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;

/**
 * Classe de uso generico. Contem métodos de utilização diversa dentro do sistema.
 *
 * @author Arthemus C. Moreira
 * @version 1.0.0
 * @since Esta classe não deve ser instanciada. Todos os métodos devem ser estaticos
 *        afim de facilitar sua implementação dentro do sistema.
 */
public class Global {

    private Global() {
    }

    /**
     * Método para geração de uma String de Log.
     * Exemplo: "Arthemus 12/09/2011 22:31:42"
     * 
     * @param usuario Usuário local que esta utilizando o sistema
     * @return Uma string que pode ser usada como Log para qualquer mudança no banco de dados.
     * @throws Exception 
     */
    public static String gerarCampo(String usuario) throws Exception {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        return usuario + " - " + (format.format(new Date()));
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
    public static Integer ultimoId(Connection conexao, String tableName, String id) throws Exception {

        PersistData data = new PersistData(conexao);

        ResultSet rs = data.executeQuery("SELECT MAX(" + id + ") from " + tableName);

        rs.next();

        Object result = rs.getObject(1);

        try {
            if (result == null) {
                return 1;
            } else {
                return (Integer) result + 1;
            }
        } finally {
            rs.close();
        }
    }

    /**
     * Esse método deve ser usado exclusivamente para JSF, onde
     * é necessário gerenciar a navegação das paginas dentro do sistema.
     * 
     * @param APagina Pagina para onde deseja-se direcionar.
     * @throws Exception 
     */
    public static void irPara(String APagina) throws Exception {

        FacesContext faces = FacesContext.getCurrentInstance();

        ExternalContext context = faces.getExternalContext();

        context.redirect(context.getRequestContextPath() + "/" + APagina);
    }

    /**
     * Dispara uma mensagem para a pagina atual. Deve ser usado apenas com JSF.
     * 
     * @param tipo Implementação da classe Severity. O tipo da mensagem como por exemplo, FACES_MESSAGES.
     * @param msg Texto a ser exibido.
     */
    public static void alertaMsg(Severity tipo, String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, "", msg));
    }

    /**
     * Dispara uma mensagem para o form atual. Deve ser usado em sistema Swing.
     * 
     * @param obj Formulario ou tela a qual pertence o alerta.
     * @param msg Texto a ser exibido.
     */
    public static void alertaMsg(Component obj, String msg) {
        JOptionPane.showMessageDialog(obj, msg);
    }
}