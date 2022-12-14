/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.rpglegacy.view;

import com.mycompany.rpglegacy.controller.BattleController;
import javax.swing.JLabel;

/**
 *
 * @author aluno
 */
public class StatusHeroi extends javax.swing.JDialog {
    private BattleController controller;
    /**
     * Creates new form StatusHeroi
     */
    public StatusHeroi(java.awt.Frame parent, boolean modal) {
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

        nomeHeroiLabel = new javax.swing.JLabel();
        vidaTitleLabel = new javax.swing.JLabel();
        ataqueTitleLabel = new javax.swing.JLabel();
        defesaTitleLabel = new javax.swing.JLabel();
        velocidadeTitleLabel = new javax.swing.JLabel();
        levelTitleLabel = new javax.swing.JLabel();
        xpProxLvlTitleLabel = new javax.swing.JLabel();
        xpProxLvlValorLabel = new javax.swing.JLabel();
        vidaValorLabel = new javax.swing.JLabel();
        ataqueValorLabel = new javax.swing.JLabel();
        defesaValorLabel = new javax.swing.JLabel();
        velocidadeValorLabel = new javax.swing.JLabel();
        levelValorLabel = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(201, 275));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nomeHeroiLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(nomeHeroiLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 170, 20));

        vidaTitleLabel.setText("Vida:");
        getContentPane().add(vidaTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        ataqueTitleLabel.setText("Atk:");
        getContentPane().add(ataqueTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        defesaTitleLabel.setText("Def:");
        getContentPane().add(defesaTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        velocidadeTitleLabel.setText("Vel:");
        getContentPane().add(velocidadeTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        levelTitleLabel.setText("Lvl:");
        getContentPane().add(levelTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        xpProxLvlTitleLabel.setText("ProxLvl:");
        getContentPane().add(xpProxLvlTitleLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        xpProxLvlValorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        xpProxLvlValorLabel.setPreferredSize(new java.awt.Dimension(110, 17));
        getContentPane().add(xpProxLvlValorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        vidaValorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        vidaValorLabel.setPreferredSize(new java.awt.Dimension(110, 17));
        getContentPane().add(vidaValorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, -1));

        ataqueValorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ataqueValorLabel.setPreferredSize(new java.awt.Dimension(110, 17));
        getContentPane().add(ataqueValorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        defesaValorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        defesaValorLabel.setPreferredSize(new java.awt.Dimension(110, 17));
        getContentPane().add(defesaValorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        velocidadeValorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        velocidadeValorLabel.setPreferredSize(new java.awt.Dimension(110, 17));
        getContentPane().add(velocidadeValorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        levelValorLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        levelValorLabel.setPreferredSize(new java.awt.Dimension(110, 17));
        getContentPane().add(levelValorLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        controller.sairStatus();
    }//GEN-LAST:event_btnSairActionPerformed

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
            java.util.logging.Logger.getLogger(StatusHeroi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StatusHeroi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StatusHeroi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StatusHeroi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                StatusHeroi dialog = new StatusHeroi(new javax.swing.JFrame(), true);
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

    public void setController(BattleController controller) {
        this.controller = controller;
    }
    
    public JLabel getAtaqueValorLabel() {
        return ataqueValorLabel;
    }

    public JLabel getDefesaValorLabel() {
        return defesaValorLabel;
    }

    public JLabel getLevelValorLabel() {
        return levelValorLabel;
    }

    public JLabel getNomeHeroiLabel() {
        return nomeHeroiLabel;
    }

    public JLabel getVelocidadeValorLabel() {
        return velocidadeValorLabel;
    }

    public JLabel getVidaValorLabel() {
        return vidaValorLabel;
    }

    public JLabel getXpProxLvlValorLabel() {
        return xpProxLvlValorLabel;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ataqueTitleLabel;
    private javax.swing.JLabel ataqueValorLabel;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel defesaTitleLabel;
    private javax.swing.JLabel defesaValorLabel;
    private javax.swing.JLabel levelTitleLabel;
    private javax.swing.JLabel levelValorLabel;
    private javax.swing.JLabel nomeHeroiLabel;
    private javax.swing.JLabel velocidadeTitleLabel;
    private javax.swing.JLabel velocidadeValorLabel;
    private javax.swing.JLabel vidaTitleLabel;
    private javax.swing.JLabel vidaValorLabel;
    private javax.swing.JLabel xpProxLvlTitleLabel;
    private javax.swing.JLabel xpProxLvlValorLabel;
    // End of variables declaration//GEN-END:variables
}
