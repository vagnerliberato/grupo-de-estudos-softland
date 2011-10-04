package diarioBordo.view;

import java.awt.Component;
import javax.swing.*;

public class PrincipalFrame extends JFrame {

    public PrincipalFrame() {

        //inicializa componentes da tela principal.
        initComponents();

        //configura a tela principal para exibicao em "Tela Cheia".
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        
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
        jPanel1 = new javax.swing.JPanel();
        btnDia = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnTarefa = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btnListagem = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Softland - Diario de Bordo");
        setName("framePrincipal"); // NOI18N

        dskPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        dskPrincipal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Piloto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.blue));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Controle", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, java.awt.Color.blue));

        btnDia.setText("DIA");
        btnDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiaActionPerformed(evt);
            }
        });

        jLabel2.setText("Dia");

        jLabel1.setText("Tarefas");

        btnTarefa.setText("TAREFAS");
        btnTarefa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarefaActionPerformed(evt);
            }
        });

        jLabel3.setText("Listagem");

        btnListagem.setText("LISTAGEM");

        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnListagem, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(btnTarefa, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(jLabel2)
                    .addComponent(btnDia, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(btnSair, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDia)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTarefa)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListagem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 356, Short.MAX_VALUE)
                .addComponent(btnSair)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dskPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dskPrincipal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("frmPrincipal");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiaActionPerformed
        NewFrame(new DiarioFrame());
    }//GEN-LAST:event_btnDiaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnTarefaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarefaActionPerformed
        NewFrame(new TarefaFrame());
    }//GEN-LAST:event_btnTarefaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDia;
    private javax.swing.JButton btnListagem;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnTarefa;
    private javax.swing.JDesktopPane dskPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
