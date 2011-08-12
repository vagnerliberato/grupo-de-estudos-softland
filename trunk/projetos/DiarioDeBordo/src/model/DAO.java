package model;

import bean.TarefaBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DAO {

    private static Connection conexao = null;

    public DAO() {
        DAO.conexao = ConexaoBanco.Conectar();

        try {
            DAO.conexao.setAutoCommit(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void cadastraDiario() {
    }

    public void alteraDiario() {
    }

    public void deletaDiario() {
    }

    public void pesquisaDiario() {
    }

    public void cadastraTarefa(TarefaBean tarefa) {

        String query = "insert into tarefa (id_tarefa, descricao, status, ficha)"
                + "values (?, ?, ?, ?)";

        try {
            PreparedStatement stm = DAO.conexao.prepareStatement(query);

            stm.setInt(1, getNextId("tarefa", "id_tarefa"));
            stm.setString(2, tarefa.getDescricao());
            stm.setInt(3, 0);
            stm.setString(4, tarefa.getFicha());

            stm.execute();

            JOptionPane.showMessageDialog(null, "Gravação realizada com sucesso");

            Commit();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            RollBack();
        }
    }

    public void alteraTarefa() {
    }

    public void deletaTarefa() {
    }

    public void pesquisaTarefa() {
    }

    private Integer getNextId(String tableName, String id) throws SQLException {
        ResultSet rs = executeQuery("SELECT MAX(" + id + ") from " + tableName);
        rs.next();
        Object result = rs.getObject(1);

        if (result == null) {
            rs.close();
            return 1;
        } else {
            return (Integer) result + 1;
        }
    }

    private ResultSet executeQuery(String query, Object... params) throws SQLException {
        PreparedStatement ps = getStatement(query);

        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }

        return ps.executeQuery();
    }

    private PreparedStatement getStatement(String st) throws SQLException {
        return DAO.conexao.prepareStatement(st);
    }

    private void Commit() {
        try {
            DAO.conexao.commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void RollBack() {
        try {
            DAO.conexao.rollback();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
