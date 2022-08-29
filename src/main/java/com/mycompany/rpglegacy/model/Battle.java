/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.model;

import com.mycompany.rpglegacy.controller.BattleController;
import com.mycompany.rpglegacy.util.Batalha;
import com.mycompany.rpglegacy.util.FrasesBatalha;
import com.mycompany.rpglegacy.util.Sprites;
import java.util.List;
import java.util.Random;

/**
 *
 * @author aluno
 */
public class Battle {

    private Heroi heroi;
    private Boolean heroiDefende = false;
    private int defeInicialHeroi;
    private Vilao boss;
    private Boolean vilaoCarrega = false;
    private int atakInicialVilao = 0;
    private Monstro monstro1 = null;
    private Monstro monstro2 = null;
    private Monstro monstro3 = null;
    private int quantidadeInimigos;
    private BattleController controller;
    private String batalhaStatus;

    public Battle(Heroi heroi, List<Monstro> inimigos, BattleController controller) {
        this.heroi = heroi;
        setMonstros(inimigos);
        this.defeInicialHeroi = heroi.getDefe();
        this.controller = controller;
        this.batalhaStatus = Batalha.BATALHANDO;
    }

    public Battle(Heroi heroi, Vilao boss, BattleController controller) {
        this.heroi = heroi;
        this.boss = boss;
        this.defeInicialHeroi = heroi.getDefe();
        this.atakInicialVilao = boss.getAtak();
        this.controller = controller;
        this.batalhaStatus = Batalha.BATALHANDO;
        this.quantidadeInimigos = 1;
    }

    public Heroi getHeroi() {
        return heroi;
    }

    public Boolean getHeroiDefende() {
        return heroiDefende;
    }

    public void heroiDefender() {
        heroi.setDefe((int) heroi.getDefe() + (heroi.getDefe() / 4));
        heroiDefende = true;
    }

    public void heroiParaDefender() {
        heroi.setDefe(defeInicialHeroi);
        heroiDefende = false;
    }

    public void vilaoCarregaPoder() {
        boss.setAtak((int) boss.getAtak() + (boss.getAtak() / 5));
        vilaoCarrega = true;
    }

    public void vilaoDescarregaPoder() {
        if (vilaoCarrega) {
            boss.setAtak(atakInicialVilao);
            vilaoCarrega = false;
        }
    }

    public Vilao getBoss() {
        return boss;
    }

    public Monstro getMonstro(int index) {
        switch (index) {
            case 1:
                return this.monstro1;
            case 2:
                return this.monstro2;
            case 3:
                return this.monstro3;
            default:
                return this.monstro1;
        }
    }

    public void setMonstros(List<Monstro> listaInimigos) {
        int counter = 0;
        for (Monstro monstroAtual : listaInimigos) {
            switch (counter) {
                case 0:
                    this.monstro1 = monstroAtual;
                    counter++;
                    break;
                case 1:
                    this.monstro2 = monstroAtual;
                    counter++;
                    break;
                case 2:
                    this.monstro3 = monstroAtual;
                default:
                    break;
            }
        }
        this.quantidadeInimigos = counter;
    }

    public Boolean algumInimigoVivo() {
        if (monstro1.estaVivo()) {
            return true;
        } else if (quantidadeInimigos >= 2 && monstro2.estaVivo()) {
            return true;
        } else {
            if (quantidadeInimigos == 3) {
                return monstro3.estaVivo();
            }
            return false;
        }
    }

    public String alguemMorto() {
        if (!heroi.estaVivo()) {
            return Batalha.BATALHA_ENCERRADA_HEROI_MORREU;
        } else if (atakInicialVilao != 0) {
            if (!boss.estaVivo()) {
                return Batalha.BATALHA_ENCERRADA_HEROI_VENCEU_BATALHA;
            }
            return Batalha.BATALHANDO;
        } else {
            if (!algumInimigoVivo()) {
                return Batalha.BATALHA_ENCERRADA_HEROI_VENCEU_BATALHA;
            }
            return Batalha.BATALHANDO;
        }
    }

    public void atualizaTela(String heroiSprite) {
        String qualInimigo;
        if(atakInicialVilao != 0){
            qualInimigo = Batalha.VILAO;
        }else{
            qualInimigo = Batalha.MONSTROS;
        }
        controller.atualizaSpritesBatalha(this.heroi, heroiSprite, qualInimigo);
    }

    public void atacar(String atacante, String alvo) {
        switch (atacante) {
            case Batalha.HEROI:
                heroiParaDefender();
                switch (alvo) {
                    case Batalha.MONSTRO_1:
                        heroi.atacar(monstro1);
                        atualizaTela(Sprites.SPRITE_HEROI_ATAQUE);
                    case Batalha.MONSTRO_2:
                        heroi.atacar(monstro2);
                    case Batalha.MONSTRO_3:
                        heroi.atacar(monstro3);
                    case Batalha.VILAO:
                        heroi.atacar(boss);
                }
                break;
            case Batalha.VILAO:
                boss.atacar(heroi);
                vilaoAcao();
                heroiParaDefender();
                atualizaTela(Sprites.SPRITE_HEROI_TOMA_DANO);
                break;
            default:
                switch (atacante) {
                    case Batalha.MONSTRO_1: {
                        monstro1.atacar(heroi);
                        heroiParaDefender();
                        atualizaTela(Sprites.SPRITE_HEROI_TOMA_DANO);
                    }
                    case Batalha.MONSTRO_2: {
                        monstro2.atacar(heroi);
                        heroiParaDefender();
                        atualizaTela(Sprites.SPRITE_HEROI_TOMA_DANO);
                    }
                    case Batalha.MONSTRO_3: {
                        monstro3.atacar(heroi);
                        heroiParaDefender();
                        atualizaTela(Sprites.SPRITE_HEROI_TOMA_DANO);
                    }
                }
                break;
        }
    }

    public void vilaoAcao() {
        if (vilaoCarrega) {
            boss.atacar(heroi);
            vilaoDescarregaPoder();
        } else {
            if (boss.getVidaAtual() < boss.getVidaMaxima() / 2) {
                Random rng = new Random();
                if (rng.nextInt(10) > 5) {
                    vilaoCarregaPoder();
                } else {
                    boss.atacar(heroi);
                    vilaoDescarregaPoder();
                }
            } else {
                boss.atacar(heroi);
                vilaoDescarregaPoder();
            }

        }
    }

    public String serTextoBatalha(String argumento) {
        switch (argumento) {
            case FrasesBatalha.FRASE_INICIA_BATALHA_1:
                return FrasesBatalha.FRASE_INICIA_BATALHA_1 + quantidadeInimigos + FrasesBatalha.FRASE_INICIA_BATALHA_2;
            case FrasesBatalha.FRASE_INICIA_BATALHA_3:
                if (atakInicialVilao != 0) {
                    return FrasesBatalha.FRASE_INICIA_BATALHA_3 + boss.getPersonName();
                }
                return FrasesBatalha.FRASE_INICIA_BATALHA_3 + monstro1.getTipo();
            case FrasesBatalha.FRASE_INICIA_BATALHA_4:
                return monstro2.getTipo() + FrasesBatalha.FRASE_INICIA_BATALHA_4;
            case FrasesBatalha.FRASE_INICIA_BATALHA_5:
                return monstro3.getTipo() + FrasesBatalha.FRASE_INICIA_BATALHA_5;
            default:
                return argumento;
        }
    }

}
