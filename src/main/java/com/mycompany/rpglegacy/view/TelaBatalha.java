/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.rpglegacy.view;

import com.mycompany.rpglegacy.controller.BattleController;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Administrador
 */
public class TelaBatalha extends javax.swing.JPanel {
    private BattleController controller;
    private String qualInimigo;
    /**
     * Creates new form Batalha
     */
    public TelaBatalha() {
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

        voltarButton5 = new javax.swing.JButton();
        adversarioSquarePanel = new javax.swing.JPanel();
        spriteAdversarioPanel = new javax.swing.JPanel();
        heroiSquarePanel = new javax.swing.JPanel();
        spriteHeroiPanel = new javax.swing.JPanel();
        infoPanel = new javax.swing.JPanel();
        infoLabel = new javax.swing.JLabel();
        statusPanel = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(640, 480));
        setMinimumSize(new java.awt.Dimension(640, 480));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(640, 480));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        voltarButton5.setBackground(new java.awt.Color(0, 0, 255));
        voltarButton5.setForeground(new java.awt.Color(255, 255, 255));
        voltarButton5.setText("Menu");
        voltarButton5.setPreferredSize(new java.awt.Dimension(100, 50));
        voltarButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButton5ActionPerformed(evt);
            }
        });
        add(voltarButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        adversarioSquarePanel.setBackground(new java.awt.Color(230, 230, 230));
        adversarioSquarePanel.setMaximumSize(new java.awt.Dimension(300, 300));
        adversarioSquarePanel.setMinimumSize(new java.awt.Dimension(300, 300));
        adversarioSquarePanel.setName(""); // NOI18N
        adversarioSquarePanel.setOpaque(false);
        adversarioSquarePanel.setPreferredSize(new java.awt.Dimension(300, 300));

        spriteAdversarioPanel.setOpaque(false);
        spriteAdversarioPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout adversarioSquarePanelLayout = new javax.swing.GroupLayout(adversarioSquarePanel);
        adversarioSquarePanel.setLayout(adversarioSquarePanelLayout);
        adversarioSquarePanelLayout.setHorizontalGroup(
            adversarioSquarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adversarioSquarePanelLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(spriteAdversarioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        adversarioSquarePanelLayout.setVerticalGroup(
            adversarioSquarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adversarioSquarePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spriteAdversarioPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        add(adversarioSquarePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 240, 190, 230));

        heroiSquarePanel.setBackground(new java.awt.Color(230, 230, 230));
        heroiSquarePanel.setMaximumSize(new java.awt.Dimension(200, 300));
        heroiSquarePanel.setMinimumSize(new java.awt.Dimension(200, 300));
        heroiSquarePanel.setName(""); // NOI18N
        heroiSquarePanel.setOpaque(false);
        heroiSquarePanel.setPreferredSize(new java.awt.Dimension(200, 300));

        spriteHeroiPanel.setOpaque(false);
        spriteHeroiPanel.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout heroiSquarePanelLayout = new javax.swing.GroupLayout(heroiSquarePanel);
        heroiSquarePanel.setLayout(heroiSquarePanelLayout);
        heroiSquarePanelLayout.setHorizontalGroup(
            heroiSquarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(heroiSquarePanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(spriteHeroiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        heroiSquarePanelLayout.setVerticalGroup(
            heroiSquarePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, heroiSquarePanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(spriteHeroiPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        add(heroiSquarePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, 230));

        infoPanel.setBackground(new java.awt.Color(220, 220, 220));
        infoPanel.setMaximumSize(new java.awt.Dimension(512, 64));
        infoPanel.setMinimumSize(new java.awt.Dimension(512, 64));
        infoPanel.setOpaque(false);
        infoPanel.setPreferredSize(new java.awt.Dimension(512, 64));

        infoLabel.setBackground(new Color(0,51,255, 50));
        infoLabel.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        infoLabel.setForeground(new java.awt.Color(255, 255, 255));
        infoLabel.setText("jLabel1");
        infoLabel.setOpaque(true);

        javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
        infoPanel.setLayout(infoPanelLayout);
        infoPanelLayout.setHorizontalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(infoLabel)
                .addContainerGap(227, Short.MAX_VALUE))
        );
        infoPanelLayout.setVerticalGroup(
            infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(infoPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(infoLabel)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        add(infoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(109, 6, -1, 50));

        statusPanel.setBackground(new Color(0,51,255, 50));
        statusPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        statusPanel.setMaximumSize(new java.awt.Dimension(620, 70));
        statusPanel.setMinimumSize(new java.awt.Dimension(620, 70));
        statusPanel.setPreferredSize(new java.awt.Dimension(620, 70));
        statusPanel.setLayout(new java.awt.CardLayout());
        add(statusPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void voltarButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButton5ActionPerformed
        controller.abrirMenu();
    }//GEN-LAST:event_voltarButton5ActionPerformed

    public void setController(BattleController controller) {
        this.controller = controller;
    }

    public JPanel getSpriteHeroiPanel() {
        return spriteHeroiPanel;
    }

    public void setQualInimigo(String qualInimigo) {
        this.qualInimigo = qualInimigo;
    }

    public JLabel getInfoLabel() {
        return infoLabel;
    }

    public String getQualInimigo() {
        return qualInimigo;
    }

    public JPanel getSpriteAdversarioPanel() {
        return spriteAdversarioPanel;
    }

    public JPanel getStatusPanel() {
        return statusPanel;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel adversarioSquarePanel;
    private javax.swing.JPanel heroiSquarePanel;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JPanel infoPanel;
    private javax.swing.JPanel spriteAdversarioPanel;
    private javax.swing.JPanel spriteHeroiPanel;
    private javax.swing.JPanel statusPanel;
    private javax.swing.JButton voltarButton5;
    // End of variables declaration//GEN-END:variables
}
