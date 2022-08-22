/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.controller;

import com.mycompany.rpglegacy.dao.HeroiDao;
import com.mycompany.rpglegacy.dao.InimigoDao;
import com.mycompany.rpglegacy.model.Battle;
import com.mycompany.rpglegacy.model.Heroi;
import com.mycompany.rpglegacy.model.Monstro;
import com.mycompany.rpglegacy.model.Vilao;
import com.mycompany.rpglegacy.util.Batalha;
import com.mycompany.rpglegacy.util.Outros;
import com.mycompany.rpglegacy.util.Telas;
import com.mycompany.rpglegacy.view.HeroiSprite;
import com.mycompany.rpglegacy.view.MainFrame;
import com.mycompany.rpglegacy.view.MenuBatalha;
import com.mycompany.rpglegacy.view.MenuPrincipal;
import com.mycompany.rpglegacy.view.TelaBatalha;
import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author aluno
 */
public class BattleController {

    private RPGController mainController;
    private Battle batalha;
    private Heroi heroiUsuario;
    private HeroiDao hroDao = new HeroiDao();
    private InimigoDao inmDao = new InimigoDao();

    private MainFrame mainFrame;
    private MenuPrincipal menuPrincipal = new MenuPrincipal();
    private TelaBatalha telaBatalha = new TelaBatalha();
    private MenuBatalha menuBatalha = new MenuBatalha(mainFrame, true);
    private HeroiSprite heroiSprite = new HeroiSprite();

    private JPanel navPanel;
    private CardLayout navLayout;

    public BattleController(RPGController mainController, MainFrame mainFrame, JPanel navPanel, CardLayout navLayout) {
        this.mainController = mainController;
        this.mainFrame = mainFrame;
        this.navPanel = navPanel;
        this.navLayout = navLayout;
        setController();
    }

    private void setController() {
        menuPrincipal.setController(this);
        telaBatalha.setController(this);
        menuBatalha.setController(this);
        heroiSprite.setController(this);
    }

    public void iniciaTelas() {
        navPanel.add(this.menuPrincipal, Telas.MENU_PRINCIPAL);

        irTelaPrincipal();
    }

    public void setHeroiSpriteMapa() {
        heroiSprite.getNomeHeroiLabel().setText(heroiUsuario.getPersonName());
        heroiSprite.getSpriteHeroiLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/hero_idle.png")));
        heroiSprite.getHeroiProgressBar().setMaximum(heroiUsuario.getVidaMaxima());
        heroiSprite.getHeroiProgressBar().setValue(heroiUsuario.getVidaAtual());
    }

    public void irTelaPrincipal() {
        navLayout.show(navPanel, Telas.MENU_PRINCIPAL);
        setHeroiSpriteMapa();
        menuPrincipal.getSpriteHeroiPanel().add(this.heroiSprite, Telas.HEROI_SPRITE);
        CardLayout layout = (CardLayout) menuPrincipal.getSpriteHeroiPanel().getLayout();
        layout.show(menuPrincipal.getSpriteHeroiPanel(), Telas.HEROI_SPRITE);
        setMapa();
    }

    public void voltarTelaIncial() {
        navPanel.removeAll();
        mainController.iniciaTelas();
    }

