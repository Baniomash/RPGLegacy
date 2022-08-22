/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.rpglegacy.view;

import com.mycompany.rpglegacy.controller.BattleController;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author Administrador
 */
public class HeroiSprite extends javax.swing.JPanel {
    private BattleController controller;
    /**
     * Creates new form HeroiSprite
     */
    public HeroiSprite() {
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

        jPanel1 = new javax.swing.JPanel();
        heroiProgressBar = new javax.swing.JProgressBar();
        nomeHeroiLabel = new javax.swing.JLabel();
        spriteHeroiLabel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(128, 200));
        setMinimumSize(new java.awt.Dimension(128, 200));
        setPreferredSize(new java.awt.Dimension(128, 200));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        heroiProgressBar.setForeground(new java.awt.Color(255, 0, 0));
        heroiProgressBar.setMaximum(0);
        heroiProgressBar.setToolTipText("");
        heroiProgressBar.setMaximumSize(new java.awt.Dimension(130, 20));
        heroiProgressBar.setMinimumSize(new java.awt.Dimension(130, 20));
        heroiProgressBar.setPreferredSize(new java.awt.Dimension(130, 20));
        heroiProgressBar.setString("asdasdasd");
        jPanel1.add(heroiProgressBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, -1, -1));

        nomeHeroiLabel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel1.add(nomeHeroiLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 130, 20));
        jPanel1.add(spriteHeroiLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 130, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(368, 368, 368))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public void setController(BattleController controller) {
        this.controller = controller;
    }

    public JProgressBar getHeroiProgressBar() {
        return heroiProgressBar;
    }

    public JLabel getNomeHeroiLabel() {
        return nomeHeroiLabel;
    }

    public JLabel getSpriteHeroiLabel() {
        return spriteHeroiLabel;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar heroiProgressBar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nomeHeroiLabel;
    private javax.swing.JLabel spriteHeroiLabel;
    // End of variables declaration//GEN-END:variables
}
