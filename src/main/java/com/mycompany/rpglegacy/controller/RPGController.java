/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.controller;

import com.mycompany.rpglegacy.dao.HeroiDao;
import com.mycompany.rpglegacy.dao.InimigoDao;
import com.mycompany.rpglegacy.dao.UsuarioDao;
import com.mycompany.rpglegacy.model.Usuario;
import com.mycompany.rpglegacy.view.CriarPersonagem;
import com.mycompany.rpglegacy.view.MainFrame;
import com.mycompany.rpglegacy.view.TelaPrincipal;
import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import com.mycompany.rpglegacy.util.Telas;
import com.mycompany.rpglegacy.view.AutenticarUsuario;
import com.mycompany.rpglegacy.view.CadastrarUsuario;
import com.mycompany.rpglegacy.view.CarregarPersonagem;

/**
 *
 * @author aluno
 */
public class RPGController {
    private final MainFrame mainFrame = new MainFrame();
    private final TelaPrincipal telaPrincipal = new TelaPrincipal();
    private final CriarPersonagem criarPersonagem = new CriarPersonagem();
    private final CarregarPersonagem carregarPersonagem = new CarregarPersonagem();
    private final AutenticarUsuario autenticarUsuario = new AutenticarUsuario();
    private final CadastrarUsuario cadastrarUsuario = new CadastrarUsuario();
    
    
    private JPanel navPanel;
    private CardLayout navLayout;
    
    private Usuario usr = null;
    private Boolean isAuth = false;
    
    private final UsuarioDao usrDao = new UsuarioDao();
    private final HeroiDao hroDao = new HeroiDao();
    private final InimigoDao inmDao = new InimigoDao();
    
    public RPGController() {
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
        navPanel.add(this.telaPrincipal, Telas.TELA_PRINCIPAL);
        navPanel.add(this.criarPersonagem, Telas.CRIAR_PERSONAGEM);
        navPanel.add(this.carregarPersonagem, Telas.CARREGAR_PERSONAGEM);
        navPanel.add(this.autenticarUsuario, Telas.AUTENTICAR_USUARIO);
        navPanel.add(this.cadastrarUsuario, Telas.CADASTRAR_USUARIO);
        
        irTelaPrincipal();
    }
    
    private void setController() {
        telaPrincipal.setController(this);
        criarPersonagem.setController(this);
        carregarPersonagem.setController(this);
        autenticarUsuario.setController(this);
        cadastrarUsuario.setController(this);
    }
    
    public void irTelaPrincipal(){
        navLayout.show(navPanel, Telas.TELA_PRINCIPAL);
        telaPrincipal.confirmaAutenticacao();
    }
    public void irAutenticarUsuario(){
        navLayout.show(navPanel, Telas.AUTENTICAR_USUARIO);
//        autenticarUsuario.confirmaAutenticacao();
    }
    public void irCadastrarUsuario(){
        navLayout.show(navPanel, Telas.CADASTRAR_USUARIO);
//        cadastrarUsuario.confirmaAutenticacao();
    }
    public void irCriarPersonagem(){
        navLayout.show(navPanel, Telas.CRIAR_PERSONAGEM);
//        criarPersonagem.confirmaAutenticacao();
    }
    public void irCarregarPersonagem(){
        navLayout.show(navPanel, Telas.CARREGAR_PERSONAGEM);
//        carregarPersonagem.confirmaAutenticacao();
    }
    
    public void validaAuth(String login, String senha){
        try {
            this.isAuth = usrDao.validarLogin(login, senha);
            if(isAuth){
                this.usr = usrDao.getUsuarioPorLogin(login);
                irTelaPrincipal();
            }
        } catch (SQLException ex) {
            Logger.getLogger(RPGController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario getUsr() {
        return usr;
    }

}
