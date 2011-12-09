package br.com.diario.forms;

import java.awt.Component;
import java.awt.Image;
import javax.swing.*;

public class Principal extends JFrame {

    private Image imagem;

    public Principal() {

        //inicializa componentes da tela principal.
        initComponents();

        //configura a tela principal para exibicao em "Tela Cheia".
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        //colocar tela principal no centro da Tela.
        setLocationRelativeTo(null);
    }

    private void NewFrame(JInternalFrame frame) {

        boolean jaExiste = false;

        JInternalFrame[] listaFrames = dskPrincipal.getAllFrames();

        for (int iCount = 0; iCount < listaFrames.length; iCount++) {

            if (listaFrames[iCount].getClass() == frame.getClass()) {
                jaExiste = true;
                break;
            }
        }

        if (!jaExiste) {

            Component content = getContentPane();

            int x = (content.getWidth() - frame.getWidth()) / 2;

            int y = (content.getHeight() - frame.getHeight()) / 2;

            frame.setLocation(x, y);

            dskPrincipal.add(frame);

            frame.show();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dskPrincipal = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnTarefa = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lbListagem = new javax.swing.JLabel();
        btnTarefa1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnTarefa2 = new javax.swing.JButton();
        btnListagem = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Diário de Bordo");
        setName("framePrincipal"); // NOI18N

        dskPrincipal.setBackground(new java.awt.Color(255, 255, 204));
        dskPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder("Piloto"));
        dskPrincipal.setPreferredSize(new java.awt.Dimension(100, 100));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.blue)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Tarefas");

        btnTarefa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/diario/forms/icones/notep_24.png"))); // NOI18N
        btnTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarefaActionPerformed(evt);
            }
        });

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/diario/forms/icones/redo_24.png"))); // NOI18N
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        lbListagem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbListagem.setText("Listagens");

        btnTarefa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/diario/forms/icones/new_24.png"))); // NOI18N
        btnTarefa1.setFocusPainted(false);
        btnTarefa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarefa1ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Diário");

        btnTarefa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/diario/forms/icones/cal_24.png"))); // NOI18N
        btnTarefa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarefa2ActionPerformed(evt);
            }
        });

        btnListagem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/diario/forms/icones/chart_24.png"))); // NOI18N
        btnListagem.setEnabled(false);
        btnListagem.setFocusPainted(false);
        btnListagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListagemActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nova Tarefa");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(btnTarefa, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(jLabel4)
                    .addComponent(btnTarefa1, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(lbListagem)
                    .addComponent(btnListagem, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(btnTarefa2, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTarefa2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTarefa)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTarefa1)
                .addGap(18, 18, 18)
                .addComponent(lbListagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dskPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dskPrincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("frmPrincipal");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarefaActionPerformed
        NewFrame(new Tarefa());
    }//GEN-LAST:event_btnTarefaActionPerformed

    private void btnTarefa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarefa1ActionPerformed
        NewFrame(new CadTarefa());
    }//GEN-LAST:event_btnTarefa1ActionPerformed

    private void btnTarefa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarefa2ActionPerformed
        NewFrame(new Diario());
    }//GEN-LAST:event_btnTarefa2ActionPerformed

    private void btnListagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnListagemActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListagem;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTarefa;
    private javax.swing.JButton btnTarefa1;
    private javax.swing.JButton btnTarefa2;
    private javax.swing.JDesktopPane dskPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbListagem;
    // End of variables declaration//GEN-END:variables
}
