/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.rpglegacy.view;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author aluno
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        this.logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png")));
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        logoLabel = new javax.swing.JLabel();
        navegacaoPanel = new javax.swing.JPanel();
        fundoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(640, 480));
        setMinimumSize(new java.awt.Dimension(640, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoLabel.setMaximumSize(new java.awt.Dimension(250, 125));
        logoLabel.setMinimumSize(new java.awt.Dimension(250, 125));
        logoLabel.setPreferredSize(new java.awt.Dimension(250, 125));
        getContentPane().add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        navegacaoPanel.setBackground(new java.awt.Color(255, 255, 255));
        navegacaoPanel.setMaximumSize(new java.awt.Dimension(640, 480));
        navegacaoPanel.setMinimumSize(new java.awt.Dimension(640, 480));
        navegacaoPanel.setOpaque(false);
        navegacaoPanel.setPreferredSize(new java.awt.Dimension(640, 480));
        navegacaoPanel.setLayout(new java.awt.CardLayout());
        getContentPane().add(navegacaoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        fundoLabel.setPreferredSize(new java.awt.Dimension(640, 480));
        getContentPane().add(fundoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    public JPanel getNavegacaoPanel() {
        return navegacaoPanel;
    }

    public JLabel getFundoLabel() {
        return fundoLabel;
    }

    public JLabel getLogoLabel() {
        return logoLabel;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fundoLabel;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JPanel navegacaoPanel;
    // End of variables declaration//GEN-END:variables
}
