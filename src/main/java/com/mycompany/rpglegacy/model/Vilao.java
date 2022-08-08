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

    public Vilao(String personName, int atak, int defe, int sped, int vidaMaxima, int expNxtLvel, int lvel) {
        super(personName, atak, defe, sped, vidaMaxima);
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
