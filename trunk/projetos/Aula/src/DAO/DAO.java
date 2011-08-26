package DAO;

import Conexao.ConexaoBanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class DAO {

    Connection Conexao = ConexaoBanco.Conectar();
    private String statusconexao;

    public String getStatusconexao() {
        return statusconexao;
    }

    public void setStatusconexao(String statusconexao) {
        this.statusconexao = statusconexao;
    }

    public DAO() {


        if (Conexao == null) {
            setStatusconexao("IH! Deu shit");

        } else {
            setStatusconexao("Conexão OK");
        }
    }

    public ResultSet ConsultaCliente(String codigo) {
        try {
            String sql = "select ALMOX,ALMOXDES from ALMOX";
            PreparedStatement stm = Conexao.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            return rs;

        } catch (Exception erro) {
            return null;
        }
    }

    public void deletaID(Integer id) {
        try {
            String sql = "DELETE FROM ALMOX WHERE ALMOX = ?";
            PreparedStatement stm = Conexao.prepareStatement(sql);

            stm.setInt(1, id);

            int registros = stm.executeUpdate();

            if (registros > 0) {
                JOptionPane.showMessageDialog(null, "Registro deletado com sucesso");
            } else {
                JOptionPane.showMessageDialog(null, "Problemas...");
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, erro.getMessage());
        }
    }
}
