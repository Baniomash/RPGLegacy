/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.model;

/**
 *
 * @author aluno
 */
public class Progress {
    private int mundo;
    private int fase;
    private int valor;

    public Progress(int world, int stage, int valor) {
        this.mundo = world;
        this.fase = stage;
        this.valor = valor;
    }
    
    public Progress() {
        this.valor = 1;
        verificaProgresso();
        
    }
    
    public Progress(int progress) {
        this.valor = progress;
        verificaProgresso();
    }

    public int getMundo() {
        return mundo;
    }


    public int getFase() {
        return fase;
    }


    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public void aumentaValor(){
        this.valor ++;
        verificaProgresso();
    }

    private void verificaProgresso() {
        if(valor < 1){
            this.valor = 1;
            verificaProgresso();
        }else if(valor > 12){
            this.valor = 12;
            verificaProgresso();
        }else{
            int world = (int) ((valor-1)/3)+1;
            int stage = ((valor-1)%3)+1;

            this.mundo = world;
            this.fase = stage;
        }
    }

    @Override
    public String toString() {
        return mundo + "-" + fase;
    }
    
}
