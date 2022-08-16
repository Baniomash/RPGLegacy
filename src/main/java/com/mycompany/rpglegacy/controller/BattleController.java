/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.controller;

import com.mycompany.rpglegacy.model.Battle;
import com.mycompany.rpglegacy.model.Heroi;
import com.mycompany.rpglegacy.model.Monstro;
import com.mycompany.rpglegacy.model.Vilao;
import java.util.List;

/**
 *
 * @author aluno
 */
public class BattleController {
    private Battle batalha;

    public BattleController() {

    }
    
    
    
    public void iniciaTelas(){
        
    }
    
    public void iniciarBatalha(Heroi heroi, List<Monstro> monstros) {
        this.batalha = new Battle(heroi, monstros);
    }

    public void iniciarBatalha(Heroi heroi, Vilao boss) {
        this.batalha = new Battle(heroi, boss);
    }

    public Battle getBatalha() {
        return batalha;
    }
}
