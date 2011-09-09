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

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36));
        jLabel1.setText("Arthemus");

        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {

            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(53, 53, 53).addComponent(jLabel1).addContainerGap(55, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(40, 40, 40).addComponent(jLabel1).addContainerGap(73, Short.MAX_VALUE)));

        pack();
    }

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {
    }

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {

        xSel = jLabel1.getLocation().x;
        ySel = jLabel1.getLocation().y;

        jLabel1.setLocation((evt.getX() + xSel) - (jLabel1.getWidth() / 2), (evt.getY() + ySel) - (jLabel1.getHeight() / 2));

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
    private javax.swing.JLabel jLabel1;
    // Fim da declaração de variáveis                     
}