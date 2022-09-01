/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.rpglegacy.view;

import com.mycompany.rpglegacy.controller.RPGController;

/**
 *
 * @author aluno
 */
public class ConfirmaDelete extends javax.swing.JDialog {
    private RPGController controller;
    /**
     * Creates new form ConfirmaDelete
     */
    public ConfirmaDelete(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelaBtn = new javax.swing.JButton();
        confirmaBtn = new javax.swing.JButton();
        confirmaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(410, 147));
        setMinimumSize(new java.awt.Dimension(410, 147));
        setPreferredSize(new java.awt.Dimension(410, 147));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancelaBtn.setText("Cancelar");
        cancelaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelaBtnActionPerformed(evt);
            }
        });
        getContentPane().add(cancelaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        confirmaBtn.setText("Confirmar");
        confirmaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmaBtnActionPerformed(evt);
            }
        });
        getContentPane().add(confirmaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        confirmaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        confirmaLabel.setText("Certeza que deseja deletar esse Herói?");
        getContentPane().add(confirmaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, 290, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelaBtnActionPerformed
        controller.cancelaDeletar();
    }//GEN-LAST:event_cancelaBtnActionPerformed

    private void confirmaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmaBtnActionPerformed
        controller.confirmaDeletar();
    }//GEN-LAST:event_confirmaBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ConfirmaDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfirmaDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfirmaDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfirmaDelete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConfirmaDelete dialog = new ConfirmaDelete(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void setController(RPGController controller) {
        this.controller = controller;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelaBtn;
    private javax.swing.JButton confirmaBtn;
    private javax.swing.JLabel confirmaLabel;
    // End of variables declaration//GEN-END:variables
}
