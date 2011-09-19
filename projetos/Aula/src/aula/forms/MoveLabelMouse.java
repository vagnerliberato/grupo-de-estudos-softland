/* 
 * MoveLabelMouse.java 
 * 
 * Created on 13 de Novembro de 2007, 23:46 
 */
package aula.forms;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/** 
 * 
 * @author  Paulo & Shirley 
 */
public class MoveLabelMouse extends JFrame implements MouseListener {

    private int xSel, ySel;

    public MoveLabelMouse() {
        initComponents();
    }

    private void initComponents() {

        btnBotao = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBotao.setFont(new java.awt.Font("Tahoma", 1, 36));
        btnBotao.setText("Arthemus");

        btnBotao.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        btnBotao.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {

            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(53, 53, 53).addComponent(btnBotao).addContainerGap(55, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(40, 40, 40).addComponent(btnBotao).addContainerGap(73, Short.MAX_VALUE)));

        pack();
    }

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
    }

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {

        xSel = btnBotao.getLocation().x;
        ySel = btnBotao.getLocation().y;

        btnBotao.setLocation((evt.getX() + xSel) - (btnBotao.getWidth() / 2), (evt.getY() + ySel) - (btnBotao.getHeight() / 2));

        repaint();

        xSel = evt.getX();
        ySel = evt.getY();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MoveLabelMouse().setVisible(true);
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    // Declaração de variáveis - não modifique                       
    private JButton btnBotao;
    // Fim da declaração de variáveis                     
}