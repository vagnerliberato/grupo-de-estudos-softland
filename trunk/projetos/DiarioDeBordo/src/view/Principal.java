package view;

import javax.swing.*;

public class Principal extends javax.swing.JFrame {

    String cordaBolinha;

    public Principal() throws Exception {
        initComponents();

        setLocationRelativeTo(null);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setSkin(3);
    }

    private void setSkin(int opcao) throws Exception {
        String Skin = null;

        switch (opcao) {
            case 1:
                Skin = "javax.swing.plaf.metal.MetalLookAndFeel";
                break;
            case 2:
                Skin = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
                break;
            case 3:
                Skin = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
                break;
            case 4:
                Skin = "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel";
                break;
            case 5:
                Skin = "com.jgoodies.looks.windows.WindowsLookAndFeel";
                break;
        }

        UIManager.setLookAndFeel(Skin);
        SwingUtilities.updateComponentTreeUI(this);

        /*
         * Exemplos:
         * 
         * javax.swing.plaf.metal.MetalLookAndFeel;  
         * com.sun.java.swing.plaf.motif.MotifLookAndFeel;  
         * com.sun.java.swing.plaf.windows.WindowsLookAndFeel;  
         * com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel;
         */
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar = new javax.swing.JMenuBar();
        mTabelas = new javax.swing.JMenu();
        mDiario = new javax.swing.JMenu();
        mmTarefa = new javax.swing.JMenuItem();
        mFerramentas = new javax.swing.JMenu();
        mSair = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema - Diario de Bordo - Softland");
        setName("framePrincipal"); // NOI18N

        menuBar.setName("menuBar"); // NOI18N

        mTabelas.setText("Tabelas");
        menuBar.add(mTabelas);

        mDiario.setText("Diario");

        mmTarefa.setText("Tarefas");
        mmTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmTarefaActionPerformed(evt);
            }
        });
        mDiario.add(mmTarefa);

        menuBar.add(mDiario);

        mFerramentas.setText("Ferramentas");
        menuBar.add(mFerramentas);

        mSair.setText("Sair");
        mSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSairActionPerformed(evt);
            }
        });
        menuBar.add(mSair);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 535, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 432, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("frmPrincipal");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_mSairActionPerformed

    private void mmTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmTarefaActionPerformed
        try {
            CadastroDeTarefas tarefa = new CadastroDeTarefas();
            getContentPane().add(tarefa);
            tarefa.setVisible(true);
        } catch (Exception ex) {

            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_mmTarefaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu mDiario;
    private javax.swing.JMenu mFerramentas;
    private javax.swing.JMenu mSair;
    private javax.swing.JMenu mTabelas;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mmTarefa;
    // End of variables declaration//GEN-END:variables
}
