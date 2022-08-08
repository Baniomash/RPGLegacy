/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.controller;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author aluno
 */
public class RPGController {
    private JFrame MainFrame;
    private JPanel TelaPrincipal;
    private JPanel CriarPersonagem;

    public RPGController(JFrame MainFrame, JPanel TelaPrincipal, JPanel CriarPanel) {
        this.MainFrame = MainFrame;
        this.TelaPrincipal = TelaPrincipal;
        this.CriarPersonagem = CriarPanel;
    }

    public JFrame getMainFrame() {
        return MainFrame;
    }

    public JPanel getTelaPrincipal() {
        return TelaPrincipal;
    }

    public JPanel getCriarPersonagem() {
        return CriarPersonagem;
    }
    
    
    public void  iniciaTelas(){
        
    }
    
    public void irTelaAutenticar(){
        
    }
    
    public void irTelaCadastrar(){
        
    }
    
    public void irTelaCriarPanel(){
        
    }
}
