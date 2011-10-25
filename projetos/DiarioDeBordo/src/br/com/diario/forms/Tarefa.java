package br.com.diario.forms;

import br.com.diario.bean.DiarioBean;
import br.com.diario.bean.TarefaBean;
import br.com.diario.control.DiarioControl;
import br.com.diario.control.TarefaControl;
import globalproject.generic.Funcoes;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Tarefa extends JInternalFrame {

    private TarefaControl tarefaControl;
    private TarefaBean tarefaBean;
    private DiarioBean diarioBean;

    public Tarefa() {

        initComponents();

        inicializa();

        carregaDiarioDoDia();

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

    private void carregaDiarioDoDia() {
        try {
            diarioBean = new DiarioBean();
            DiarioControl control = new DiarioControl();
            control.getDiarioAtual(diarioBean);
            lbDiario.setText("Diário aberto em "
                    + Funcoes.getDataString(diarioBean.getData())
                    + " as " + diarioBean.getHora()
                    + " pelo analista " + diarioBean.getAnalista().getNome());
        } catch (Exception ex) {
            Funcoes.alerta(this, ex.getMessage());
            dispose();
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
        btnExclui = new javax.swing.JButton();
        btnNovaTarefa = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
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
        lbObservacoes = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 656, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnTarefasLayout.setVerticalGroup(
            pnTarefasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnTarefasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnBotoes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 102, 102)));

        btnFinaliza.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/diario/forms/icones/go_24.png"))); // NOI18N
        btnFinaliza.setToolTipText("Finalizar a tarefa escolhida");
        btnFinaliza.setPreferredSize(new java.awt.Dimension(79, 23));
        btnFinaliza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizaActionPerformed(evt);
            }
        });

        btnCancela.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/diario/forms/icones/remov_24.png"))); // NOI18N
        btnCancela.setToolTipText("Cancelar a tarefa escolhida");
        btnCancela.setPreferredSize(new java.awt.Dimension(79, 23));
        btnCancela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelaActionPerformed(evt);
            }
        });

        btnEdita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/diario/forms/icones/edit_24.png"))); // NOI18N
        btnEdita.setToolTipText("Editar o conteudo da tarefa");
        btnEdita.setPreferredSize(new java.awt.Dimension(79, 23));
        btnEdita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditaActionPerformed(evt);
            }
        });

        datePesquisa.setDateFormatString("dd/MM/yyyy");

        btnExclui.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/diario/forms/icones/close_24.png"))); // NOI18N
        btnExclui.setToolTipText("Excluir a tarefa escolhida");
        btnExclui.setPreferredSize(new java.awt.Dimension(79, 23));
        btnExclui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluiActionPerformed(evt);
            }
        });

        btnNovaTarefa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/diario/forms/icones/add_24.png"))); // NOI18N
        btnNovaTarefa.setToolTipText("Criar uma nova tarefa");
        btnNovaTarefa.setPreferredSize(new java.awt.Dimension(79, 23));
        btnNovaTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaTarefaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel4.setText("Inclui");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel5.setText("Cancela");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel6.setText("Edita");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel7.setText("Exclui");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel8.setText("Finaliza");

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/diario/forms/icones/zoomi_16.png"))); // NOI18N
        btnPesquisar.setToolTipText("Pesquisar tarefas pela data escolhida");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBotoesLayout = new javax.swing.GroupLayout(pnBotoes);
        pnBotoes.setLayout(pnBotoesLayout);
        pnBotoesLayout.setHorizontalGroup(
            pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnNovaTarefa, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCancela, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnEdita, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnExclui, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnFinaliza, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
                .addGroup(pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnPesquisar)
                    .addComponent(datePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        pnBotoesLayout.setVerticalGroup(
            pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBotoesLayout.createSequentialGroup()
                .addGroup(pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBotoesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNovaTarefa, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(btnCancela, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(btnEdita, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(btnExclui, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                            .addComponent(btnFinaliza, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(pnBotoesLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(datePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar)))
                .addContainerGap())
        );

        lbDiario.setFont(new java.awt.Font("Tahoma", 1, 12));
        lbDiario.setForeground(new java.awt.Color(153, 153, 255));
        lbDiario.setText("dados do Diario atual");

        areaObs.setColumns(20);
        areaObs.setLineWrap(true);
        areaObs.setRows(5);
        jScrollPane1.setViewportView(areaObs);

        jLabel2.setText("Obsevações:");

        jLabel1.setText("Descrição:");

        areaDescricao.setColumns(20);
        areaDescricao.setLineWrap(true);
        areaDescricao.setRows(5);
        jScrollPane3.setViewportView(areaDescricao);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Ficha:");

        lbFichaTarefa.setFont(new java.awt.Font("Tahoma", 1, 12));
        lbFichaTarefa.setForeground(new java.awt.Color(102, 0, 0));
        lbFichaTarefa.setText("ficha da tarefa");

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/diario/forms/icones/redo_24.png"))); // NOI18N
        btnSair.setToolTipText("Fechar janela");
        btnSair.setPreferredSize(new java.awt.Dimension(79, 23));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lbObservacoes.setFont(new java.awt.Font("Tahoma", 1, 11));
        lbObservacoes.setForeground(new java.awt.Color(102, 0, 0));
        lbObservacoes.setText("<html><u>Observações</u></html>");
        lbObservacoes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbObservacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbObservacoesMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnTarefas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnBotoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbFichaTarefa))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lbDiario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbObservacoes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))))
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
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lbFichaTarefa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbDiario)
                            .addComponent(lbObservacoes)))
                    .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

                EditTarefa cad = new EditTarefa(tarefaBean, "ALTERAR");

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

    private void btnNovaTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaTarefaActionPerformed
        try {
            tarefaBean = new TarefaBean();

            EditTarefa cad = new EditTarefa(tarefaBean, "CADASTRAR");

            int x = (this.getWidth() - cad.getWidth()) / 2;
            int y = (this.getHeight() - cad.getHeight()) / 2;

            cad.setLocation(x, y);
            cad.setVisible(true);

            inicializa();
        } catch (Exception ex) {
            Funcoes.alerta(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnNovaTarefaActionPerformed

    private void lbObservacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbObservacoesMouseClicked
        JDialog dialog = new JDialog();
        JScrollPane scroll = new JScrollPane();
        JTextArea areaObsDiario = new JTextArea();
        scroll = new javax.swing.JScrollPane();
        areaObsDiario = new javax.swing.JTextArea();
        dialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        dialog.setTitle("Observações do diário");
        areaObsDiario.setText(diarioBean.getObservacao());
        dialog.setModal(true);
        dialog.getContentPane().setLayout(new java.awt.GridLayout(1, 1));
        areaObsDiario.setBackground(new java.awt.Color(255, 255, 153));
        areaObsDiario.setColumns(20);
        areaObsDiario.setRows(5);
        dialog.setSize(500, 300);
        scroll.setViewportView(areaObsDiario);
        dialog.getContentPane().add(scroll);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        dialog.setResizable(true);
        dialog.pack();
    }//GEN-LAST:event_lbObservacoesMouseClicked

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        try {
            tarefaBean = new TarefaBean();
            tarefaControl = new TarefaControl();
            Funcoes.montaTabela(tblTarefas, tarefaControl.carregaDados(datePesquisa.getDate()));
        } catch (Exception ex) {
            Funcoes.alerta(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescricao;
    private javax.swing.JTextArea areaObs;
    private javax.swing.JButton btnCancela;
    private javax.swing.JButton btnEdita;
    private javax.swing.JButton btnExclui;
    private javax.swing.JButton btnFinaliza;
    private javax.swing.JButton btnNovaTarefa;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private com.toedter.calendar.JDateChooser datePesquisa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbDiario;
    private javax.swing.JLabel lbFichaTarefa;
    private javax.swing.JLabel lbObservacoes;
    private javax.swing.JPanel pnBotoes;
    private javax.swing.JPanel pnTarefas;
    private javax.swing.JTable tblTarefas;
    // End of variables declaration//GEN-END:variables
}