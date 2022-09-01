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
import com.mycompany.rpglegacy.util.FrasesBatalha;
import com.mycompany.rpglegacy.util.MonsTipos;
import com.mycompany.rpglegacy.util.Outros;
import com.mycompany.rpglegacy.util.Sprites;
import com.mycompany.rpglegacy.util.Telas;
import com.mycompany.rpglegacy.view.BatalhaBotoesPanel;
import com.mycompany.rpglegacy.view.GameOverDialog;
import com.mycompany.rpglegacy.view.PersonagemSprite;
import com.mycompany.rpglegacy.view.InfoPanel;
import com.mycompany.rpglegacy.view.MainFrame;
import com.mycompany.rpglegacy.view.MenuBatalha;
import com.mycompany.rpglegacy.view.MenuPrincipal;
import com.mycompany.rpglegacy.view.StatusHeroi;
import com.mycompany.rpglegacy.view.TelaBatalha;
import com.mycompany.rpglegacy.view.VictoryDialog;
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
    private PersonagemSprite heroiSprite = new PersonagemSprite();
    private PersonagemSprite inimigoSprite = new PersonagemSprite();
    private StatusHeroi statusHeroi = new StatusHeroi(mainFrame, true);
    private BatalhaBotoesPanel batalhaBotoes = new BatalhaBotoesPanel();
    private InfoPanel infoPanel = new InfoPanel();
    private VictoryDialog dialogVitoria = new VictoryDialog(mainFrame, true);
    private GameOverDialog dialogGameOver = new GameOverDialog(mainFrame, true);

    private JPanel navPanel;
    private CardLayout navLayout;

    private JPanel statPanel;
    private CardLayout statLayout;

    public BattleController(RPGController mainController, MainFrame mainFrame, JPanel navPanel, CardLayout navLayout) {
        this.mainController = mainController;
        this.mainFrame = mainFrame;
        this.navPanel = navPanel;
        this.navLayout = navLayout;
        this.statPanel = telaBatalha.getStatusPanel();
        this.statLayout = (CardLayout) telaBatalha.getStatusPanel().getLayout();
        setController();
    }

    private void setController() {
        menuPrincipal.setController(this);
        telaBatalha.setController(this);
        menuBatalha.setController(this);
        heroiSprite.setController(this);
        statusHeroi.setController(this);
        batalhaBotoes.setController(this);
        infoPanel.setController(this);
        dialogGameOver.setController(this);
        dialogVitoria.setController(this);
    }

    public void iniciaTelas() {
        navPanel.add(this.menuPrincipal, Telas.MENU_PRINCIPAL);

        irTelaPrincipal();
    }

    public void setHeroiSpriteMapa() {
        heroiSprite.getNomeHeroiLabel().setText(heroiUsuario.getPersonName());
        heroiSprite.getSpriteHeroiLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(Sprites.SPRITE_HEROI_IDLE)));
        heroiSprite.getHeroiProgressBar().setMaximum(heroiUsuario.getVidaMaxima());
        heroiSprite.getHeroiProgressBar().setValue(heroiUsuario.getVidaAtual());
        heroiSprite.getHeroiProgressBar().setString(heroiUsuario.getVidaAtual() + " / " + heroiUsuario.getVidaMaxima());
    }

    public void setHeroiSpriteBatalha(Heroi heroi, String heroSprite) {
        heroiSprite.getNomeHeroiLabel().setText(heroi.getPersonName());
        heroiSprite.getSpriteHeroiLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(heroSprite)));
        heroiSprite.getHeroiProgressBar().setMaximum(heroi.getVidaMaxima());
        heroiSprite.getHeroiProgressBar().setValue(heroi.getVidaAtual());
        heroiSprite.getHeroiProgressBar().setString(heroi.getVidaAtual() + " / " + heroi.getVidaMaxima());
    }

    public void setInimigoSpriteBatalha(Monstro monstro) {
        inimigoSprite.getNomeHeroiLabel().setText(monstro.getTipo());
        if (monstro.estaVivo()) {
            switch (monstro.getTipo()) {
                case MonsTipos.ARANHA:
                    inimigoSprite.getSpriteHeroiLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(Sprites.SPRITE_ARANHA_IDLE)));
                    break;
                case MonsTipos.COISA_FLORESTA:
                    inimigoSprite.getSpriteHeroiLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(Sprites.SPRITE_COISA_FLORESTA_IDLE)));
                    break;
                case MonsTipos.LAGARTO_TOXICO:
                    inimigoSprite.getSpriteHeroiLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(Sprites.SPRITE_LAGARTO_TOXICO_IDLE)));
                    break;
                case MonsTipos.LOBISOMEN_SANGUINARIO:
                    inimigoSprite.getSpriteHeroiLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(Sprites.SPRITE_LOBISOMEN_SANGUINARIO_IDLE)));
                    break;
                case MonsTipos.HEROI_MORTO_VIVO:
                    inimigoSprite.getSpriteHeroiLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(Sprites.SPRITE_HEROI_MORTO_VIVO_IDLE)));
                    break;
                default:
                    inimigoSprite.getSpriteHeroiLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(Sprites.SPRITE_HEROI_MORTO_VIVO_IDLE)));
                    break;
            }
        } else {
            inimigoSprite.getSpriteHeroiLabel().setIcon(null);
        }
        inimigoSprite.getHeroiProgressBar().setMaximum(monstro.getVidaMaxima());
        inimigoSprite.getHeroiProgressBar().setValue(monstro.getVidaAtual());
        inimigoSprite.getHeroiProgressBar().setString(monstro.getVidaAtual() + " / " + monstro.getVidaMaxima());
    }

    public void setInimigoSpriteBatalha(Vilao boss, String heroSprite) {
        inimigoSprite.getNomeHeroiLabel().setText(boss.getPersonName());
        inimigoSprite.getSpriteHeroiLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource(Sprites.SPRITE_VILAO_IDLE)));
        inimigoSprite.getHeroiProgressBar().setMaximum(boss.getVidaMaxima());
        inimigoSprite.getHeroiProgressBar().setValue(boss.getVidaAtual());
        inimigoSprite.getHeroiProgressBar().setString(boss.getVidaAtual() + " / " + boss.getVidaMaxima());
    }

    public void irTelaPrincipal() {
        atualizaHeroi();
        navLayout.show(navPanel, Telas.MENU_PRINCIPAL);
        setHeroiSpriteMapa();
        menuPrincipal.getSpriteHeroiPanel().add(this.heroiSprite, Telas.HEROI_SPRITE);
        CardLayout layout = (CardLayout) menuPrincipal.getSpriteHeroiPanel().getLayout();
        layout.show(menuPrincipal.getSpriteHeroiPanel(), Telas.HEROI_SPRITE);
        setMapa();
    }

    public void irTelaBatalha(String qualInimigo) {
        navPanel.add(telaBatalha, Telas.TELA_BATALHA);
        navLayout.show(navPanel, Telas.TELA_BATALHA);
        telaBatalha.setQualInimigo(qualInimigo);
        telaBatalha.getInfoLabel().setText(heroiUsuario.getProgress().toString());
        setFilhosInfoPanel();
        atualizaSpritesBatalha(heroiUsuario, heroiPadraoSprite());
        atualizaStatusBatalha();
    }

    public void sairTelaBatalha() {
        navPanel.remove(telaBatalha);
    }

    public void setFilhosInfoPanel() {
        statPanel.add(batalhaBotoes, Telas.BATALHA_BOTOES);
        statPanel.add(infoPanel, Telas.INFO_PANEL);
        telaBatalha.getSpriteAdversarioPanel().add(this.inimigoSprite, Telas.INIMIGO_SPRITE);
        telaBatalha.getSpriteHeroiPanel().add(this.heroiSprite, Telas.HEROI_SPRITE);

    }

    public void atualizaSpritesBatalha(Heroi heroi, String spriteHeroi) {
        setHeroiSpriteBatalha(heroi, spriteHeroi);
        atualizaSpriteHeroiBatalha();
        if (telaBatalha.getQualInimigo().equals(Batalha.MONSTROS)) {
            setInimigoSpriteBatalha(batalha.getMonstro());
            atualizaSpriteInimigo();
        } else {
            setInimigoSpriteBatalha(batalha.getBoss(), bossPadraoSprite());
            atualizaSpriteInimigo();
        }

    }

    public void atualizaStatusBatalha() {
        statLayout.show(statPanel, Telas.INFO_PANEL);
        String textoBatalha = batalha.serTextoBatalha();
        if (textoBatalha.equals(Outros.NAO_TEXTO)) {
            statLayout.show(statPanel, Telas.BATALHA_BOTOES);
        } else {
            infoPanel.getInfoTextoLabel().setText(batalha.serTextoBatalha());

        }
    }

    public void proximo() {
        int pointer = batalha.getTextoBatalhaPointer();
        if (pointer == 1) {
            batalha.setTextoBatalhaPointer(2);
            atualizaSpritesBatalha(heroiUsuario, heroiPadraoSprite());
            atualizaStatusBatalha();
        } else if (pointer == 5) {
            if (batalha.bossExiste()) {
                batalha.atacar(Batalha.HEROI, Batalha.VILAO);
            } else {
                batalha.atacar(Batalha.HEROI, qualMonstro(batalha.getMonstroPointer()));
            }
        } else if (pointer == 6) {
            batalha.atacar(qualMonstro(batalha.getMonstroPointer()), Batalha.HEROI);
        } else if (pointer == 7) {
            batalha.atacar(Batalha.VILAO, Batalha.HEROI);
        } else if (pointer == 9) {
            batalha.atacar(Batalha.VILAO, Batalha.HEROI);
        } else if (pointer == 11 || pointer == 16) {
            if (batalha.getMonstro().estaVivo()) {
                inimigoAtaca();
            } else {
                terminaLuta();
            }
        } else if (pointer == 12 || pointer == 17) {
            if (batalha.getBoss().estaVivo()) {
                inimigoAtaca();
            } else {
                terminaLuta();
            }
        } else if (pointer == 13) {
            inimigoAtaca();
        } else if (pointer == 15) {
            if (batalha.getHeroi().estaVivo()) {
                batalha.setTextoBatalhaPointer(0);
                atualizaSpritesBatalha(heroiUsuario, heroiPadraoSprite());
                atualizaStatusBatalha();
            } else {
                terminaLuta();
            }
        } else if (pointer == 19) {
            setVitoriaDialog();
        } else if (pointer == 20) {
            setVitoriaDialog();
        } else if (pointer == 21) {
            finalizar();
        } else if (pointer == 22 || pointer == 18) {
            gameOver();
        } else if (pointer == 2 || pointer == 3 || pointer == 4 || pointer == 8 || pointer == 10) {
            batalha.setTextoBatalhaPointer(0);
            atualizaSpritesBatalha(heroiUsuario, heroiPadraoSprite());
            atualizaStatusBatalha();
        }
    }

    public void setFinalLuta() {
        if (batalha.algumInimigoVivo()) {
            switch (qualMonstro(batalha.getMonstroPointer())) {
                case Batalha.MONSTRO_2:
                    batalha.setTextoBatalhaPointer(3);
                    setInimigoSpriteBatalha(batalha.getMonstro());
                    setHeroiSpriteBatalha(heroiUsuario, Sprites.SPRITE_HEROI_IDLE);
                    atualizaStatusBatalha();
                    break;
                case Batalha.MONSTRO_3:
                    batalha.setTextoBatalhaPointer(4);
                    setHeroiSpriteBatalha(heroiUsuario, Sprites.SPRITE_HEROI_IDLE);
                    setInimigoSpriteBatalha(batalha.getMonstro());
                    atualizaStatusBatalha();
                    break;
            }
        } else {
            batalha.setTextoBatalhaPointer(21);
            atualizaSpritesBatalha(heroiUsuario, Sprites.SPRITE_HEROI_VITORIA);
            atualizaStatusBatalha();
        }
    }

    public void setFinalBatalha() {
        batalha.setTextoBatalhaPointer(21);
        atualizaSpritesBatalha(heroiUsuario, Sprites.SPRITE_HEROI_VITORIA);
        atualizaStatusBatalha();
    }

    public void setPointer(int fraseId) {
        batalha.setTextoBatalhaPointer(fraseId);
    }

    public void atualizaSpriteInimigo() {
        CardLayout layout = (CardLayout) telaBatalha.getSpriteAdversarioPanel().getLayout();
        layout.show(telaBatalha.getSpriteAdversarioPanel(), Telas.INIMIGO_SPRITE);
    }

    public void atualizaSpriteHeroiBatalha() {
        CardLayout layout = (CardLayout) telaBatalha.getSpriteHeroiPanel().getLayout();
        layout.show(telaBatalha.getSpriteHeroiPanel(), Telas.HEROI_SPRITE);
    }

    public void voltarTelaIncial() {
        navPanel.removeAll();
        mainController.iniciaTelas();
    }

    private void receberBoss() {
        int mundo = this.heroiUsuario.getProgress().getMundo();
        switch (mundo) {
            case 1: {
                try {
                    iniciarBatalha(inmDao.getVilaoPorLvel(5));
                } catch (SQLException ex) {
                    Logger.getLogger(BattleController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 2: {
                try {
                    iniciarBatalha(inmDao.getVilaoPorLvel(10));
                } catch (SQLException ex) {
                    Logger.getLogger(BattleController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case 3: {
                try {
                    iniciarBatalha(inmDao.getVilaoPorLvel(15));
                } catch (SQLException ex) {
                    Logger.getLogger(BattleController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;

        }
    }

    public void receberMonstros(String dificuldade) {
        try {
            int lvel = this.heroiUsuario.getLvel();
            switch (dificuldade) {
                case Batalha.BATALHA_FACIL:
                    List<Monstro> monstrosFacha1 = inmDao.getMonstroPorFachaLvel(lvel - 1, lvel);
                    List<Monstro> monstrosFacil = selecionaMonstros(monstrosFacha1, 2, 3);
                    iniciarBatalha(monstrosFacil);
                    monstrosFacha1.clear();
                    monstrosFacil.clear();
                    break;
                case Batalha.BATALHA_MEDIA:
                    List<Monstro> monstrosFacha2 = inmDao.getMonstroPorFachaLvel(lvel, lvel);
                    List<Monstro> monstrosMedio = selecionaMonstros(monstrosFacha2, 2, 2);
                    iniciarBatalha(monstrosMedio);
                    monstrosFacha2.clear();
                    monstrosMedio.clear();
                    break;
                case Batalha.BATALHA_DIFICIL:
                    List<Monstro> monstrosFacha3 = inmDao.getMonstroPorFachaLvel(lvel, lvel + 1);
                    List<Monstro> monstrosDificil = selecionaMonstros(monstrosFacha3, 1, 3);
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
        if (numMonstros < minNumeroMonstros) {
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
                    Vilao vilao2 = inmDao.getVilaoPorLvel(7);
                    iniciarBatalha(vilao2);
                    break;
                case 3:
                    Vilao vilao3 = inmDao.getVilaoPorLvel(9);
                    iniciarBatalha(vilao3);
                    break;
                case 4:
                    Vilao vilao4 = inmDao.getVilaoPorLvel(12);
                    iniciarBatalha(vilao4);
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BattleController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void iniciarBatalha(List<Monstro> monstros) {
        this.batalha = new Battle(this.heroiUsuario, monstros, this);
        irTelaBatalha(Batalha.MONSTROS);

    }

    public void iniciarBatalha(Vilao boss) {
        this.batalha = new Battle(this.heroiUsuario, boss, this);
        irTelaBatalha(Batalha.VILAO);
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

    public void abrirStatus() {
        atualizaTelaStatus();
        statusHeroi.setVisible(true);
    }

    public void abrirStatus(Heroi heroi) {
        atualizaTelaStatus(heroi);
        statusHeroi.setVisible(true);
    }

    private void atualizaTelaStatus() {
        statusHeroi.getNomeHeroiLabel().setText(heroiUsuario.getPersonName());
        statusHeroi.getVidaValorLabel().setText(String.valueOf(heroiUsuario.getVidaAtual()) + " / " + String.valueOf(heroiUsuario.getVidaMaxima()));
        statusHeroi.getAtaqueValorLabel().setText(String.valueOf(heroiUsuario.getAtak()));
        statusHeroi.getDefesaValorLabel().setText(String.valueOf(heroiUsuario.getDefe()));
        statusHeroi.getVelocidadeValorLabel().setText(String.valueOf(heroiUsuario.getSped()));
        statusHeroi.getLevelValorLabel().setText(String.valueOf(heroiUsuario.getLvel()));
        statusHeroi.getXpProxLvlValorLabel().setText(String.valueOf(heroiUsuario.getExpNxtLvel()));
    }

    private void atualizaTelaStatus(Heroi heroi) {
        statusHeroi.getNomeHeroiLabel().setText(heroi.getPersonName());
        statusHeroi.getVidaValorLabel().setText(String.valueOf(heroi.getVidaAtual()) + " / " + String.valueOf(heroiUsuario.getVidaMaxima()));
        statusHeroi.getAtaqueValorLabel().setText(String.valueOf(heroi.getAtak()));
        statusHeroi.getDefesaValorLabel().setText(String.valueOf(heroi.getDefe()));
        statusHeroi.getVelocidadeValorLabel().setText(String.valueOf(heroi.getSped()));
        statusHeroi.getLevelValorLabel().setText(String.valueOf(heroi.getLvel()));
        statusHeroi.getXpProxLvlValorLabel().setText(String.valueOf(heroi.getExpNxtLvel()));
    }

    public void sairStatus() {
        statusHeroi.setVisible(false);
        statusHeroi.dispose();
    }

    public void sairConfirma() {
        menuBatalha.setAcao("");
        menuBatalha.getAcaoPanel().setVisible(true);
        menuBatalha.getConfirmaPanel().setVisible(false);
    }

    public void confirmar() {
        if (menuBatalha.getAcao().equals(Outros.VOLTAR_PRINCIPAL)) {
            sairMenu();
            voltarTelaIncial();
        } else if (menuBatalha.getAcao().equals(Outros.SAIR_JOGO)) {
            sairMenu();
            mainController.sairJogo();
        } else if (menuBatalha.getAcao().equals(Outros.VER_STATUS)) {

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

    public void selecionaVerStatusHeroi() {
        abrirStatus();
    }

    public void setPropiedadesBatalha(String nomeMundo, String descricaoBatalha, String batalhaOpcao1, String batalhaOpcao2, String batalhaOpcao3) {
        menuPrincipal.getProgressoLabel().setText(heroiUsuario.getProgress().toString() + " / " + nomeMundo);
        menuPrincipal.getTextoLabel().setText(descricaoBatalha);
        menuPrincipal.getAcao1Button().setText(batalhaOpcao1);
        menuPrincipal.getAcao1Button().setVisible(true);
        menuPrincipal.getAcao2Button().setText(batalhaOpcao2);
        menuPrincipal.getAcao3Button().setVisible(true);
        menuPrincipal.getAcao3Button().setText(batalhaOpcao3);
    }

    public void setPropiedadesBatalha(String nomeMundo, String descricaoBatalha, String batalhaBoss) {
        menuPrincipal.getProgressoLabel().setText(heroiUsuario.getProgress().toString() + " / " + nomeMundo);
        menuPrincipal.getTextoLabel().setText(descricaoBatalha);
        menuPrincipal.getAcao2Button().setText(batalhaBoss);
        menuPrincipal.getAcao1Button().setVisible(false);
        menuPrincipal.getAcao3Button().setVisible(false);
    }

    public void selecionaDificuldade(int numBotao) {
        if (!menuPrincipal.getAcao1Button().isVisible() && !menuPrincipal.getAcao1Button().isVisible() && numBotao == 2) {
            setBoss();
        } else {

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
                setDificuldade(Batalha.BATALHA_FACIL);
            } else if (numBotao == medio) {
                setDificuldade(Batalha.BATALHA_MEDIA);
            } else if (numBotao == dificil) {
                setDificuldade(Batalha.BATALHA_DIFICIL);
            } else {
                setDificuldade(Batalha.BATALHA_MEDIA);
            }
        }
    }

    private void setBoss() {
        receberBoss();
    }

    private void setDificuldade(String dificuldade) {
        switch (dificuldade) {
            case Batalha.BATALHA_FACIL:
                heroiUsuario.receberVida((int) (heroiUsuario.getVidaMaxima() * 0.15));
                receberMonstros(Batalha.BATALHA_FACIL);
                break;
            case Batalha.BATALHA_MEDIA:
                heroiUsuario.receberVida((int) (heroiUsuario.getVidaMaxima() * 0.25));
                receberMonstros(Batalha.BATALHA_MEDIA);
                break;
            case Batalha.BATALHA_DIFICIL:
                heroiUsuario.receberVida((int) (heroiUsuario.getVidaMaxima() * 0.35));
                receberMonstros(Batalha.BATALHA_DIFICIL);
                break;
        }
    }

    public void setMapa() {
        switch (heroiUsuario.getProgress().getValor()) {
            case 1:
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/forest_bg.png")));
                setPropiedadesBatalha(Batalha.NOME_MUNDO_FASE_1, Batalha.DESCRICAO_BATALHA_1, Batalha.BATALHA_1_OPCAO_1, Batalha.BATALHA_1_OPCAO_2, Batalha.BATALHA_1_OPCAO_3);
                break;
            case 2:
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/forest_bg.png")));
                setPropiedadesBatalha(Batalha.NOME_MUNDO_FASE_2, Batalha.DESCRICAO_BATALHA_2, Batalha.BATALHA_2_OPCAO_1, Batalha.BATALHA_2_OPCAO_2, Batalha.BATALHA_2_OPCAO_3);
                break;
            case 3:
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/forest_bg.png")));
                setPropiedadesBatalha(Batalha.NOME_MUNDO_FASE_3, Batalha.DESCRICAO_BATALHA_3, Batalha.NOME_BOSS_1);
                break;
            case 4:
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/city_bg.jpg")));
                setPropiedadesBatalha(Batalha.NOME_MUNDO_FASE_4, Batalha.DESCRICAO_BATALHA_4, Batalha.BATALHA_4_OPCAO_1, Batalha.BATALHA_4_OPCAO_2, Batalha.BATALHA_4_OPCAO_3);
                break;
            case 5:
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/city_bg.jpg")));
                setPropiedadesBatalha(Batalha.NOME_MUNDO_FASE_5, Batalha.DESCRICAO_BATALHA_5, Batalha.BATALHA_5_OPCAO_1, Batalha.BATALHA_5_OPCAO_2, Batalha.BATALHA_5_OPCAO_3);
                break;
            case 6:
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/city_bg.jpg")));
                setPropiedadesBatalha(Batalha.NOME_MUNDO_FASE_3, Batalha.DESCRICAO_BATALHA_3, Batalha.NOME_BOSS_2);
                break;
            case 7:
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/castle_bg.jpg")));
                setPropiedadesBatalha(Batalha.NOME_MUNDO_FASE_7, Batalha.DESCRICAO_BATALHA_7, Batalha.BATALHA_7_OPCAO_1, Batalha.BATALHA_7_OPCAO_2, Batalha.BATALHA_7_OPCAO_3);
                break;
            case 8:
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/castle_bg.jpg")));
                setPropiedadesBatalha(Batalha.NOME_MUNDO_FASE_8, Batalha.DESCRICAO_BATALHA_8, Batalha.BATALHA_8_OPCAO_1, Batalha.BATALHA_8_OPCAO_2, Batalha.BATALHA_8_OPCAO_3);
                break;
            case 9:
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/castle_bg.jpg")));
                setPropiedadesBatalha(Batalha.NOME_MUNDO_FASE_3, Batalha.DESCRICAO_BATALHA_3, Batalha.NOME_BOSS_3);
                break;
            case 10:
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/throne_bg.jpg")));
                setPropiedadesBatalha(Batalha.NOME_MUNDO_FASE_10, Batalha.DESCRICAO_BATALHA_10, Batalha.BATALHA_10_OPCAO_1, Batalha.BATALHA_10_OPCAO_2, Batalha.BATALHA_10_OPCAO_3);
                break;
            case 11:
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/throne_bg.jpg")));
                setPropiedadesBatalha(Batalha.NOME_MUNDO_FASE_11, Batalha.DESCRICAO_BATALHA_11, Batalha.BATALHA_11_OPCAO_1, Batalha.BATALHA_11_OPCAO_2, Batalha.BATALHA_11_OPCAO_3);
                break;
            case 12:
                mainFrame.getFundoLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/throne_bg.jpg")));
                setPropiedadesBatalha(Batalha.NOME_MUNDO_FASE_3, Batalha.DESCRICAO_BATALHA_3, Batalha.NOME_BOSS_4);
                break;
        }
    }

    public void heroiAtaca() {
        batalha.setTextoBatalhaPointer(5);
        atualizaSpritesBatalha(heroiUsuario, Sprites.SPRITE_HEROI_ATAQUE);
        atualizaStatusBatalha();
    }

    public void heroiDefende() {
        batalha.setTextoBatalhaPointer(13);
        batalha.heroiDefender();
        atualizaSpritesBatalha(heroiUsuario, heroiPadraoSprite());
        atualizaStatusBatalha();
    }

    public void heroiDesiste() {
        batalha.setTextoBatalhaPointer(22);
        atualizaSpritesBatalha(heroiUsuario, Sprites.SPRITE_HEROI_DESISTE);
        atualizaStatusBatalha();
    }

    private void inimigoAtaca() {
        if (!batalha.bossExiste()) {
            batalha.setTextoBatalhaPointer(6);
            atualizaStatusBatalha();
        } else {
            bossAtaca();
        }
    }

    private String qualMonstro(int monstroPointer) {
        switch (monstroPointer) {
            case 1:
                return Batalha.MONSTRO_1;
            case 2:
                return Batalha.MONSTRO_2;
            case 3:
                return Batalha.MONSTRO_3;
            default:
                return Batalha.MONSTRO_1;
        }
    }

    public String heroiPadraoSprite() {
        if (batalha.getHeroiDefende()) {
            return Sprites.SPRITE_HEROI_DEFENDE;
        }
        return Sprites.SPRITE_HEROI_IDLE;
    }

    public String bossPadraoSprite() {
        if (batalha.getVilaoCarrega()) {
            return Sprites.SPRITE_VILAO_CARREGA;
        }
        return Sprites.SPRITE_VILAO_IDLE;
    }

    private void bossAtaca() {
        if (batalha.getVilaoCarrega()) {
            batalha.setTextoBatalhaPointer(9);
            atualizaStatusBatalha();
        } else {
            batalha.setTextoBatalhaPointer(7);
            atualizaStatusBatalha();
        }
    }

    private void terminaLuta() {
        switch (batalha.alguemMorto()) {
            case Batalha.BATALHA_ENCERRADA_HEROI_MORREU:
                batalha.setTextoBatalhaPointer(18);
                setHeroiSpriteBatalha(batalha.getHeroi(), Sprites.SPRITE_HEROI_DERROTA);
                atualizaStatusBatalha();
                break;
            case Batalha.BATALHA_ENCERRADA_HEROI_VENCEU_BATALHA:
                batalha.setXpGanho(batalha.getBoss().getExpGanho());
                batalha.setTextoBatalhaPointer(20);
                setInimigoSpriteBatalha(batalha.getBoss(), Sprites.SPRITE_VILAO_DERROTA);
                atualizaStatusBatalha();
                break;
            case Batalha.BATALHA_ENCERRADA_HEROI_VENCEU_MONSTRO:
                batalha.setXpGanho(batalha.getMonstro().getExpGanho());
                batalha.setTextoBatalhaPointer(19);
                atualizaStatusBatalha();
                break;
            case Batalha.BATALHANDO:
                batalha.setXpGanho(batalha.getMonstro().getExpGanho());
                batalha.setMonstroPointer(batalha.getMonstroPointer() + 1);
                batalha.setTextoBatalhaPointer(19);
                atualizaStatusBatalha();
                break;
        }
    }

    private void gameOver() {
        this.dialogGameOver.setVisible(true);
    }

    public void sairGameOver() {
        dialogGameOver.setVisible(false);
        dialogGameOver.dispose();
        voltarTelaIncial();
    }

    private void setVitoriaDialog() {
        Heroi antigoHeroi = new Heroi(batalha.getHeroi().getId(), batalha.getHeroi().getPersonName(),
                batalha.getHeroi().getAtak(), batalha.getHeroi().getDefe(), batalha.getHeroi().getSped(),
                batalha.getHeroi().getVidaMaxima(), batalha.getHeroi().getVidaAtual(), batalha.getHeroi().getExpNxtLvel(),
                batalha.getHeroi().getLvel(), batalha.getHeroi().getProgress(), batalha.getHeroi().getUsuario());
        Boolean levlUp = batalha.getHeroi().setExpNxtLvel(batalha.getXpGanho());
        if (levlUp) {
            dialogVitoriaLvlUp(antigoHeroi);
        } else {
            dialogVitoriaXpUp(antigoHeroi);
        }
        this.dialogVitoria.setVisible(true);

    }

    public void sairVitoriaDialog() {
        dialogVitoria.setVisible(false);
        dialogVitoria.dispose();
        setFinalLuta();
    }

    private void dialogVitoriaLvlUp(Heroi heroi) {
        dialogVitoria.getAdicionadoVidaLabel().setVisible(true);
        dialogVitoria.getAdicionadoAtaqueLabel().setVisible(true);
        dialogVitoria.getAdicionadoDefesaLabel().setVisible(true);
        dialogVitoria.getAdicionadoVelLabel().setVisible(true);
        dialogVitoria.getAdicionadoLevelLabel().setVisible(true);

        dialogVitoria.getVidaValorLabel().setText(String.valueOf(heroi.getVidaMaxima()));
        dialogVitoria.getAtaqueValorLabel().setText(String.valueOf(heroi.getAtak()));
        dialogVitoria.getDefesaValorLabel().setText(String.valueOf(heroi.getDefe()));
        dialogVitoria.getVelValorLabel().setText(String.valueOf(heroi.getSped()));
        dialogVitoria.getLevelValorLabel().setText(String.valueOf(heroi.getLvel()));
        dialogVitoria.getXpValorLabel().setText(String.valueOf(heroi.getExpNxtLvel()));

        dialogVitoria.getAdicionadoVidaLabel().setText("===>" + String.valueOf(batalha.getHeroi().getVidaMaxima()));
        dialogVitoria.getAdicionadoAtaqueLabel().setText("===>" + String.valueOf(batalha.getHeroi().getAtak()));
        dialogVitoria.getAdicionadoDefesaLabel().setText("===>" + String.valueOf(batalha.getHeroi().getDefe()));
        dialogVitoria.getAdicionadoVelLabel().setText("===>" + String.valueOf(batalha.getHeroi().getSped()));
        dialogVitoria.getAdicionadoLevelLabel().setText("===>" + String.valueOf(batalha.getHeroi().getLvel()));
        dialogVitoria.getAdicionadoXpLabel().setText("===>" + String.valueOf(batalha.getHeroi().getExpNxtLvel()));
    }

    private void dialogVitoriaXpUp(Heroi heroi) {
        dialogVitoria.getAdicionadoVidaLabel().setVisible(false);
        dialogVitoria.getAdicionadoAtaqueLabel().setVisible(false);
        dialogVitoria.getAdicionadoDefesaLabel().setVisible(false);
        dialogVitoria.getAdicionadoVelLabel().setVisible(false);
        dialogVitoria.getAdicionadoLevelLabel().setVisible(false);

        dialogVitoria.getVidaValorLabel().setText(String.valueOf(heroi.getVidaMaxima()));
        dialogVitoria.getAtaqueValorLabel().setText(String.valueOf(heroi.getAtak()));
        dialogVitoria.getDefesaValorLabel().setText(String.valueOf(heroi.getDefe()));
        dialogVitoria.getVelValorLabel().setText(String.valueOf(heroi.getSped()));
        dialogVitoria.getLevelValorLabel().setText(String.valueOf(heroi.getLvel()));
        dialogVitoria.getXpValorLabel().setText(String.valueOf(heroi.getExpNxtLvel()));

        dialogVitoria.getAdicionadoXpLabel().setText("===>" + String.valueOf(batalha.getHeroi().getExpNxtLvel()));
    }

    private void finalizar() {
        batalha.getHeroi().getProgress().aumentaValor();
        salvarJogo();
        sairTelaBatalha();
        irTelaPrincipal();

    }
}
