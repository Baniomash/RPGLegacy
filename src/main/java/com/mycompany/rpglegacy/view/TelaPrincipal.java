/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.rpglegacy.view;

import com.mycompany.rpglegacy.controller.RPGController;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author aluno
 */
public class TelaPrincipal extends javax.swing.JPanel {

    private RPGController controller;

    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
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

        novoJogoButton = new javax.swing.JButton();
        carregarJogoButton = new javax.swing.JButton();
        signInButton = new javax.swing.JButton();
        usuarioPanel = new javax.swing.JPanel();
        bolinhaLabel = new javax.swing.JLabel();
        sairButton = new javax.swing.JButton();
        backgroundLabel = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(620, 440));
        setMinimumSize(new java.awt.Dimension(620, 440));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(620, 440));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        novoJogoButton.setText("NOVO JOGO");
        novoJogoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        novoJogoButton.setMaximumSize(new java.awt.Dimension(128, 32));
        novoJogoButton.setMinimumSize(new java.awt.Dimension(128, 32));
        novoJogoButton.setPreferredSize(new java.awt.Dimension(128, 32));
        novoJogoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novoJogoButtonActionPerformed(evt);
            }
        });
        add(novoJogoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 210, -1, -1));

        carregarJogoButton.setText("CARREGAR");
        carregarJogoButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        carregarJogoButton.setMaximumSize(new java.awt.Dimension(128, 32));
        carregarJogoButton.setMinimumSize(new java.awt.Dimension(128, 32));
        carregarJogoButton.setPreferredSize(new java.awt.Dimension(128, 32));
        carregarJogoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarJogoButtonActionPerformed(evt);
            }
        });
        add(carregarJogoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, -1, -1));

        signInButton.setText("SIGN IN");
        signInButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        signInButton.setMaximumSize(new java.awt.Dimension(128, 32));
        signInButton.setMinimumSize(new java.awt.Dimension(128, 32));
        signInButton.setPreferredSize(new java.awt.Dimension(128, 32));
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });
        add(signInButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 360, -1, -1));

        usuarioPanel.setBackground(new java.awt.Color(220, 220, 220));
        usuarioPanel.setMaximumSize(new java.awt.Dimension(256, 64));
        usuarioPanel.setMinimumSize(new java.awt.Dimension(256, 64));
        usuarioPanel.setOpaque(false);
        usuarioPanel.setPreferredSize(new java.awt.Dimension(256, 64));
        usuarioPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bolinhaLabel.setFont(new java.awt.Font("Cantarell", 1, 24)); // NOI18N
        bolinhaLabel.setForeground(new java.awt.Color(255, 255, 255));
        bolinhaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bolinhaLabel.setText("USUARIO");
        bolinhaLabel.setMaximumSize(new java.awt.Dimension(128, 30));
        bolinhaLabel.setMinimumSize(new java.awt.Dimension(128, 30));
        bolinhaLabel.setPreferredSize(new java.awt.Dimension(128, 30));
        usuarioPanel.add(bolinhaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        add(usuarioPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, -1, -1));

        sairButton.setText("SAIR");
        sairButton.setMaximumSize(new java.awt.Dimension(128, 32));
        sairButton.setMinimumSize(new java.awt.Dimension(128, 32));
        sairButton.setPreferredSize(new java.awt.Dimension(128, 32));
        sairButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairButtonActionPerformed(evt);
            }
        });
        add(sairButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, -1, -1));

        backgroundLabel.setMaximumSize(new java.awt.Dimension(286, 320));
        backgroundLabel.setMinimumSize(new java.awt.Dimension(286, 320));
        backgroundLabel.setPreferredSize(new java.awt.Dimension(286, 320));
        add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInButtonActionPerformed
        controller.irAutenticarUsuario();
    }//GEN-LAST:event_signInButtonActionPerformed

    private void carregarJogoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarJogoButtonActionPerformed
        controller.irCarregarPersonagem();
    }//GEN-LAST:event_carregarJogoButtonActionPerformed

    private void novoJogoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novoJogoButtonActionPerformed
        controller.irCriarPersonagem();
    }//GEN-LAST:event_novoJogoButtonActionPerformed

    private void sairButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairButtonActionPerformed
        controller.sairJogo();
    }//GEN-LAST:event_sairButtonActionPerformed

    public void setController(RPGController controller) {
        this.controller = controller;
    }

    public void confirmaAutenticacao() {
        if (controller.getIsAuth()) {
            this.signInButton.setVisible(false);
            this.usuarioPanel.setVisible(true);
            this.bolinhaLabel.setText(controller.getUsr().getLogin());
            this.carregarJogoButton.setVisible(true);
            this.novoJogoButton.setVisible(true);
            this.backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/usuario_board.png")));
        } else {
            this.signInButton.setVisible(true);
            this.usuarioPanel.setVisible(false);
            this.bolinhaLabel.setText("USUARIO");
            this.carregarJogoButton.setVisible(false);
            this.novoJogoButton.setVisible(false);
            this.backgroundLabel.setIcon(null);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel bolinhaLabel;
    private javax.swing.JButton carregarJogoButton;
    private javax.swing.JButton novoJogoButton;
    private javax.swing.JButton sairButton;
    private javax.swing.JButton signInButton;
    private javax.swing.JPanel usuarioPanel;
    // End of variables declaration//GEN-END:variables
}
