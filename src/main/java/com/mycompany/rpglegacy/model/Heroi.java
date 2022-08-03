/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.model;

/**
 *
 * @author aluno
 */
public class Heroi extends Personagem <Vilao>{

    public Heroi(String personaName, int atak, int defe, int sped, int vidaMaxima, int expNxtLvel, int lvel, Usuario usuario) {
        super(personaName, atak, defe, sped, vidaMaxima, usuario);
    }
    
    public int atacar(Vilao alvo) {
        int dano = this.getAtak();
        int diferencaSpd = this.spdDisputa(alvo);
        if(diferencaSpd < 1){
                return 0;
        }else{
            return alvo.receberDano(dano+diferencaSpd);
        }
    }

    public int receberDano(int dano) {
        int danoFinal = dano - this.getDefe();
        if (danoFinal < 0){
            this.setVidaAtual(this.getVidaAtual()- 1);
            return danoFinal;
        } else {
            this.setVidaAtual(this.getVidaAtual()-danoFinal);
            return danoFinal;
        }
    }
    
}
