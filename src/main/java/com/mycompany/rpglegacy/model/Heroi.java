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
    private int expNxtLvel;
    private Progress progress;
    private Usuario usuario;
    
    public Heroi(String personaName, int atak, int defe, int sped, int vidaMaxima, Usuario usuario) {
        super(personaName, atak, defe, sped, vidaMaxima);
        this.usuario = usuario;
        this.expNxtLvel = 0;
        this.progress = new Progress();
    }

    public Heroi(int id, String personName, int atak, int defe, int sped, int vidaMaxima, int vidaAtual, int expNxtLvel, int lvel, Progress progress, Usuario usuario) {
        super(id, personName, atak, defe, sped, vidaMaxima, vidaAtual, lvel);
        this.usuario = usuario;
        this.expNxtLvel = expNxtLvel;
        this.progress = progress;
    }
    
    public boolean setLvel(){
        int upLvelRule = (int) ((this.getLvel()*10)/2);
        if(expNxtLvel>= upLvelRule){
            int lvelAtual = this.getLvel();
            this.setLvel(lvelAtual++);
            this.expNxtLvel = this.expNxtLvel - upLvelRule;
            setLvel();
            return true;
        }
        return false;
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    
    public int getExpNxtLvel() {
        return expNxtLvel;
    }

    public void setExpNxtLvel(int expAdicional) {
        this.expNxtLvel += expAdicional;
        this.setLvel();
    }
    

    public Progress getProgress() {
        return progress;
    }

    public void setProgress(Progress progress) {
        this.progress = progress;
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
    public int atacar(Monstro alvo) {
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

    @Override
    public String toString() {
        int dif = 24 - this.getPersonName().length();
        String separa = " ";
        if(dif>0){
            for(int i=1; i<dif; i++){
                separa += " ";
            }
        }
        return this.getPersonName()+ separa + this.getLvel() + "          " + progress;
    }
    
}
