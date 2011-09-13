package diarioBordo.view;

import java.awt.Component;
import javax.swing.*;

public class Principal extends javax.swing.JFrame {

    public Principal() {

        //inicializa componentes da tela principal.
        initComponents();

        //configura a tela principal para exibicao em "Tela Cheia".
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        //configura um estilo para as janelas.
        setSkin(1);
    }

    private void newFrame(JInternalFrame frame) {

        Component content = getContentPane();

        int x = (content.getWidth() - frame.getWidth()) / 2;
        int y = (content.getHeight() - frame.getHeight()) / 2;

        frame.setLocation(x, y);

        dskPrincipal.add(frame);

        frame.show();
    }

    private void setSkin(int opcao) {

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
        }

        try {
            UIManager.setLookAndFeel(Skin);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (InstantiationException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }

        SwingUtilities.updateComponentTreeUI(this);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dskPrincipal = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        mMenu = new javax.swing.JMenu();
        mmDiario = new javax.swing.JMenuItem();
        mmSair = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Softland - Diario de Bordo");
        setName("framePrincipal"); // NOI18N

        dskPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        menuBar.setName("menuBar"); // NOI18N

        mMenu.setActionCommand("Menu");
        mMenu.setLabel("Menu");

        mmDiario.setText("Diario");
        mmDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmDiarioActionPerformed(evt);
            }
        });
        mMenu.add(mmDiario);

        mmSair.setText("Sair");
        mmSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmSairActionPerformed(evt);
            }
        });
        mMenu.add(mmSair);

        menuBar.add(mMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dskPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dskPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("frmPrincipal");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mmSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmSairActionPerformed
        System.exit(0);
}//GEN-LAST:event_mmSairActionPerformed

private void mmDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmDiarioActionPerformed
    newFrame(new Diario());
}//GEN-LAST:event_mmDiarioActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dskPrincipal;
    private javax.swing.JMenu mMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem mmDiario;
    private javax.swing.JMenuItem mmSair;
    // End of variables declaration//GEN-END:variables
}