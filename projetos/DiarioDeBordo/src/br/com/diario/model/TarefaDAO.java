package br.com.diario.model;

import br.com.diario.bean.TarefaBean;
import br.com.diario.main.DataLocal;
import globalproject.generic.Funcoes;
import globalproject.persist.PersistData;
import java.sql.Connection;
import java.sql.ResultSet;

public class TarefaDAO extends PersistData {

    private final String INSERT =
            "insert into tarefa (id_tarefa, descricao, horainicio, observacoes, status, ficha) values (?, ?, ?, ?, ?, ?)";
    private final String DELETE =
            "delete from tarefa where id_tarefa = ?";
    private final String UPDATE =
            "update tarefa set descricao = ?, horainicio = ?, horafim = ?, observacoes = ?, status = ?, ficha = ? where (id_tarefa = ?)";
    private final String INSERT_CONTROLE =
            "insert into controle_diario_tarefa (id_diario, id_tarefa) values (?, ?)";
    private final String DETELE_CONTROLE =
            "delete from controle_diario_tarefa where (id_diario = ?) and (id_tarefa = ?)";

    public TarefaDAO(Connection conexao) {
        super(conexao);
    }

    public ResultSet carregaTarefas() throws Exception {

        ResultSet rs;

        try {
            rs = executeQuery("select " +
                    "tr.id_tarefa, " +
                    "tr.descricao, " +
                    "tr.horainicio, " +
                    "tr.horafim, " +
                    "tr.observacoes, " +
                    " case tr.status when 1 then 'PENDENTE' when 2 then 'FINALIZADA' when 0 then 'CANCELADA' end as status, " +
                    "tr.ficha " +
                    "from tarefa tr " +
                    "inner join controle_diario_tarefa cr on (cr.id_tarefa = tr.id_tarefa) " +
                    "inner join diario d on (d.id_diario = cr.id_diario) " +
                    "where d.datainicio = ? " +
                    "and d.id_analista = ?",
                    Funcoes.getDataSQL(Funcoes.getDataAtual()),
                    DataLocal.getAnalistaBean().getId());

            return rs;

        } catch (Exception ex) {
            throw new Exception("Problemas para buscar tarefas: \n\n Erro: " + ex.getMessage());
        }
    }

    public int cadastraTarefa(TarefaBean tarefa) throws Exception {
        try {
            int id = ultimoID("TAREFA", "ID_TAREFA");

            int result = executeCommand(
                    this.INSERT,
                    id,
                    tarefa.getDescricao(),
                    tarefa.getHoraInicio(),
                    tarefa.getObservacao(),
                    tarefa.getStatus(),
                    tarefa.getFicha());

            if (result <= 0) {
                throw new Exception("Nao consegui gravar essa tarefa! \n Verifique os valores e tente novamente.");
            } else {
                return id;
            }
        } catch (Exception ex) {
            throw new Exception("Problemas para cadastrar a nova tarefa: \n\n Erro: " + ex.getMessage());
        }
    }

    public void cadastraControle(int idTarefa, int idDiario) throws Exception {
        try {
            int result = executeCommand(
                    this.INSERT_CONTROLE,
                    idDiario,
                    idTarefa);

            if (result <= 0) {
                throw new Exception("Nao consegui gravar o controle dessa tarefa! \n Verifique os valores e tente novamente.");
            }
        } catch (Exception ex) {
            throw new Exception("Problemas para incluir o controle dessa tarefa: \n\n Erro: " + ex.getMessage());
        }
    }

    public void deletaControle(int idTarefa, int idDiario) throws Exception {
        try {
            int result = executeCommand(this.DETELE_CONTROLE, idDiario, idTarefa);

            if (result <= 0) {
                throw new Exception("Nao consegui excluir o controle dessa tarefa! \n Verifique os valores e tente novamente.");
            }
        } catch (Exception ex) {
            throw new Exception("Problemas para deletar o controle dessa tarefa: \n\n Erro: " + ex.getMessage());
        }
    }

    public void atualizaTarefa(TarefaBean tarefa) throws Exception {
        try {
            int result = executeCommand(
                    this.UPDATE,
                    tarefa.getDescricao(),
                    tarefa.getHoraInicio(),
                    tarefa.getHoraFim(),
                    tarefa.getObservacao(),
                    tarefa.getStatus(),
                    tarefa.getFicha(),
                    tarefa.getId());

            if (result <= 0) {
                throw new Exception("Nao consegui atualizar essa tarefa! \n Verifique!");
            }
        } catch (Exception ex) {
            throw new Exception("Problemas para atualizar a tarefa: \n\n Erro: " + ex.getMessage());
        }
    }

    public void deletaTarefa(final int idTarefa) throws Exception {
        try {
            int result = executeCommand(this.DELETE, idTarefa);

            if (result <= 0) {
                throw new Exception("Nao consegui detelar essa tarefa! \n Verifique!");
            }
        } catch (Exception ex) {
            throw new Exception("Problemas para deletar a tarefa: \n\n Erro: " + ex.getMessage());
        }
    }
}
