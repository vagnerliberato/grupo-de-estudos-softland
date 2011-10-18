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
        btnFecharDia = new javax.swing.JButton();
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

        btnFecharDia.setText("Fechar Dia");
        btnFecharDia.setToolTipText("Finalizar diario do dia corrente.");
        btnFecharDia.setPreferredSize(new java.awt.Dimension(73, 23));
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
        btnFechar.setPreferredSize(new java.awt.Dimension(73, 23));
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        areaObs.setColumns(20);
        areaObs.setRows(5);
        jScrollPane1.setViewportView(areaObs);

        jLabel2.setText("Observações para o diário");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnAbrirDia, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFecharDia, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFecharDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnFechar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAbrirDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
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
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbrirDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirDiaActionPerformed

        try {
            DiarioBean diario = new DiarioBean();

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

                Scanner scan = new Scanner(areaObs.getText());
                while (scan.hasNext()) {
                    if (diario.getObservacao().isEmpty()) {
                        diario.setObservacao(scan.nextLine());
                    } else {
                        diario.setObservacao("" + diario.getObservacao().concat(" " + scan.nextLine()));
                    }
                }

                diario.setDataInicio(Funcoes.getDataAtual());
                diario.setHoraInicio(Funcoes.getHoraAtual());
                diario.setAnalista(DataLocal.getAnalistaBean());

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
    private javax.swing.JTextArea areaObs;
    private javax.swing.JButton btnAbrirDia;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnFecharDia;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
