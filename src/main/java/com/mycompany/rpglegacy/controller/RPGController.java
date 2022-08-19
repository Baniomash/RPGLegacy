/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.controller;

import com.mycompany.rpglegacy.dao.HeroiDao;
import com.mycompany.rpglegacy.dao.InimigoDao;
import com.mycompany.rpglegacy.dao.UsuarioDao;
import com.mycompany.rpglegacy.model.Heroi;
import com.mycompany.rpglegacy.model.Usuario;
import com.mycompany.rpglegacy.util.Outros;
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
import java.util.ArrayList;
import java.util.List;

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
    private BattleController btController;
    
    
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
        navPanel.add(this.carregarPersonagem, Telas.CARREGAR_PERSONAGEM);
        
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
        navPanel.add(this.autenticarUsuario, Telas.AUTENTICAR_USUARIO);
        navLayout.show(navPanel, Telas.AUTENTICAR_USUARIO);
//        autenticarUsuario.confirmaAutenticacao();
    }
    public void sairAutenticarUsuario(){
        navPanel.remove(this.autenticarUsuario);
    }
    public void irCadastrarUsuario(){
        navPanel.add(this.cadastrarUsuario, Telas.CADASTRAR_USUARIO);
        navLayout.show(navPanel, Telas.CADASTRAR_USUARIO);
//        cadastrarUsuario.confirmaAutenticacao();
    }
    public void sairCadastrarUsuario(){
        navPanel.remove(this.cadastrarUsuario);
    }
    public void irCriarPersonagem(){
        navPanel.add(this.criarPersonagem, Telas.CRIAR_PERSONAGEM);
        navLayout.show(navPanel, Telas.CRIAR_PERSONAGEM);
//        criarPersonagem.confirmaAutenticacao();
    }
    public void sairCriarPersonagem(){
        navPanel.remove(this.criarPersonagem);
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
            }else{
                erroNoLogin(Outros.ERRO_CREDENCIAIS_ERRADAS);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RPGController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void criarUsuario(String login, String senha){
        try {
            usrDao.criar(new Usuario(login, senha));
        } catch (SQLException ex) {
            Logger.getLogger(RPGController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public void criarHeroi(String personName, int atak, int defe, int sped, int vidaMaxima, Usuario usuario){
        try {
            hroDao.criar(new Heroi(personName, atak, defe, sped, vidaMaxima, usuario));
        } catch (SQLException ex) {
            Logger.getLogger(RPGController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Heroi> carregarHerois(int id){
        try {
            return new ArrayList(this.hroDao.getHeroisPorIdUsuario(id));
        } catch (SQLException ex) {
            Logger.getLogger(RPGController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList();
    }
    
    public void atualizaListaHerois(){
        
    }
    
    public void iniciarJogo(int IdHeroi){
        mainFrame.setVisible(false);
        mainFrame.dispose();
        btController = new BattleController(this);
        btController.setHeroiUsuario(IdHeroi);
        btController.iniciaTelas();
    }
    
    
    public Usuario getUsr() {
        return usr;
    }

    public void autenticarUsuario() {
        String login = this.autenticarUsuario.getLoginTextField().getText();
        String senha = String.valueOf(this.autenticarUsuario.getSenhaPassField().getPassword());
        if(!"".equals(login) && !"".equals(senha)){
            validaAuth(login, senha);
        } else {
            erroNoLogin(Outros.ERRO_NAO_PREENCHIDO);
        }
    }

    private void erroNoLogin(String erroTipo) {
        switch(erroTipo){
            case Outros.ERRO_NAO_PREENCHIDO:
                this.autenticarUsuario.getErroLabel().setText(erroTipo);
                break;
            case Outros.ERRO_CREDENCIAIS_ERRADAS:
                this.autenticarUsuario.getErroLabel().setText(erroTipo);
                break;
        }
    }
    
    private void erroNoCadastro(String erroTipo) {
        switch(erroTipo){
            case Outros.ERRO_NAO_PREENCHIDO:
                this.cadastrarUsuario.getErroLabel().setText(erroTipo);
                break;
            case Outros.ERRO_CREDENCIAIS_ERRADAS:
                this.cadastrarUsuario.getErroLabel().setText(erroTipo);
                break;
        }
    }

    public void cadastrarUsuario() {
        String login = this.cadastrarUsuario.getCadastroTextField().getText();
        String senha = String.valueOf(this.cadastrarUsuario.getSenhaPassField().getPassword());
        if(!"".equals(login) && !"".equals(senha)){
            criarUsuario(login, senha);
            irAutenticarUsuario();
        } else {
            erroNoCadastro(Outros.ERRO_NAO_PREENCHIDO);
        }
    }
    
    public void atualizaStatusNovoHeroi(){
        String classe = String.valueOf(this.criarPersonagem.getClasseComboBox().getSelectedItem());
        switch(classe){
            case Outros.CAVALEIRO:
                    this.criarPersonagem.getVidaValorLabel().setText("80");
                    this.criarPersonagem.getAtkValorLabel().setText("08");
                    this.criarPersonagem.getDefValorLabel().setText("08");
                    this.criarPersonagem.getSpdValorLabel().setText("08");
                break;
            case Outros.BARBARO:
                    this.criarPersonagem.getVidaValorLabel().setText("120");
                    this.criarPersonagem.getAtkValorLabel().setText("12");
                    this.criarPersonagem.getDefValorLabel().setText("06");
                    this.criarPersonagem.getSpdValorLabel().setText("06");
                break;
            case Outros.PALADINO:
                    this.criarPersonagem.getVidaValorLabel().setText("80");
                    this.criarPersonagem.getAtkValorLabel().setText("06");
                    this.criarPersonagem.getDefValorLabel().setText("12");
                    this.criarPersonagem.getSpdValorLabel().setText("06");
                break;
        }
    }
    
    public void novoHeroi(){
        String personName = this.criarPersonagem.getNomeHeroiTextField().getText();
        int vidaMaxima = Integer.parseInt(this.criarPersonagem.getVidaValorLabel().getText());
        int atak = Integer.parseInt(this.criarPersonagem.getAtkValorLabel().getText());
        int defe = Integer.parseInt(this.criarPersonagem.getDefValorLabel().getText());
        int sped = Integer.parseInt(this.criarPersonagem.getSpdValorLabel().getText());
        if(!"".equals(personName)){
            criarHeroi(personName, atak, defe, sped, vidaMaxima, this.usr);
            this.irCarregarPersonagem();
        }
    }
    
//    cavaleiro (32) (8*10)080 - 08 - 08 - 08
//    barbaro   (32) (8*15)120 - 12 - 06 - 06
//    paladino  (32) (8*10)080 - 06 - 12 - 06
    
}
