package br.com.diario.forms;

import br.com.diario.bean.AnalistaBean;
import br.com.diario.control.LoginControl;
import globalproject.generic.Funcoes;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JDialog;

public class Login extends JDialog {

    private AnalistaBean analistaBean;
    private LoginControl loginControl;

    public Login(AnalistaBean analista) {
        analistaBean = analista;
        setModal(true);
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        textSenha = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        textLogin = new javax.swing.JTextField();
        btnOk = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlImagem = new javax.swing.JPanel() {

            @Override
            public void paintComponent(Graphics g) {
                try {
                    super.paintComponent(g);
                    Graphics2D g2 = (Graphics2D) g;
                    InputStream imgStream = getClass().getResourceAsStream("diario.png");
                    BufferedImage image = ImageIO.read(imgStream);
                    int x = (this.getWidth() - image.getWidth(null)) / 2;
                    int y = (this.getHeight() - image.getHeight(null)) / 2;
                    g2.drawImage(image, x, y, pnlImagem);
                } catch (Exception ex) {
                }
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Diário de Bordo");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Senha.:");

        textSenha.setBackground(new java.awt.Color(255, 255, 153));
        textSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textSenhaKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Login.:");

        textLogin.setBackground(new java.awt.Color(255, 255, 153));
        textLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textLoginKeyPressed(evt);
            }
        });

        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/diario/forms/icones/opts_24.png"))); // NOI18N
        btnOk.setPreferredSize(new java.awt.Dimension(75, 23));
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/diario/forms/icones/redo_24.png"))); // NOI18N
        btnCancelar.setPreferredSize(new java.awt.Dimension(75, 23));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlImagemLayout = new javax.swing.GroupLayout(pnlImagem);
        pnlImagem.setLayout(pnlImagemLayout);
        pnlImagemLayout.setHorizontalGroup(
            pnlImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );
        pnlImagemLayout.setVerticalGroup(
            pnlImagemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 346, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textSenha)
                    .addComponent(textLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 162, Short.MAX_VALUE)
                .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(pnlImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlImagem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(textLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(textSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textSenhaKeyPressed

        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            btnOk.doClick();
        }
		}//GEN-LAST:event_textSenhaKeyPressed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        System.exit(0);
		}//GEN-LAST:event_btnCancelarActionPerformed

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed

        try {
            analistaBean.setNome(textLogin.getText().toUpperCase());
            analistaBean.setSenha("" + textSenha.getPassword());
            loginControl = new LoginControl();
            loginControl.buscaAnalista(analistaBean);
            dispose();
        } catch (Exception ex) {
            Funcoes.alerta(this, ex.getMessage());
            textLogin.requestFocus();
            textLogin.selectAll();
            textSenha.setText("");
        }
		}//GEN-LAST:event_btnOkActionPerformed

    private void textLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textLoginKeyPressed
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            textSenha.requestFocus();
        }
		}//GEN-LAST:event_textLoginKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel pnlImagem;
    private javax.swing.JTextField textLogin;
    private javax.swing.JPasswordField textSenha;
    // End of variables declaration//GEN-END:variables
}
