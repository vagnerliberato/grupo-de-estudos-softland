package br.com.diario.forms;

import br.com.diario.bean.TarefaBean;
import br.com.diario.control.TarefaControl;
import globalproject.generic.Funcoes;
import javax.swing.JInternalFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Tarefa extends JInternalFrame {

    private TarefaControl tarefaControl;
    private static TarefaBean tarefaBean;

    public Tarefa() {

        initComponents();

        inicializa();

        tblTarefas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                carregaTarefa();
                atualizaCampos();
            }
        });
    }

    public void carregaTarefa() {

        tarefaBean = new TarefaBean();

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
            tarefaBean.setStatus(((String) tblTarefas.getValueAt(tblTarefas.getSelectedRow(), 5)).trim());
        }

        if (tblTarefas.getValueAt(tblTarefas.getSelectedRow(), 6) != null) {
            tarefaBean.setFicha((Integer) tblTarefas.getValueAt(tblTarefas.getSelectedRow(), 6));
        }
    }

    private void atualizaCampos() {
        areaDescricao.setText(tarefaBean.getDescricao());
        areaObs.setText(tarefaBean.getObservacao());
        lbFichaTarefa.setText("" + tarefaBean.getFicha());
    }

    private void inicializa() {
        try {
            tarefaBean = new TarefaBean();
            tarefaControl = new TarefaControl();
            Funcoes.montaTabela(tblTarefas, tarefaControl.carregaDados());
        } catch (Exception ex) {
            Funcoes.alerta(this, ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnTarefas = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTarefas = new javax.swing.JTable();
        pnBotoes = new javax.swing.JPanel();
        btnFinaliza = new javax.swing.JButton();
        btnCancela = new javax.swing.JButton();
        btnEdita = new javax.swing.JButton();
        datePesquisa = new com.toedter.calendar.JDateChooser();
        btnPesquisa = new javax.swing.JButton();
        btnExclui = new javax.swing.JButton();
        lbDiario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaObs = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaDescricao = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        lbFichaTarefa = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Tarefas");

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnTarefasLayout.setVerticalGroup(
            pnTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTarefasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnBotoes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 102)));

        btnFinaliza.setText("Finalizar");
        btnFinaliza.setPreferredSize(new java.awt.Dimension(79, 23));
        btnFinaliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizaActionPerformed(evt);
            }
        });

        btnCancela.setText("Cancelar");
        btnCancela.setPreferredSize(new java.awt.Dimension(79, 23));
        btnCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelaActionPerformed(evt);
            }
        });

        btnEdita.setText("Editar");
        btnEdita.setPreferredSize(new java.awt.Dimension(79, 23));
        btnEdita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditaActionPerformed(evt);
            }
        });

        datePesquisa.setDateFormatString("dd/MM/yyyy");

        btnPesquisa.setText("Pesquisar");
        btnPesquisa.setToolTipText("Listar as tarefas de uma determinada data");

        btnExclui.setText("Excluir");
        btnExclui.setPreferredSize(new java.awt.Dimension(79, 23));
        btnExclui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotoesLayout = new javax.swing.GroupLayout(pnBotoes);
        pnBotoes.setLayout(pnBotoesLayout);
        pnBotoesLayout.setHorizontalGroup(
            pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnFinaliza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExclui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(datePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisa)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        pnBotoesLayout.setVerticalGroup(
            pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFinaliza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancela, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExclui, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(datePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisa))
                .addContainerGap())
        );

        lbDiario.setText("dados do Diario atual");

        areaObs.setColumns(20);
        areaObs.setRows(5);
        jScrollPane1.setViewportView(areaObs);

        jLabel2.setText("Obsevações:");

        jLabel1.setText("Descrição:");

        areaDescricao.setColumns(20);
        areaDescricao.setRows(5);
        jScrollPane3.setViewportView(areaDescricao);

        jLabel3.setText("Ficha:");

        lbFichaTarefa.setForeground(new java.awt.Color(102, 0, 0));
        lbFichaTarefa.setText("ficha da tarefa");

        btnSair.setText("Sair");
        btnSair.setPreferredSize(new java.awt.Dimension(79, 23));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbFichaTarefa))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lbDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                                .addComponent(jLabel2)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(pnBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(pnTarefas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jScrollPane3))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbFichaTarefa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDiario)
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizaActionPerformed
        try {
            if (tarefaBean.getStatus().equals("PENDENTE")) {
                tarefaControl.finalizaTarefa(tarefaBean);
                inicializa();
            } else {
                Funcoes.alerta(this, "Você não pode finalizar uma tarefa que não esteja Pendente");
            }
        } catch (Exception ex) {
            Funcoes.alerta(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnFinalizaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void tblTarefasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTarefasMouseClicked
        carregaTarefa();
        atualizaCampos();
    }//GEN-LAST:event_tblTarefasMouseClicked

    private void btnCancelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelaActionPerformed
        try {
            if (tarefaBean.getStatus().equals("PENDENTE")) {
                tarefaControl.cancelaTarefa(tarefaBean);
                inicializa();
            } else {
                Funcoes.alerta(this, "Você não pode cancelar uma tarefa que não esteja Pendente");
            }
        } catch (Exception ex) {
            Funcoes.alerta(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnCancelaActionPerformed

    private void btnEditaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditaActionPerformed
        try {
            if (tarefaBean.getStatus().equals("PENDENTE")) {
                EditTarefa cad = new EditTarefa(tarefaBean);

                int x = (this.getWidth() - cad.getWidth()) / 2;
                int y = (this.getHeight() - cad.getHeight()) / 2;

                cad.setLocation(x, y);
                cad.setVisible(true);

                inicializa();
            } else {
                Funcoes.alerta(this, "Você não pode editar uma tarefa que não esteja Pendente");
            }
        } catch (Exception ex) {
            Funcoes.alerta(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnEditaActionPerformed

    private void btnExcluiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluiActionPerformed
        try {
            if (tarefaBean.getStatus().equals("PENDENTE")) {
                tarefaControl.excluiTarefa(tarefaBean.getId());
                inicializa();
            } else {
                Funcoes.alerta(this, "Você não pode excluir uma tarefa finalizada ou cancelada!");
            }
        } catch (Exception ex) {
            Funcoes.alerta(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnExcluiActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescricao;
    private javax.swing.JTextArea areaObs;
    private javax.swing.JButton btnCancela;
    private javax.swing.JButton btnEdita;
    private javax.swing.JButton btnExclui;
    private javax.swing.JButton btnFinaliza;
    private javax.swing.JButton btnPesquisa;
    private javax.swing.JButton btnSair;
    private com.toedter.calendar.JDateChooser datePesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbDiario;
    private javax.swing.JLabel lbFichaTarefa;
    private javax.swing.JPanel pnBotoes;
    private javax.swing.JPanel pnTarefas;
    private javax.swing.JTable tblTarefas;
    // End of variables declaration//GEN-END:variables
}
