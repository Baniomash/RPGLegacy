/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.model;

/**
 *
 * @author aluno
 */
public class Vilao extends Personagem <Heroi>{
    private int expGanho;
    
    public Vilao(String personName, int atak, int defe, int sped, int vidaMaxima, int lvel, int expGanho) {
        super(personName, atak, defe, sped, vidaMaxima);
        this.setLvel(lvel);
        this.expGanho = expGanho;
    }

    public Vilao(int id, String personName, int atak, int defe, int sped, int vidaMaxima, int vidaAtual, int lvel, int expGanho) {
        super(id, personName, atak, defe, sped, vidaMaxima, vidaAtual, lvel);
        this.expGanho = expGanho;
    }
    

    public int getExpGanho() {
        return expGanho;
    }
    
    public int atacar(Heroi alvo) {
        int dano = (int) (this.getAtak() * 2.5);
        int diferencaSpd = this.spdDisputa(alvo);
        if(diferencaSpd < 1){
                return 0;
        }else{
            return alvo.receberDano(dano+diferencaSpd);
        }
    }

    public int receberDano(int dano) {
        int danoFinal = (int) (dano * 0.8 - this.getDefe());
        if (danoFinal < 0){
            this.setVidaAtual(this.getVidaAtual()- 1);
            return danoFinal;
        } else {
            this.setVidaAtual(this.getVidaAtual()-danoFinal);
            return danoFinal;
        }
    }
    
}
