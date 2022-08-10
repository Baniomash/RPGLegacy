/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.controller;

import com.mycompany.rpglegacy.dao.HeroiDao;
import com.mycompany.rpglegacy.dao.InimigoDao;
import com.mycompany.rpglegacy.dao.UsuarioDao;
import com.mycompany.rpglegacy.util.Constantes;
import com.mycompany.rpglegacy.view.CriarPersonagem;
import com.mycompany.rpglegacy.view.MainFrame;
import com.mycompany.rpglegacy.view.TelaPrincipal;
import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author aluno
 */
public class RPGController {
    private MainFrame mainFrame;
    private TelaPrincipal telaPrincipal;
    private CriarPersonagem criarPersonagem;
    
    private JPanel navPanel;
    private CardLayout navLayout;
    
    private Boolean isAuth = false;
    
    private UsuarioDao usrDao = new UsuarioDao();
    private HeroiDao hroDao = new HeroiDao();
    private InimigoDao inmDao = new InimigoDao();
    
    public RPGController(MainFrame mainFrame, TelaPrincipal telaPrincipal, CriarPersonagem criarPersonagem) {
        this.mainFrame = mainFrame;
        this.telaPrincipal = telaPrincipal;
        this.criarPersonagem = criarPersonagem;
        setMainframePanLay();
        setController();
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public TelaPrincipal getTelaPrincipal() {
        return telaPrincipal;
    }

    public CriarPersonagem getCriarPersonagem() {
        return criarPersonagem;
    }

    public Boolean getIsAuth() {
        return isAuth;
    }    
    
    public void setMainframePanLay(){
        this.navPanel = mainFrame.getNavegacaoPanel();
        this.navLayout = (CardLayout) mainFrame.getNavegacaoPanel().getLayout();
    }
    
    public void  iniciaTelas(){
        mainFrame.setVisible(true);        
        navPanel.add(this.telaPrincipal, Constantes.TELA_PRINCIPAL);
//        navPanel.add(this.criarPersonagem);
        
        irTelaInicial();
    }
    
    private void setController() {
        telaPrincipal.setController(this);
        criarPersonagem.setController(this);
    }
    
    public void irTelaInicial(){
        navLayout.show(navPanel, Constantes.TELA_PRINCIPAL);
        telaPrincipal.confirmaAutenticacao();
    }
    
    public void irTelaAutenticar(){
        
    }
    
    public void irTelaCadastrar(){
        
    }
    
    public void irTelaCriarPersonagem(){
        
    }
    
    public void validaAuth(String login, String senha){
        try {
            this.isAuth = usrDao.validarLogin(login, senha);
            if(isAuth){
                irTelaInicial();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RPGController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
