package diarioBordo.view;

import diarioBordo.bean.TarefaBean;
import diarioBordo.control.TarefaControl;
import globalproject.generic.Funcoes;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Arthemus
 */
public class TarefaFrame extends JInternalFrame {

    private TarefaControl tarefaControl;
    private static TarefaBean tarefaBean;

    public TarefaFrame() {

        initComponents();

        tarefaBean = new TarefaBean();
        
        atualizaDados();
        
        try {
            Funcoes.montaTabela(tblTarefas, tarefaControl.carregaDados());
        } catch (Exception ex) {
            Logger.getLogger(TarefaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        tblTarefas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {

                if (evt.getValueIsAdjusting()) {
                    return;
                }

                tarefaBean = new TarefaBean();
                carregaTarefa();
                atualizaCampos();
            }
        });
    }

    private void atualizaDados() {
        try {
            tarefaControl = new TarefaControl();
        } catch (Exception ex) {
            Funcoes.alerta(this, ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTarefas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTarefas = new javax.swing.JTable();
        pnDados = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaObs = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        lbFichaTarefa = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbStatusTarefa = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaDescricao = new javax.swing.JTextArea();
        pnDiario = new javax.swing.JPanel();
        lbDiario = new javax.swing.JLabel();
        pnBotoes = new javax.swing.JPanel();
        btnIncluir = new javax.swing.JButton();
        btnFinaliza = new javax.swing.JButton();
        btnCancela = new javax.swing.JButton();
        btnTranca = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnAbortar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cadastro de tarefas");

        pnTarefas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnTarefas.setAutoscrolls(true);

        tblTarefas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblTarefas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTarefasMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblTarefas);

        javax.swing.GroupLayout pnTarefasLayout = new javax.swing.GroupLayout(pnTarefas);
        pnTarefas.setLayout(pnTarefasLayout);
        pnTarefasLayout.setHorizontalGroup(
            pnTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTarefasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnTarefasLayout.setVerticalGroup(
            pnTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnTarefasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnDados.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnDados.setAutoscrolls(true);
        pnDados.setPreferredSize(new java.awt.Dimension(580, 200));

        jLabel1.setText("Descrição:");

        jLabel2.setText("Obsevações:");

        areaObs.setColumns(20);
        areaObs.setRows(5);
        jScrollPane1.setViewportView(areaObs);

        jLabel3.setText("Ficha:");

        lbFichaTarefa.setText("ficha da tarefa");

        jLabel5.setText("Status:");

        lbStatusTarefa.setText("status da tarefa");

        areaDescricao.setColumns(20);
        areaDescricao.setRows(5);
        jScrollPane3.setViewportView(areaDescricao);

        javax.swing.GroupLayout pnDadosLayout = new javax.swing.GroupLayout(pnDados);
        pnDados.setLayout(pnDadosLayout);
        pnDadosLayout.setHorizontalGroup(
            pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addGroup(pnDadosLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel1))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                    .addGroup(pnDadosLayout.createSequentialGroup()
                        .addComponent(lbFichaTarefa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 266, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbStatusTarefa)))
                .addContainerGap())
        );
        pnDadosLayout.setVerticalGroup(
            pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDadosLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lbFichaTarefa))
                        .addContainerGap())
                    .addGroup(pnDadosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(lbStatusTarefa))
                        .addContainerGap())))
        );

        pnDiario.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbDiario.setText("dados do Diario atual");

        javax.swing.GroupLayout pnDiarioLayout = new javax.swing.GroupLayout(pnDiario);
        pnDiario.setLayout(pnDiarioLayout);
        pnDiarioLayout.setHorizontalGroup(
            pnDiarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDiarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDiario)
                .addContainerGap(452, Short.MAX_VALUE))
        );
        pnDiarioLayout.setVerticalGroup(
            pnDiarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDiarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbDiario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnBotoes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 102)));

        btnIncluir.setText("Nova Tarefa");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnFinaliza.setText("Finalizar");
        btnFinaliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizaActionPerformed(evt);
            }
        });

        btnCancela.setText("Cancelar");

        btnTranca.setText("Trancar");

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnAbortar.setText("Abortar");
        btnAbortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbortarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotoesLayout = new javax.swing.GroupLayout(pnBotoes);
        pnBotoes.setLayout(pnBotoesLayout);
        pnBotoesLayout.setHorizontalGroup(
            pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFinaliza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTranca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbortar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addContainerGap())
        );
        pnBotoesLayout.setVerticalGroup(
            pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnIncluir)
                    .addGroup(pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFinaliza)
                        .addComponent(btnCancela)
                        .addComponent(btnTranca)
                        .addComponent(btnGravar)
                        .addComponent(btnAbortar)
                        .addComponent(btnSair)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnDados, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                    .addComponent(pnTarefas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnDiario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnBotoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnTarefas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnDados, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnDiario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        limpaCampos();
        areaDescricao.setFocusable(true);
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnFinalizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFinalizaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void tblTarefasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTarefasMouseClicked
        tarefaBean = new TarefaBean();
        carregaTarefa();
        atualizaCampos();
    }//GEN-LAST:event_tblTarefasMouseClicked

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed

        try {
            Scanner scan = new Scanner(areaDescricao.getText());

            while (scan.hasNext()) {
                String linha = scan.nextLine();

                if (tarefaBean.getDescricao().isEmpty()) {
                    tarefaBean.setDescricao(linha);
                } else {
                    linha = tarefaBean.getDescricao() + " " + linha;
                    tarefaBean.setDescricao(linha);
                }
            }

            scan = new Scanner(areaObs.getText());

            while (scan.hasNext()) {
                String linha = scan.nextLine();

                if (tarefaBean.getObservacao().isEmpty()) {
                    tarefaBean.setObservacao(linha);
                } else {
                    linha = tarefaBean.getObservacao() + " " + linha;
                    tarefaBean.setObservacao(linha);
                }
            }

            scan.close();

            tarefaBean.setHoraInicio(Funcoes.getHoraAtual());

            tblTarefas = new JTable();
            
            Funcoes.montaTabela(tblTarefas, tarefaControl.carregaDados());
            
            tarefaControl.cadastraTarefa(tarefaBean);
            
            atualizaCampos();
            
            pack();
            
        } catch (Exception ex) {
            Funcoes.alerta(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnAbortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbortarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAbortarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescricao;
    private javax.swing.JTextArea areaObs;
    private javax.swing.JButton btnAbortar;
    private javax.swing.JButton btnCancela;
    private javax.swing.JButton btnFinaliza;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTranca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbDiario;
    private javax.swing.JLabel lbFichaTarefa;
    private javax.swing.JLabel lbStatusTarefa;
    private javax.swing.JPanel pnBotoes;
    private javax.swing.JPanel pnDados;
    private javax.swing.JPanel pnDiario;
    private javax.swing.JPanel pnTarefas;
    private javax.swing.JTable tblTarefas;
    // End of variables declaration//GEN-END:variables

    public void carregaTarefa() {

        if (tblTarefas.getValueAt(tblTarefas.getSelectedRow(), 0) != null) {
            tarefaBean.setId((Integer) tblTarefas.getValueAt(tblTarefas.getSelectedRow(), 0));
        }

        if (tblTarefas.getValueAt(tblTarefas.getSelectedRow(), 1) != null) {
            tarefaBean.setDescricao((String) tblTarefas.getValueAt(tblTarefas.getSelectedRow(), 1));
        }

        if (tblTarefas.getValueAt(tblTarefas.getSelectedRow(), 2) != null) {
            tarefaBean.setHoraInicio((String) tblTarefas.getValueAt(tblTarefas.getSelectedRow(), 2));
        }

        if (tblTarefas.getValueAt(tblTarefas.getSelectedRow(), 3) != null) {
            tarefaBean.setHoraFim((String) tblTarefas.getValueAt(tblTarefas.getSelectedRow(), 3));
        }

        if (tblTarefas.getValueAt(tblTarefas.getSelectedRow(), 4) != null) {
            tarefaBean.setObservacao((String) tblTarefas.getValueAt(tblTarefas.getSelectedRow(), 4));
        }

        if (tblTarefas.getValueAt(tblTarefas.getSelectedRow(), 5) != null) {
            tarefaBean.setStatus((Integer) tblTarefas.getValueAt(tblTarefas.getSelectedRow(), 5));
        }

        if (tblTarefas.getValueAt(tblTarefas.getSelectedRow(), 6) != null) {
            tarefaBean.setFicha((Integer) tblTarefas.getValueAt(tblTarefas.getSelectedRow(), 6));
        }
    }

    public void atualizaCampos() {
        areaDescricao.setText(tarefaBean.getDescricao());
        areaObs.setText(tarefaBean.getObservacao());
        lbFichaTarefa.setText("" + tarefaBean.getFicha());
        lbStatusTarefa.setText("" + tarefaBean.getStatus());
    }

    private void limpaCampos() {
        areaDescricao.setText("");
        areaObs.setText("");
        lbFichaTarefa.setText("");
        lbStatusTarefa.setText("");
    }
}
