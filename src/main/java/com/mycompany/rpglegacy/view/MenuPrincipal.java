/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.rpglegacy.view;

import com.mycompany.rpglegacy.controller.BattleController;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Administrador
 */
public class MenuPrincipal extends javax.swing.JPanel {
    private BattleController controller;
    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
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

        progressoPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        progressoLabel = new javax.swing.JLabel();
        heroiSquarePanel = new javax.swing.JPanel();
        spriteHeroiPanel = new javax.swing.JPanel();
        textoPanel = new javax.swing.JPanel();
        textoLabel = new javax.swing.JLabel();
        botoesPanel = new javax.swing.JPanel();
        acao1Button = new javax.swing.JButton();
        acao2Button = new javax.swing.JButton();
        acao3Button = new javax.swing.JButton();
        voltarButton5 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(640, 480));
        setMinimumSize(new java.awt.Dimension(640, 480));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(640, 480));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        progressoPanel.setBackground(new java.awt.Color(230, 230, 230));
        progressoPanel.setMaximumSize(new java.awt.Dimension(512, 64));
        progressoPanel.setMinimumSize(new java.awt.Dimension(512, 64));
        progressoPanel.setPreferredSize(new java.awt.Dimension(512, 64));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Progresso:");

        progressoLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        progressoLabel.setText("progresso...");

        javax.swing.GroupLayout progressoPanelLayout = new javax.swing.GroupLayout(progressoPanel);
        progressoPanel.setLayout(progressoPanelLayout);
        progressoPanelLayout.setHorizontalGroup(
            progressoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(progressoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(progressoLabel)
                .addContainerGap(300, Short.MAX_VALUE))
        );
        progressoPanelLayout.setVerticalGroup(
            progressoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, progressoPanelLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(progressoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(progressoLabel)
                    .addComponent(jLabel1))
                .addGap(17, 17, 17))
        );

        add(progressoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        heroiSquarePanel.setBackground(new java.awt.Color(230, 230, 230));
        heroiSquarePanel.setMaximumSize(new java.awt.Dimension(200, 300));
        heroiSquarePanel.setMinimumSize(new java.awt.Dimension(200, 300));
        heroiSquarePanel.setName(""); // NOI18N
        heroiSquarePanel.setPreferredSize(new java.awt.Dimension(200, 300));
        heroiSquarePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        spriteHeroiPanel.setLayout(new java.awt.CardLayout());
        heroiSquarePanel.add(spriteHeroiPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 260));

        add(heroiSquarePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        textoPanel.setBackground(new java.awt.Color(220, 220, 220));
        textoPanel.setMaximumSize(new java.awt.Dimension(512, 64));
        textoPanel.setMinimumSize(new java.awt.Dimension(512, 64));
        textoPanel.setPreferredSize(new java.awt.Dimension(512, 64));

        textoLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        textoLabel.setText("texto");

        javax.swing.GroupLayout textoPanelLayout = new javax.swing.GroupLayout(textoPanel);
        textoPanel.setLayout(textoPanelLayout);
        textoPanelLayout.setHorizontalGroup(
            textoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textoPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(textoLabel)
                .addContainerGap(447, Short.MAX_VALUE))
        );
        textoPanelLayout.setVerticalGroup(
            textoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textoPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(textoLabel)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        add(textoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        botoesPanel.setBackground(new java.awt.Color(220, 220, 220));
        botoesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Escolha uma Ação", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        botoesPanel.setMaximumSize(new java.awt.Dimension(360, 300));
        botoesPanel.setMinimumSize(new java.awt.Dimension(360, 300));
        botoesPanel.setPreferredSize(new java.awt.Dimension(360, 300));

        acao1Button.setText("jButton1");
        acao1Button.setMaximumSize(new java.awt.Dimension(320, 64));
        acao1Button.setMinimumSize(new java.awt.Dimension(320, 64));
        acao1Button.setPreferredSize(new java.awt.Dimension(320, 64));
        acao1Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acao1ButtonActionPerformed(evt);
            }
        });

        acao2Button.setText("jButton1");
        acao2Button.setMaximumSize(new java.awt.Dimension(320, 64));
        acao2Button.setMinimumSize(new java.awt.Dimension(320, 64));
        acao2Button.setPreferredSize(new java.awt.Dimension(320, 64));

        acao3Button.setText("jButton1");
        acao3Button.setMaximumSize(new java.awt.Dimension(320, 64));
        acao3Button.setMinimumSize(new java.awt.Dimension(320, 64));
        acao3Button.setPreferredSize(new java.awt.Dimension(320, 64));

        javax.swing.GroupLayout botoesPanelLayout = new javax.swing.GroupLayout(botoesPanel);
        botoesPanel.setLayout(botoesPanelLayout);
        botoesPanelLayout.setHorizontalGroup(
            botoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botoesPanelLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(botoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(acao3Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acao2Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acao1Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );
        botoesPanelLayout.setVerticalGroup(
            botoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botoesPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(acao1Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(acao2Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(acao3Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        add(botoesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, -1));

        voltarButton5.setText("Menu");
        voltarButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButton5ActionPerformed(evt);
            }
        });
        add(voltarButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void acao1ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acao1ButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acao1ButtonActionPerformed

    private void voltarButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButton5ActionPerformed
        controller.abrirMenu();
    }//GEN-LAST:event_voltarButton5ActionPerformed

    public void setController(BattleController controller) {
        this.controller = controller;
    }

    public JPanel getSpriteHeroiPanel() {
        return spriteHeroiPanel;
    }
    
    public JLabel getProgressoLabel() {
        return progressoLabel;
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acao1Button;
    private javax.swing.JButton acao2Button;
    private javax.swing.JButton acao3Button;
    private javax.swing.JPanel botoesPanel;
    private javax.swing.JPanel heroiSquarePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel progressoLabel;
    private javax.swing.JPanel progressoPanel;
    private javax.swing.JPanel spriteHeroiPanel;
    private javax.swing.JLabel textoLabel;
    private javax.swing.JPanel textoPanel;
    private javax.swing.JButton voltarButton5;
    // End of variables declaration//GEN-END:variables
}
