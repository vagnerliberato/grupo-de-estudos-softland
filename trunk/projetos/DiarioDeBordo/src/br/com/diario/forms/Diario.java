package br.com.diario.forms;

import br.com.diario.bean.DiarioBean;
import br.com.diario.main.DataLocal;
import br.com.diario.model.DiarioDAO;
import globalproject.generic.Funcoes;
import java.sql.SQLException;
import java.util.Date;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnFecharDia = new javax.swing.JButton();
        btnAbrirDia = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Controle de Diários");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36));
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Diários");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnFecharDia.setText("Fechar Dia");
        btnFecharDia.setToolTipText("Finalizar diario do dia corrente.");
        btnFecharDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharDiaActionPerformed(evt);
            }
        });

        btnAbrirDia.setText("Abrir Dia");
        btnAbrirDia.setToolTipText("Criar um novo diário para o dia corrente");
        btnAbrirDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirDiaActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.setToolTipText("Fechar janela");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAbrirDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(171, 171, 171))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(btnFecharDia)
                .addContainerGap(86, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAbrirDia, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnFecharDia, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirDiaActionPerformed

        try {
            diarioDao.setDiarioBean(new DiarioBean());

            if (diarioDao.isDiaAberto(Funcoes.getDataAtual())) {

                if (!diarioDao.isValidaAberturaFechamento(Funcoes.getDataAtual())) {
                    Funcoes.alerta(this, "O diario de hoje ja foi fechado!");
                } else {
                    Funcoes.alerta(this, "Ja existe um diario aberto para o dia " + Funcoes.getDataString(Funcoes.getDataAtual()));
                }
            } else if (JOptionPane.showConfirmDialog(this,
                    "Ainda nao foi criado um diario para o dia " + Funcoes.getDataString(Funcoes.getDataAtual()) + ". \n\n Deseja criar ?",
                    "Novo Diario",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                diarioDao.getDiarioBean().setDataInicio(Funcoes.getDataAtual());
                diarioDao.getDiarioBean().setHoraInicio(Funcoes.getHoraAtual());
                diarioDao.getDiarioBean().setAnalista(DataLocal.getAnalistaBean());

                int result = diarioDao.abrirNovoDia();

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

    private void btnFecharDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharDiaActionPerformed

        Date dData = Funcoes.getDataAtual();

        try {
            if ((diarioDao.isDiaAberto(dData)) && (diarioDao.isValidaAberturaFechamento(dData))) {
                if (JOptionPane.showConfirmDialog(this,
                        "Confirma o fechamento de seu diario para o dia " + Funcoes.getDataString(dData),
                        "Fechamento",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    int result = diarioDao.fecharDia(dData);

                    if (result > 0) {
                        Funcoes.alerta(this, "Di�rio fechado com sucesso, ate amanha!");
                    } else {
                        Funcoes.alerta(this, "Ocorreu algum problema, verifique...");
                    }
                }
            } else {
                Funcoes.alerta(this, "Nao existe um diario aberto para o dia " + Funcoes.getDataString(dData));
            }
        } catch (Exception ex) {
            Funcoes.alerta(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnFecharDiaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirDia;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnFecharDia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
