/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.model;

import java.util.Random;

/**
 *
 * @author aluno
 */
public class Monstro {
    private int id;
    private String tipo;
    private int atak;
    private int defe;
    private int sped;
    private int vidaMaxima;
    private int vidaAtual;
    private int lvel;
    private int expGanho;

    public Monstro(int id, String tipo, int atak, int defe, int sped, int vidaMaxima, int vidaAtual, int lvel, int expGanho) {
        this.id = id;
        this.tipo = tipo;
        this.atak = atak;
        this.defe = defe;
        this.sped = sped;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaAtual;
        this.lvel = lvel;
        this.expGanho = expGanho;
    }

    public Monstro(String tipo, int atak, int defe, int sped, int vidaMaxima, int lvel, int expGanho) {
        this.tipo = tipo;
        this.atak = atak;
        this.defe = defe;
        this.sped = sped;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = vidaMaxima;
        this.lvel = lvel;
        this.expGanho = expGanho;
    }

    public int atacar(Heroi alvo) {
        int dano = (int) (this.getAtak() * 1.2);
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
    
    public int spdDisputa(Personagem alvo){
        Random rng = new Random();
        int difSped = this.sped-alvo.getSped();
        if(((difSped-alvo.getSped())*-1) >= (rng.nextInt(100))){
            return 0;
        }else{
            if(difSped<1){
                return ((difSped%10)*-1)+rng.nextInt(7);
            }else{
                return difSped%10+rng.nextInt(7);
            }
        }
    }
    
    public boolean estaVivo(){
        return this.getVidaAtual() > 0;
    }
    
    public String status() {
        String saida = "";
        saida += this.tipo;
        saida += ": " + this.vidaAtual + "/" +
                this.vidaMaxima;
        return saida;
    }
    
    public int getAtak() {
        return atak;
    }

    public void setAtak(int atak) {
        this.atak = atak;
    }

    public int getDefe() {
        return defe;
    }

    public void setDefe(int defe) {
        this.defe = defe;
    }

    public int getSped() {
        return sped;
    }

    public void setSped(int sped) {
        this.sped = sped;
    }

    public int getVidaMaxima() {
        return vidaMaxima;
    }

    public void setVidaMaxima(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
    }

    public int getVidaAtual() {
        return vidaAtual;
    }

    public void setVidaAtual(int vidaAtual) {
        if (vidaAtual < 0){
            this.vidaAtual = 0;
        } else {
            this.vidaAtual = vidaAtual;
        }
    }

    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public int getLvel() {
        return lvel;
    }

    public int getExpGanho() {
        return expGanho;
    }
    
    
}
