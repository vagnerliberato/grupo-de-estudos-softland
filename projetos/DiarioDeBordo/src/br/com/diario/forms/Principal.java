package br.com.diario.forms;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.PlasticXPLookAndFeel;
import com.jgoodies.looks.windows.WindowsLookAndFeel;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
import globalproject.generic.Funcoes;
import java.awt.Component;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.synth.SynthLookAndFeel;

public class Principal extends JFrame {

    public Principal() {

        //inicializa componentes da tela principal.
        initComponents();

        //configura a tela principal para exibicao em "Tela Cheia".
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        //colocar tela principal no centro da Tela.
        setLocationRelativeTo(null);

        //configura um estilo para as janelas.
        SetSkin(1);
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

    private void SetSkin(int opcao) {
        try {
            LookAndFeel Look = null;

            switch (opcao) {
                case 1:
                    Look = new MetalLookAndFeel();
                    break;
                case 2:
                    Look = new MotifLookAndFeel();
                    break;
                case 3:
                    Look = new WindowsLookAndFeel();
                    break;
                case 4:
                    Look = new WindowsClassicLookAndFeel();
                    break;
                case 5:
                    Look = new Plastic3DLookAndFeel();
                    break;
                case 6:
                    Look = new NimbusLookAndFeel();
                    break;
                case 7:
                    Look = new PlasticLookAndFeel();
                    break;
                case 8:
                    Look = new PlasticXPLookAndFeel();
                    break;
                case 9:
                    Look = new SynthLookAndFeel();
                    break;
            }

            UIManager.setLookAndFeel(Look);
            SwingUtilities.updateComponentTreeUI(this);

        } catch (UnsupportedLookAndFeelException ex) {
            Funcoes.alerta(this, ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dskPrincipal = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnTarefa = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnTarefa1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnTarefa2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Softland - Diario de Bordo");
        setName("framePrincipal"); // NOI18N

        dskPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder("Piloto"));
        dskPrincipal.setPreferredSize(new java.awt.Dimension(100, 100));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.Color.blue)); // NOI18N

        jLabel1.setText("Tarefas");

        btnTarefa.setText("TAREFAS");
        btnTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarefaActionPerformed(evt);
            }
        });

        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        jLabel2.setText("Nova Tarefa");

        btnTarefa1.setText("NOVA TAREFA");
        btnTarefa1.setFocusPainted(false);
        btnTarefa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarefa1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Diario");

        btnTarefa2.setText("DIARIO");
        btnTarefa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarefa2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(btnTarefa1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(btnTarefa, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                    .addComponent(btnTarefa2, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))
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
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTarefa1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 164, Short.MAX_VALUE)
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
                .addComponent(dskPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dskPrincipal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTarefa;
    private javax.swing.JButton btnTarefa1;
    private javax.swing.JButton btnTarefa2;
    private javax.swing.JDesktopPane dskPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
