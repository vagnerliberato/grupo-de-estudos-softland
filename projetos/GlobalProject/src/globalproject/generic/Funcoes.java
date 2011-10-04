package globalproject.generic;

import java.awt.Component;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 * Classe de uso generico.
 * Contem métodos de utilização diversa dentro do sistema.
 *
 * @author Arthemus C. Moreira
 * @version 1.0.0
 * @since Esta classe não deve ser instanciada. 
 * Todos os métodos devem ser estaticos afim de facilitar sua 
 * implementação dentro dos sistemas.
 */
public abstract class Funcoes {

    /**
     * Método para geração de uma String de Log.
     * Exemplo: "Fulano - 12/09/2011 22:31:42"
     * 
     * @param usuario Usuário local que esta utilizando o sistema
     * @return Uma string que pode ser usada como Log para qualquer mudança no banco de dados.
     * @throws Exception 
     */
    public static String getCampoLog(String usuario) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return usuario + " - " + (format.format(new Date()));
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
     * Dispara uma mensagem para a pagina atual. 
     * Deve ser usado apenas com JSF.
     * 
     * @param tipo Implementação da classe Severity. O tipo da mensagem como por exemplo, FACES_MESSAGES.
     * @param msg Texto a ser exibido.
     */
    public static void facesMsg(Severity tipo, String msg) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, "", msg));
    }

    /**
     * Dispara uma mensagem para o form atual. Deve ser usado em sistema Swing.
     * 
     * @param obj Formulario ou tela a qual pertence o alerta.
     * @param msg Texto a ser exibido.
     */
    public static void alerta(Component obj, String msg) {
        JOptionPane.showMessageDialog(obj, msg);
    }

    /**
     *
     * @return A data do dia corrente.
     */
    public static Date getDataAtual() {
        Calendar calendario = new GregorianCalendar();
        calendario.setTime(new Date());
        return calendario.getTime();
    }

    /**
     * 
     * @param AData Data desejada instanciada da classe Date.
     * @return Uma String da data atual no formato dd/mm/aaaa.
     */
    public static String getDataString(Date AData) {
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return format.format(AData);
    }

    /**
     * 
     * @param AData Data desejada instanciada da classe Date.
     * @return A data do dia corrente para ser usada em Querys SQL.
     * @throws ParseException 
     */
    public static Date getDataSQL(Date AData) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dDataAtual = format.parse(format.format(AData));
        java.sql.Date dDataSQL = new java.sql.Date(dDataAtual.getTime());
        return dDataSQL;
    }

    /**
     *
     * @return A hora atual no formato HH:MM:SS.
     */
    public static String getHoraAtual() {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String sHoraAtual = format.format(new Date());
        return sHoraAtual;
    }

    /**
     *
     * @param AData A data da qual se deseja extrair o horario.
     * @return Um novo horario no formato HH:MM:SS.
     */
    public static String getHora(Date AData) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String sHoraAtual = format.format(AData);
        return sHoraAtual;
    }

    /**
     * Método para carregar um objeto do tipo JTable com um ResultSet.
     * Útil para telas swing que utilizão uma tabela para exibição dos dados.
     * 
     * @param tabela Objeto do tipo JTable.
     * @param result ResultSet contendo os dados a serem inseridos na tabela.
     * @throws Exception
     */
    public static void montaTabela(JTable tabela, ResultSet result) throws Exception {
        try {
            tabela.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            tabela.setModel(new TabelaModelo(result));
        } catch (Exception ex) {
            throw new Exception("Problemas para carregar tabela: \n\n Erro: " + ex.getMessage());
        }
    }
}
