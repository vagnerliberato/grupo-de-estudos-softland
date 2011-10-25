package br.com.diario.forms;

import br.com.diario.bean.DiarioBean;
import br.com.diario.main.DataLocal;
import br.com.diario.model.DiarioDAO;
import globalproject.generic.Funcoes;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class Diario extends JInternalFrame {
    
    private DiarioDAO diarioDao = null;
    
    public Diario() {
        
        initComponents();
        
        try {
            diarioDao = new DiarioDAO(DataLocal.conexaoSingleton());
        } catch (ClassNotFoundException ex) {
            Funcoes.alerta(null, ex.getMessage());
        } catch (SQLException ex) {
            Funcoes.alerta(null, ex.getMessage());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        btnAbrirDia = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaObs = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Controle de Diários");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAbrirDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/diario/forms/icones/about_24.png"))); // NOI18N
        btnAbrirDia.setText("Abrir Dia");
        btnAbrirDia.setToolTipText("Criar um novo diário para o dia corrente");
        btnAbrirDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirDiaActionPerformed(evt);
            }
        });

        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/diario/forms/icones/redo_16.png"))); // NOI18N
        btnFechar.setToolTipText("Fechar janela");
        btnFechar.setPreferredSize(new java.awt.Dimension(73, 23));
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        areaObs.setColumns(20);
        areaObs.setLineWrap(true);
        areaObs.setRows(5);
        jScrollPane1.setViewportView(areaObs);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        jLabel2.setText("Observações para o diário");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAbrirDia)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAbrirDia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirDiaActionPerformed
        
        try {
            DiarioBean diario = new DiarioBean();
            
            if (diarioDao.isDiaAberto(Funcoes.getDataAtual())) {
                Funcoes.alerta(this, "Ja existe um diario aberto para o dia " + Funcoes.getDataString(Funcoes.getDataAtual()));
            } else if (JOptionPane.showConfirmDialog(this,
                    "Ainda nao foi criado um diario para o dia " + Funcoes.getDataString(Funcoes.getDataAtual()) + ". \n\n Deseja criar ?",
                    "Novo Diario",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                
                Scanner scan = new Scanner(areaObs.getText());
                while (scan.hasNext()) {
                    if (diario.getObservacao().isEmpty()) {
                        diario.setObservacao(scan.nextLine());
                    } else {
                        diario.setObservacao("" + diario.getObservacao().concat(" " + scan.nextLine()));
                    }
                }
                
                diario.setHora(Funcoes.getHora(new Date()));
                
                int result = diarioDao.abrirNovoDia(diario);
                
                if (result > 0) {
                    Funcoes.alerta(this, "Beleza, seu diario foi criado com sucesso!");
                } else {
                    Funcoes.alerta(this, "Ocorreu algum problema, verifique...");
                }
            }
        } catch (Exception ex) {
            Funcoes.alerta(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnAbrirDiaActionPerformed
    
    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        dispose();
    }//GEN-LAST:event_btnFecharActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaObs;
    private javax.swing.JButton btnAbrirDia;
    private javax.swing.JButton btnFechar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
