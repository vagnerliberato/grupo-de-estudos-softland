package br.com.diario.forms;

import br.com.diario.bean.TarefaBean;
import br.com.diario.control.TarefaControl;
import globalproject.generic.Funcoes;
import java.util.Scanner;
import javax.swing.JDialog;

public class EditTarefa extends JDialog {

    private TarefaBean tarefaBean;
    private final String ACAO;

    public EditTarefa(TarefaBean tarefaBean, String acao) {
        this.tarefaBean = tarefaBean;
        this.ACAO = acao;
        setModal(true);
        initComponents();
        preencheCampos();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        areaDescricao = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaObs = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        textFicha = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnGravar = new javax.swing.JButton();
        btnAbortar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Edição de tarefa");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel1.setText("Descrição:");

        areaDescricao.setColumns(20);
        areaDescricao.setLineWrap(true);
        areaDescricao.setRows(5);
        jScrollPane3.setViewportView(areaDescricao);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Obsevações:");

        areaObs.setColumns(20);
        areaObs.setLineWrap(true);
        areaObs.setRows(5);
        jScrollPane1.setViewportView(areaObs);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel3.setText("Ficha:");

        textFicha.setBackground(new java.awt.Color(255, 255, 204));
        textFicha.setForeground(new java.awt.Color(153, 0, 0));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/diario/forms/icones/save_24.png"))); // NOI18N
        btnGravar.setText("Grava");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnAbortar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/diario/forms/icones/close_24.png"))); // NOI18N
        btnAbortar.setText("Aborta");
        btnAbortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbortarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE)
                .addComponent(btnAbortar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGravar)
                    .addComponent(btnAbortar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                            .addComponent(textFicha, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textFicha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void preencheCampos() {
        areaDescricao.setText(tarefaBean.getDescricao());
        areaObs.setText(tarefaBean.getObservacao());
        textFicha.setText("" + tarefaBean.getFicha());
    }

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed

        Scanner scan = new Scanner(areaDescricao.getText());
        tarefaBean.setDescricao("");
        while (scan.hasNext()) {
            if (tarefaBean.getDescricao().isEmpty()) {
                tarefaBean.setDescricao(scan.nextLine());
            } else {
                tarefaBean.setDescricao("" + tarefaBean.getDescricao().concat(" " + scan.nextLine()));
            }
        }

        scan = new Scanner(areaObs.getText());
        tarefaBean.setObservacao("");
        while (scan.hasNext()) {
            if (tarefaBean.getObservacao().isEmpty()) {
                tarefaBean.setObservacao(scan.nextLine());
            } else {
                tarefaBean.setObservacao("" + tarefaBean.getObservacao().concat(" " + scan.nextLine()));
            }
        }

        if (textFicha.getText().isEmpty()) {
            tarefaBean.setFicha(0);
        } else {
            tarefaBean.setFicha(Integer.parseInt(textFicha.getText()));
        }

        try {
            TarefaControl control = new TarefaControl();

            if (ACAO.equals("CADASTRAR")) {
                tarefaBean.setHoraInicio(Funcoes.getHoraAtual());
                control.cadastraTarefa(tarefaBean);
                Funcoes.alerta(this, "Tarefa cadastrada com suscesso!");
            } else if (ACAO.equals("ALTERAR")) {
                control.alteraTarefa(tarefaBean);
                Funcoes.alerta(this, "Tarefa alterada com suscesso!");
            }

            dispose();
        } catch (Exception ex) {
            Funcoes.alerta(this, ex.getMessage());
        }
}//GEN-LAST:event_btnGravarActionPerformed

    private void btnAbortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbortarActionPerformed
        this.dispose();
}//GEN-LAST:event_btnAbortarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaDescricao;
    private javax.swing.JTextArea areaObs;
    private javax.swing.JButton btnAbortar;
    private javax.swing.JButton btnGravar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField textFicha;
    // End of variables declaration//GEN-END:variables
}
