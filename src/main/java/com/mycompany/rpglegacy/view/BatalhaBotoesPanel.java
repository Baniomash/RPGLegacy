/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.rpglegacy.view;

import com.mycompany.rpglegacy.controller.BattleController;
import com.mycompany.rpglegacy.util.Batalha;

/**
 *
 * @author aluno
 */
public class BatalhaBotoesPanel extends javax.swing.JPanel {
    private BattleController controller;
    
    /**
     * Creates new form batalhaBotoesPanel
     */
    public BatalhaBotoesPanel() {
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

        atkButton = new javax.swing.JButton();
        defenderButton = new javax.swing.JButton();
        seRenderButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(620, 70));
        setMinimumSize(new java.awt.Dimension(620, 70));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(620, 70));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        atkButton.setText("Atacar");
        atkButton.setMaximumSize(new java.awt.Dimension(128, 64));
        atkButton.setMinimumSize(new java.awt.Dimension(128, 64));
        atkButton.setPreferredSize(new java.awt.Dimension(128, 64));
        atkButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atkButtonActionPerformed(evt);
            }
        });
        add(atkButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 5, -1, -1));

        defenderButton.setText("Defender");
        defenderButton.setMaximumSize(new java.awt.Dimension(128, 64));
        defenderButton.setMinimumSize(new java.awt.Dimension(128, 64));
        defenderButton.setPreferredSize(new java.awt.Dimension(128, 64));
        defenderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defenderButtonActionPerformed(evt);
            }
        });
        add(defenderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 5, -1, -1));

        seRenderButton.setText("Se Render");
        seRenderButton.setMaximumSize(new java.awt.Dimension(128, 64));
        seRenderButton.setMinimumSize(new java.awt.Dimension(128, 64));
        seRenderButton.setPreferredSize(new java.awt.Dimension(128, 64));
        seRenderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seRenderButtonActionPerformed(evt);
            }
        });
        add(seRenderButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(379, 5, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void atkButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atkButtonActionPerformed
        controller.heroiAtaca();
    }//GEN-LAST:event_atkButtonActionPerformed

    private void defenderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defenderButtonActionPerformed
        controller.heroiDefende();
    }//GEN-LAST:event_defenderButtonActionPerformed

    private void seRenderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seRenderButtonActionPerformed
        controller.heroiDesiste();
    }//GEN-LAST:event_seRenderButtonActionPerformed

    public void setController(BattleController controller) {
        this.controller = controller;
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atkButton;
    private javax.swing.JButton defenderButton;
    private javax.swing.JButton seRenderButton;
    // End of variables declaration//GEN-END:variables
}
