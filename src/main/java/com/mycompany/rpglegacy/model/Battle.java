/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.model;

import com.mycompany.rpglegacy.controller.BattleController;
import com.mycompany.rpglegacy.util.Batalha;
import com.mycompany.rpglegacy.util.Sprites;
import java.util.List;

/**
 *
 * @author aluno
 */
public class Battle {

    private Heroi heroi;
    private Boolean heroiDefende = false;
    private int defeInicialHeroi;
    private List<Monstro> inimigos;
    private Vilao boss;
    private Boolean vilaoCarrega = false;
    private int atakInicialVilao;
    private Monstro monstro1;
    private Monstro monstro2;
    private Monstro monstro3;
    private BattleController controller;

    public Battle(Heroi heroi, List<Monstro> inimigos, BattleController controller) {
        this.heroi = heroi;
        this.inimigos = inimigos;
        setMonstros();
        this.defeInicialHeroi = heroi.getDefe();
        this.controller = controller;
    }

    public Battle(Heroi heroi, Vilao boss, BattleController controller) {
        this.heroi = heroi;
        this.boss = boss;
        this.defeInicialHeroi = heroi.getDefe();
        this.atakInicialVilao = boss.getAtak();
        this.controller = controller;
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
        boss.setAtak(atakInicialVilao);
        vilaoCarrega = false;
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

    public void setMonstros() {
        int counter = 1;
        for (Monstro monstroAtual : this.inimigos) {
            switch (counter) {
                case 1:
                    this.monstro1 = monstroAtual;
                    counter++;
                    break;
                case 2:
                    this.monstro2 = monstroAtual;
                    counter++;
                    break;
                case 3:
                    this.monstro3 = monstroAtual;
                default:
                    break;
            }
        }
    }

    public void atualizaTela(String heroiSprite) {
        controller.setHeroiSpriteBatalha(this.heroi, heroiSprite);
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
                heroiParaDefender();
                vilaoDescarregaPoder();
                break;
            default:
                switch (atacante) {
                    case Batalha.MONSTRO_1: {
                        monstro1.atacar(heroi);
                        heroiParaDefender();
                    }
                    case Batalha.MONSTRO_2: {
                        monstro2.atacar(heroi);
                        heroiParaDefender();
                    }
                    case Batalha.MONSTRO_3: {
                        monstro3.atacar(heroi);
                        heroiParaDefender();
                    }
                }
                break;
        }
    }

}
