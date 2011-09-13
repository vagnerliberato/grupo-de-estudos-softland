package diarioBordo.view;

import diarioBordo.model.DiarioDAO;
import globalproject.conect.Firebird;
import globalproject.generic.Global;
import globalproject.persist.PersistData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Diario extends javax.swing.JInternalFrame {

    public Diario() {

        initComponents();

        setSize(800, 600);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAbrirDia = new javax.swing.JButton();
        btnFecharDia = new javax.swing.JButton();
        btnListarTarefas = new javax.swing.JButton();
        dskGeral = new javax.swing.JDesktopPane();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Controle de Diarios");
        setName("intfrmDiario"); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("Controle de Diários");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(180, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAbrirDia.setText("Abrir Dia");
        btnAbrirDia.setToolTipText("Abrir diario do dia corrente");
        btnAbrirDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirDiaActionPerformed(evt);
            }
        });

        btnFecharDia.setText("Fechar Dia");
        btnFecharDia.setToolTipText("Finalizar diario do dia corrente.");

        btnListarTarefas.setText("Tarefas");
        btnListarTarefas.setToolTipText("Listar todas as tarefas");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnFecharDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAbrirDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListarTarefas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAbrirDia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFecharDia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnListarTarefas)
                .addContainerGap(181, Short.MAX_VALUE))
        );

        dskGeral.setBackground(new java.awt.Color(255, 255, 255));
        dskGeral.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dskGeral, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dskGeral, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void btnAbrirDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirDiaActionPerformed

    try {
        PersistData persist = new PersistData(Firebird.getConexao());

        DiarioDAO dao = new DiarioDAO();

        try {
            ResultSet result = persist.executeQuery(dao.diaAberto(), (new Date()));

            if (result.next()) {

                Global.alertaMsg(Diario.this, "Já existe um diario aberto para o dia " + new Date());

            } else {

                dao.getDiarioBean().setId(Global.ultimoId(Firebird.getConexao(), "DIARIO", "ID_DIARIO"));

                persist.executeCommand(
                        dao.insert(),
                        dao.getDiarioBean().getId(),
                        "teste",
                        dao.getDiarioBean().getDataInicio(),
                        dao.getDiarioBean().getDataFim(),
                        "12:00:00",
                        dao.getDiarioBean().getHoraFim(),
                        "01");
            }

        } catch (Exception ex) {
            Global.alertaMsg(Diario.this, ex.getMessage());
        }
        
    } catch (ClassNotFoundException ex) {
        Global.alertaMsg(Diario.this, ex.getMessage());
    } catch (SQLException ex) {
        Global.alertaMsg(Diario.this, ex.getMessage());
    }
}//GEN-LAST:event_btnAbrirDiaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirDia;
    private javax.swing.JButton btnFecharDia;
    private javax.swing.JButton btnListarTarefas;
    private javax.swing.JDesktopPane dskGeral;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}