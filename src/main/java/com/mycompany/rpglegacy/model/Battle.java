/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.model;

import com.mycompany.rpglegacy.controller.BattleController;
import com.mycompany.rpglegacy.util.Batalha;
import com.mycompany.rpglegacy.util.FrasesBatalha;
import com.mycompany.rpglegacy.util.Outros;
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
    private int monstroPointer = 1;
    private int quantidadeInimigos;
    private BattleController controller;
    private String batalhaStatus;
    private String turno = Batalha.HEROI;
    private int textoBatalhaPointer = 1;

    private int danoEnvolvido = 0;

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
        if (bossExiste()) {
            this.turno = Batalha.VILAO;
        } else {
            switch (monstroPointer) {
                case 1:
                    this.turno = Batalha.MONSTRO_1;
                    break;
                case 2:
                    this.turno = Batalha.MONSTRO_2;
                    break;
                case 3:
                    this.turno = Batalha.MONSTRO_3;
                    break;
            }
        }
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

    public Boolean bossExiste() {
        return atakInicialVilao != 0;
    }

    public Monstro getMonstro() {
        switch (this.monstroPointer) {
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
                    counter++;
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
        } else if (bossExiste()) {
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
        controller.atualizaSpritesBatalha(this.heroi, heroiSprite);
    }

    public void atacar(String atacante, String alvo) {
        switch (atacante) {
            case Batalha.HEROI:
                heroiParaDefender();
                switch (alvo) {
                    case Batalha.MONSTRO_1:
                        this.danoEnvolvido = heroi.atacar(monstro1);
                        atualizaTela(Sprites.SPRITE_HEROI_ATAQUE);
                        this.turno = alvo;
                        if (danoEnvolvido > 0) {
                            this.textoBatalhaPointer = 16;
                        } else {
                            this.textoBatalhaPointer = 11;
                        }
                        break;
                    case Batalha.MONSTRO_2:
                        this.danoEnvolvido = heroi.atacar(monstro2);
                        this.turno = alvo;
                        if (danoEnvolvido > 0) {
                            this.textoBatalhaPointer = 16;
                        } else {
                            this.textoBatalhaPointer = 11;
                        }
                        break;
                    case Batalha.MONSTRO_3:
                        this.danoEnvolvido = heroi.atacar(monstro3);
                        this.turno = alvo;
                        if (danoEnvolvido > 0) {
                            this.textoBatalhaPointer = 16;
                        } else {
                            this.textoBatalhaPointer = 11;
                        }
                        break;
                    case Batalha.VILAO:
                        this.danoEnvolvido = heroi.atacar(boss);
                        this.turno = alvo;
                        if (danoEnvolvido > 0) {
                            this.textoBatalhaPointer = 17;
                        } else {
                            this.textoBatalhaPointer = 12;
                        }
                        break;
                }
                break;
            case Batalha.VILAO:
                vilaoAcao();
                this.turno = Batalha.HEROI;
                break;
            default:
                switch (atacante) {
                    case Batalha.MONSTRO_1: {
                        this.danoEnvolvido = monstro1.atacar(heroi);
                        if (danoEnvolvido > 0) {
                            this.textoBatalhaPointer = 15;
                            heroiParaDefender();
                            atualizaTela(Sprites.SPRITE_HEROI_TOMA_DANO);
                        } else {
                            this.textoBatalhaPointer = 10;
                        }
                        this.turno = Batalha.HEROI;
                    }
                    case Batalha.MONSTRO_2: {
                        this.danoEnvolvido = monstro2.atacar(heroi);
                        if (danoEnvolvido > 0) {
                            this.textoBatalhaPointer = 15;
                            heroiParaDefender();
                            atualizaTela(Sprites.SPRITE_HEROI_TOMA_DANO);
                        } else {
                            this.textoBatalhaPointer = 10;
                        }
                        this.turno = Batalha.HEROI;
                    }
                    case Batalha.MONSTRO_3: {
                        this.danoEnvolvido = monstro3.atacar(heroi);
                        if (danoEnvolvido > 0) {
                            this.textoBatalhaPointer = 15;
                            heroiParaDefender();
                            atualizaTela(Sprites.SPRITE_HEROI_TOMA_DANO);
                        } else {
                            this.textoBatalhaPointer = 10;
                        }
                        this.turno = Batalha.HEROI;
                    }
                }
                break;
        }
    }

    public void vilaoAcao() {
        if (vilaoCarrega) {
            if (danoEnvolvido > 0) {
                this.textoBatalhaPointer = 15;
                heroiParaDefender();
                atualizaTela(Sprites.SPRITE_HEROI_TOMA_DANO);
            } else {
                this.textoBatalhaPointer = 10;
            }
            vilaoDescarregaPoder();
        } else {
            if (boss.getVidaAtual() < boss.getVidaMaxima() / 2) {
                Random rng = new Random();
                if (rng.nextInt(10) > 5) {
                    vilaoCarregaPoder();
                    this.textoBatalhaPointer = 0;
                } else {
                    this.danoEnvolvido = boss.atacar(heroi);
                    if (danoEnvolvido > 0) {
                        this.textoBatalhaPointer = 15;
                        heroiParaDefender();
                        atualizaTela(Sprites.SPRITE_HEROI_TOMA_DANO);
                    } else {
                        this.textoBatalhaPointer = 10;
                    }
                    vilaoDescarregaPoder();
                }
            } else {
                this.danoEnvolvido = boss.atacar(heroi);
                if (danoEnvolvido > 0) {
                    this.textoBatalhaPointer = 15;
                    heroiParaDefender();
                    atualizaTela(Sprites.SPRITE_HEROI_TOMA_DANO);
                } else {
                    this.textoBatalhaPointer = 10;
                }
                vilaoDescarregaPoder();
            }

        }
    }

    public String serTextoBatalha() {
        switch (this.textoBatalhaPointer) {
            case 0:
                return Outros.NAO_TEXTO;
            case 1:
                return FrasesBatalha.FRASE_INICIA_BATALHA_1 + quantidadeInimigos + FrasesBatalha.FRASE_INICIA_BATALHA_2;
            case 2:
                if (bossExiste()) {
                    return FrasesBatalha.FRASE_INICIA_BATALHA_3 + boss.getPersonName() + "!";
                }
                return FrasesBatalha.FRASE_INICIA_BATALHA_3 + monstro1.getTipo()+ "!";
            case 3:
                return monstro2.getTipo() + FrasesBatalha.FRASE_INICIA_BATALHA_4;
            case 4:
                return monstro3.getTipo() + FrasesBatalha.FRASE_INICIA_BATALHA_5;
            case 5:
                return heroi.getPersonName() + FrasesBatalha.FRASE_HEROI_ATAQUE;
            case 6:
                return getMonstro().getTipo() + FrasesBatalha.FRASE_INIMIGO_ATAQUE;
            case 7:
                return boss.getPersonName() + FrasesBatalha.FRASE_INIMIGO_ATAQUE;
            case 8:
                return boss.getPersonName() + FrasesBatalha.FRASE_BOSS_CARREGA;
            case 9:
                return boss.getPersonName() + FrasesBatalha.FRASE_BOSS_DESCARREGA;
            case 10:
                return heroi.getPersonName() + FrasesBatalha.FRASE_DESVIA;
            case 11:
                return getMonstro().getTipo() + FrasesBatalha.FRASE_DESVIA;
            case 12:
                return boss.getPersonName() + FrasesBatalha.FRASE_DESVIA;
            case 13:
                return heroi.getPersonName() + FrasesBatalha.FRASE_HEROI_DEFENDE;
            case 14:
                return heroi.getPersonName() + FrasesBatalha.FRASE_HEROI_PARA_DEFENDER;
            case 15:
                return heroi.getPersonName() + FrasesBatalha.FRASE_TOMA_DANO_1 + danoToString() + FrasesBatalha.FRASE_TOMA_DANO_2;
            case 16:
                return getMonstro().getTipo() + FrasesBatalha.FRASE_TOMA_DANO_1 + danoToString() + FrasesBatalha.FRASE_TOMA_DANO_2;
            case 17:
                return boss.getPersonName() + FrasesBatalha.FRASE_TOMA_DANO_1 + danoToString() + FrasesBatalha.FRASE_TOMA_DANO_2;
            case 18:
                return heroi.getPersonName() + FrasesBatalha.FRASE_PERDE_LUTA;
            case 19:
                return getMonstro().getTipo() + FrasesBatalha.FRASE_PERDE_LUTA;
            case 20:
                return boss.getPersonName() + FrasesBatalha.FRASE_PERDE_LUTA;
            case 21:
                return boss.getPersonName() + FrasesBatalha.FRASE_HEROI_VENCE_BATALHA;
            default:
                return "Erro No Texto!!!";
        }
    }

    public int getTextoBatalhaPointer() {
        return textoBatalhaPointer;
    }

    public void setTextoBatalhaPointer(int textoBatalhaPointer) {
        this.textoBatalhaPointer = textoBatalhaPointer;
    }

    public void setMonstroPointer(int monstroPointer) {
        this.monstroPointer = monstroPointer;
    }

    public int getMonstroPointer() {
        return monstroPointer;
    }

    public String danoToString() {
        return String.valueOf(danoEnvolvido);
    }

    public Boolean getVilaoCarrega() {
        return vilaoCarrega;
    }
    
}
