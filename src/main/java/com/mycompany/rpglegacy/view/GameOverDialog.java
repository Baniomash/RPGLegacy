/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */

package com.mycompany.rpglegacy.view;

import com.mycompany.rpglegacy.controller.BattleController;
import com.mycompany.rpglegacy.util.Sprites;

/**
 *
 * @author aluno
 */
public class GameOverDialog extends javax.swing.JDialog {
    private BattleController controller;
    /** Creates new form VictoryDialog */
    public GameOverDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.heroiSpriteLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(Sprites.SPRITE_HEROI_DERROTA)));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        vitoriaPanel = new javax.swing.JPanel();
        vitoriaLabel = new javax.swing.JLabel();
        continuarButton = new javax.swing.JButton();
        spriteHeroiPanel = new javax.swing.JPanel();
        heroiSpriteLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vitoriaPanel.setBackground(new java.awt.Color(204, 0, 0));
        vitoriaPanel.setMaximumSize(new java.awt.Dimension(300, 64));
        vitoriaPanel.setMinimumSize(new java.awt.Dimension(300, 64));
        vitoriaPanel.setPreferredSize(new java.awt.Dimension(300, 64));

        vitoriaLabel.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        vitoriaLabel.setForeground(new java.awt.Color(255, 255, 255));
        vitoriaLabel.setText("GAME OVER!!!");

        javax.swing.GroupLayout vitoriaPanelLayout = new javax.swing.GroupLayout(vitoriaPanel);
        vitoriaPanel.setLayout(vitoriaPanelLayout);
        vitoriaPanelLayout.setHorizontalGroup(
            vitoriaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, vitoriaPanelLayout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addComponent(vitoriaLabel)
                .addGap(139, 139, 139))
        );
        vitoriaPanelLayout.setVerticalGroup(
            vitoriaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(vitoriaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(vitoriaLabel)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        getContentPane().add(vitoriaPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 40));

        continuarButton.setText("SAIR");
        continuarButton.setMaximumSize(new java.awt.Dimension(90, 48));
        continuarButton.setMinimumSize(new java.awt.Dimension(90, 48));
        continuarButton.setPreferredSize(new java.awt.Dimension(90, 48));
        continuarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarButtonActionPerformed(evt);
            }
        });
        getContentPane().add(continuarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, -1, -1));

        spriteHeroiPanel.setBackground(new java.awt.Color(255, 51, 51));
        spriteHeroiPanel.setMaximumSize(new java.awt.Dimension(256, 32));
        spriteHeroiPanel.setMinimumSize(new java.awt.Dimension(256, 32));
        spriteHeroiPanel.setPreferredSize(new java.awt.Dimension(256, 32));
        spriteHeroiPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        heroiSpriteLabel.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        spriteHeroiPanel.add(heroiSpriteLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 230, 230));

        getContentPane().add(spriteHeroiPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 380, 260));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void continuarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarButtonActionPerformed
        controller.sairGameOver();
    }//GEN-LAST:event_continuarButtonActionPerformed

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
            java.util.logging.Logger.getLogger(GameOverDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameOverDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameOverDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameOverDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GameOverDialog dialog = new GameOverDialog(new javax.swing.JFrame(), true);
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continuarButton;
    private javax.swing.JLabel heroiSpriteLabel;
    private javax.swing.JPanel spriteHeroiPanel;
    private javax.swing.JLabel vitoriaLabel;
    private javax.swing.JPanel vitoriaPanel;
    // End of variables declaration//GEN-END:variables

}