    public void receberMonstros(String dificuldade) {
        try {
            int lvel = this.heroiUsuario.getLvel();
            switch (dificuldade) {
                case Batalha.BATALHA_FACIL:
                    List<Monstro> monstrosFacha1 =inmDao.getMonstroPorFachaLvel(lvel - 2, lvel);
                    List<Monstro> monstrosFacil = selecionaMonstros(monstrosFacha1, 1, 2);
                    System.out.println(monstrosFacha1+"    "+monstrosFacil);
                    iniciarBatalha(monstrosFacil);
                    monstrosFacha1.clear();
                    monstrosFacil.clear();
                    break;
                case Batalha.BATALHA_MEDIA:
                    List<Monstro> monstrosFacha2 =inmDao.getMonstroPorFachaLvel(lvel - 1, lvel + 1);
                    List<Monstro> monstrosMedio = selecionaMonstros(monstrosFacha2, 2, 2);
                    System.out.println(monstrosFacha2+"    "+monstrosMedio);
                    iniciarBatalha(monstrosMedio);
                    monstrosFacha2.clear();
                    monstrosMedio.clear();
                    break;
                case Batalha.BATALHA_DIFICIL:
                    List<Monstro> monstrosFacha3 =inmDao.getMonstroPorFachaLvel(lvel, lvel + 2);
                    List<Monstro> monstrosDificil = selecionaMonstros(monstrosFacha3, 2, 3);
                    System.out.println(monstrosFacha3+"    "+monstrosDificil);
                    iniciarBatalha(monstrosDificil);
                    monstrosFacha3.clear();
                    monstrosDificil.clear();
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BattleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Monstro> selecionaMonstros(List<Monstro> monstroPorFachaLvel, int minNumeroMonstros, int limiteNumeroMonstros) {
        ArrayList<Monstro> monstrosSelecionados = new ArrayList();
        Random rng = new Random();
        int numMonstros = 1 + rng.nextInt(limiteNumeroMonstros);
        if(numMonstros<minNumeroMonstros){
            numMonstros = minNumeroMonstros;
        }
        for (int i = 0; i < numMonstros; i++) {
            monstrosSelecionados.add(monstroPorFachaLvel.get(rng.nextInt(monstroPorFachaLvel.size())));
        }
        return monstrosSelecionados;
    }

    public void receberVilao() {
        try {
            int word = heroiUsuario.getProgress().getMundo();
            switch (word) {
                case 1:
                    Vilao vilao1 = inmDao.getVilaoPorLvel(5);
                    iniciarBatalha(vilao1);
                    break;
                case 2:
                    Vilao vilao2 = inmDao.getVilaoPorLvel(10);
                    iniciarBatalha(vilao2);
                    break;
                case 3:
                    Vilao vilao3 = inmDao.getVilaoPorLvel(15);
                    iniciarBatalha(vilao3);
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BattleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void iniciarBatalha(List<Monstro> monstros) {
        this.batalha = new Battle(this.heroiUsuario, monstros);
        System.out.println(monstros);
    }

    public void iniciarBatalha(Vilao boss) {
        this.batalha = new Battle(this.heroiUsuario, boss);
    }

    public Battle getBatalha() {
        return batalha;
    }

    public Heroi getHeroiUsuario() {
        return heroiUsuario;
    }

    public void setHeroiUsuario(int IdHeroi) {
        try {
            this.heroiUsuario = this.hroDao.getHeroiPorId(IdHeroi);
        } catch (SQLException ex) {
            Logger.getLogger(BattleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void atualizaHeroi() {
        setHeroiUsuario(heroiUsuario.getId());
    }

    public void salvarJogo() {
        try {
            this.hroDao.salvar(heroiUsuario);
        } catch (SQLException ex) {
            Logger.getLogger(BattleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void abrirMenu() {
        menuBatalha.setVisible(true);
    }

    public void sairMenu() {
        menuBatalha.setVisible(false);
        menuBatalha.dispose();
    }

    public void sairConfirma() {
        menuBatalha.setAcao("");
        menuBatalha.getAcaoPanel().setVisible(true);
        menuBatalha.getConfirmaPanel().setVisible(false);
    }

    public void confirmar() {
        if (menuBatalha.getAcao().equals(Outros.VOLTAR_PRINCIPAL)) {
            salvarJogo();
            sairMenu();
            voltarTelaIncial();
        } else if (menuBatalha.getAcao().equals(Outros.SAIR_JOGO)) {
            salvarJogo();
            sairMenu();
            mainController.sairJogo();
        }
    }

    public void selecionaMenuPrincipal() {
        menuBatalha.setAcao(Outros.VOLTAR_PRINCIPAL);
        menuBatalha.getAcaoPanel().setVisible(false);
        menuBatalha.getConfirmaPanel().setVisible(true);
    }

    public void selecionaSairJogo() {
        menuBatalha.setAcao(Outros.SAIR_JOGO);
        menuBatalha.getAcaoPanel().setVisible(false);
        menuBatalha.getConfirmaPanel().setVisible(true);
    }

    public void setPropiedadesBatalha(String descricaoBatalha, String batalhaOpcao1, String batalhaOpcao2, String batalhaOpcao3) {
        menuPrincipal.getTextoLabel().setText(descricaoBatalha);
        menuPrincipal.getAcao1Button().setText(batalhaOpcao1);
        menuPrincipal.getAcao2Button().setText(batalhaOpcao2);
        menuPrincipal.getAcao3Button().setText(batalhaOpcao3);
    }

    public void selecionaDificuldade(int numBotao) {
        Random rng = new Random();
        int padrao = rng.nextInt(6) + 1;
        int facil;
        int medio;
        int dificil;

        switch (padrao) {
            case 1:
                facil = 1;
                medio = 2;
                dificil = 3;
                break;
            case 2:
                facil = 1;
                medio = 3;
                dificil = 2;
                break;
            case 3:
                facil = 2;
                medio = 1;
                dificil = 3;
                break;
            case 4:
                facil = 2;
                medio = 3;
                dificil = 1;
                break;
            case 5:
                facil = 3;
                medio = 2;
                dificil = 1;
                break;
            case 6:
                facil = 3;
                medio = 1;
                dificil = 2;
                break;
            default:
                facil = 1;
                medio = 2;
                dificil = 3;
                break;
        }

        if (numBotao == facil) {
            setDificuldade(facil);
        }else if(numBotao == medio){
            setDificuldade(medio);
        }else{
            setDificuldade(dificil);
        }
    }

    private void setDificuldade(int numDificuldade) {
        switch(numDificuldade){
            case 1:
                receberMonstros(Batalha.BATALHA_FACIL);
                break;
            case 2:
                receberMonstros(Batalha.BATALHA_MEDIA);
                break;
            case 3:
                receberMonstros(Batalha.BATALHA_DIFICIL);                
                break;
        }
    }

    public void setMapa() {
        switch (heroiUsuario.getProgress().getValor()) {
            case 1:
                menuPrincipal.getProgressoLabel().setText(heroiUsuario.getProgress().toString());
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.gif")));
                setPropiedadesBatalha(Batalha.DESCRICAO_BATALHA_1, Batalha.BATALHA_1_OPCAO_1, Batalha.BATALHA_1_OPCAO_2, Batalha.BATALHA_1_OPCAO_3);
                break;
            case 2:
                menuPrincipal.getProgressoLabel().setText(heroiUsuario.getProgress().toString());
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.gif")));
                setPropiedadesBatalha(Batalha.DESCRICAO_BATALHA_2, Batalha.BATALHA_2_OPCAO_1, Batalha.BATALHA_2_OPCAO_2, Batalha.BATALHA_2_OPCAO_3);
                break;
            case 3:
                menuPrincipal.getProgressoLabel().setText(heroiUsuario.getProgress().toString());
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.gif")));
                setPropiedadesBatalha(Batalha.DESCRICAO_BATALHA_3, Batalha.BATALHA_3_OPCAO_1, Batalha.BATALHA_3_OPCAO_2, Batalha.BATALHA_3_OPCAO_3);
                break;
            case 4:
                menuPrincipal.getProgressoLabel().setText(heroiUsuario.getProgress().toString());
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.gif")));
                setPropiedadesBatalha(Batalha.DESCRICAO_BATALHA_4, Batalha.BATALHA_4_OPCAO_1, Batalha.BATALHA_4_OPCAO_2, Batalha.BATALHA_4_OPCAO_3);
                break;
            case 5:
                menuPrincipal.getProgressoLabel().setText(heroiUsuario.getProgress().toString());
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.gif")));
                setPropiedadesBatalha(Batalha.DESCRICAO_BATALHA_5, Batalha.BATALHA_5_OPCAO_1, Batalha.BATALHA_5_OPCAO_2, Batalha.BATALHA_5_OPCAO_3);
                break;
            case 6:
                menuPrincipal.getProgressoLabel().setText(heroiUsuario.getProgress().toString());
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.gif")));
                setPropiedadesBatalha(Batalha.DESCRICAO_BATALHA_6, Batalha.BATALHA_6_OPCAO_1, Batalha.BATALHA_6_OPCAO_2, Batalha.BATALHA_6_OPCAO_3);
                break;
            case 7:
                menuPrincipal.getProgressoLabel().setText(heroiUsuario.getProgress().toString());
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.gif")));
                setPropiedadesBatalha(Batalha.DESCRICAO_BATALHA_7, Batalha.BATALHA_7_OPCAO_1, Batalha.BATALHA_7_OPCAO_2, Batalha.BATALHA_7_OPCAO_3);
                break;
            case 8:
                menuPrincipal.getProgressoLabel().setText(heroiUsuario.getProgress().toString());
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.gif")));
                setPropiedadesBatalha(Batalha.DESCRICAO_BATALHA_8, Batalha.BATALHA_8_OPCAO_1, Batalha.BATALHA_8_OPCAO_2, Batalha.BATALHA_8_OPCAO_3);
                break;
            case 9:
                menuPrincipal.getProgressoLabel().setText(heroiUsuario.getProgress().toString());
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.gif")));
                setPropiedadesBatalha(Batalha.DESCRICAO_BATALHA_9, Batalha.BATALHA_9_OPCAO_1, Batalha.BATALHA_9_OPCAO_2, Batalha.BATALHA_9_OPCAO_3);
                break;
            case 10:
                menuPrincipal.getProgressoLabel().setText(heroiUsuario.getProgress().toString());
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.gif")));
                setPropiedadesBatalha(Batalha.DESCRICAO_BATALHA_10, Batalha.BATALHA_10_OPCAO_1, Batalha.BATALHA_10_OPCAO_2, Batalha.BATALHA_10_OPCAO_3);
                break;
            case 11:
                menuPrincipal.getProgressoLabel().setText(heroiUsuario.getProgress().toString());
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.gif")));
                setPropiedadesBatalha(Batalha.DESCRICAO_BATALHA_11, Batalha.BATALHA_11_OPCAO_1, Batalha.BATALHA_11_OPCAO_2, Batalha.BATALHA_11_OPCAO_3);
                break;
            case 12:
                menuPrincipal.getProgressoLabel().setText(heroiUsuario.getProgress().toString());
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/background.gif")));
                setPropiedadesBatalha(Batalha.DESCRICAO_BATALHA_12, Batalha.BATALHA_12_OPCAO_1, Batalha.BATALHA_12_OPCAO_2, Batalha.BATALHA_12_OPCAO_3);
                break;
        }
    }

}
