package br.com.diario.model;

import br.com.diario.bean.AnalistaBean;
import globalproject.persist.PersistData;
import java.sql.Connection;
import java.sql.ResultSet;

public class LoginDAO extends PersistData {

    public LoginDAO(Connection conexao) {
        super(conexao);
    }

    public void buscaAnalista(AnalistaBean analista) throws Exception {
        try {
            String query = "select codigo, descricao, analista_pass from analista where descricao = ?";

            ResultSet result = executeQuery(query, analista.getNome());

            if (result.next()) {
                analista.setId(result.getString("CODIGO"));
            } else {
                throw new Exception("Analista " + analista.getNome() + " não encontrado");
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
