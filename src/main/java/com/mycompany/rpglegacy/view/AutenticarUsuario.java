/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.rpglegacy.view;

import com.mycompany.rpglegacy.controller.RPGController;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Windows10
 */
public class AutenticarUsuario extends javax.swing.JPanel {
    RPGController controller;
    /**
     * Creates new form AutenticarUsuario
     */
    public AutenticarUsuario() {
        initComponents();
        this.backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/wooden_board.png")));
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
        loginLabel = new javax.swing.JLabel();
        loginTextField = new javax.swing.JTextField();
        logarButton = new javax.swing.JButton();
        signUpButton = new javax.swing.JButton();
        erroLabel = new javax.swing.JLabel();
        senhaPassField = new javax.swing.JPasswordField();
        backgroundLabel = new javax.swing.JLabel();
        voltarButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(640, 480));
        setMinimumSize(new java.awt.Dimension(640, 480));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(640, 480));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(220, 220, 220));
        jPanel1.setMaximumSize(new java.awt.Dimension(300, 300));
        jPanel1.setMinimumSize(new java.awt.Dimension(300, 300));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 300));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginLabel.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        loginLabel.setText("LOGIN");
        jPanel1.add(loginLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

        loginTextField.setToolTipText("Digite o seu Login");
        loginTextField.setMaximumSize(new java.awt.Dimension(200, 32));
        loginTextField.setMinimumSize(new java.awt.Dimension(200, 32));
        loginTextField.setPreferredSize(new java.awt.Dimension(200, 32));
        loginTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginTextFieldActionPerformed(evt);
            }
        });
        jPanel1.add(loginTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        logarButton.setText("SIGN IN");
        logarButton.setMaximumSize(new java.awt.Dimension(90, 32));
        logarButton.setMinimumSize(new java.awt.Dimension(90, 32));
        logarButton.setPreferredSize(new java.awt.Dimension(90, 32));
        logarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(logarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        signUpButton.setText("SIGN UP");
        signUpButton.setMaximumSize(new java.awt.Dimension(90, 32));
        signUpButton.setMinimumSize(new java.awt.Dimension(90, 32));
        signUpButton.setPreferredSize(new java.awt.Dimension(90, 32));
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });
        jPanel1.add(signUpButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        erroLabel.setForeground(new java.awt.Color(255, 0, 0));
        erroLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(erroLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 256, 15));

        senhaPassField.setToolTipText("Digite sua senha");
        senhaPassField.setMaximumSize(new java.awt.Dimension(200, 32));
        senhaPassField.setMinimumSize(new java.awt.Dimension(200, 32));
        senhaPassField.setPreferredSize(new java.awt.Dimension(200, 32));
        senhaPassField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaPassFieldActionPerformed(evt);
            }
        });
        jPanel1.add(senhaPassField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, -1));

        backgroundLabel.setMaximumSize(new java.awt.Dimension(300, 300));
        backgroundLabel.setMinimumSize(new java.awt.Dimension(300, 300));
        backgroundLabel.setPreferredSize(new java.awt.Dimension(300, 300));
        jPanel1.add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        voltarButton.setText("Voltar");
        voltarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarButtonActionPerformed(evt);
            }
        });
        add(voltarButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        controller.irCadastrarUsuario();
    }//GEN-LAST:event_signUpButtonActionPerformed

    private void voltarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarButtonActionPerformed
        controller.irTelaPrincipal();
    }//GEN-LAST:event_voltarButtonActionPerformed

    private void logarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logarButtonActionPerformed
        controller.autenticarUsuario();
    }//GEN-LAST:event_logarButtonActionPerformed

    private void loginTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginTextFieldActionPerformed
        controller.autenticarUsuario();
    }//GEN-LAST:event_loginTextFieldActionPerformed

    private void senhaPassFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaPassFieldActionPerformed
        controller.autenticarUsuario();
    }//GEN-LAST:event_senhaPassFieldActionPerformed

    public JButton getLogarButton() {
        return logarButton;
    }

    public JTextField getLoginTextField() {
        return loginTextField;
    }

    public JPasswordField getSenhaPassField() {
        return senhaPassField;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public JButton getVoltarButton() {
        return voltarButton;
    }

    public JLabel getErroLabel() {
        return erroLabel;
    }
    
    public void setController(RPGController controller) {
        this.controller = controller;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel erroLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logarButton;
    private javax.swing.JLabel loginLabel;
    private javax.swing.JTextField loginTextField;
    private javax.swing.JPasswordField senhaPassField;
    private javax.swing.JButton signUpButton;
    private javax.swing.JButton voltarButton;
    // End of variables declaration//GEN-END:variables
}
