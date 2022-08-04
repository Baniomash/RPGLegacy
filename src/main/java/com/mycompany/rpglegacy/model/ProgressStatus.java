/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.model;

/**
 *
 * @author Windows10
 */
public class ProgressStatus {
    private int wordNumber;
    private int stageNumber;

    public ProgressStatus() {
        this.wordNumber = 1;
        this.stageNumber = 1;
    }

    public int getWordNumber() {
        return wordNumber;
    }

    public void setWordNumber(int wordNumber) {
        this.wordNumber = wordNumber;
    }

    public int getStageNumber() {
        return stageNumber;
    }

    public void setStageNumber(int stageNumber) {
        this.stageNumber = stageNumber;
    }

    @Override
    public String toString() {
        return wordNumber + "-" + stageNumber;
    }
    
    
    
    
}
