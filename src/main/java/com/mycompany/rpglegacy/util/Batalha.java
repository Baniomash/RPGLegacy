/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.rpglegacy.util;

/**
 *
 * @author aluno
 */
public interface Batalha {

    public static final String HEROI = "heroi";
    public static final String VILAO = "vilao";
    public static final String MONSTROS = "monstros";
    public static final String MONSTRO_1 = "monstro1";
    public static final String MONSTRO_2 = "monstro2";
    public static final String MONSTRO_3 = "monstro3";
    public static final String BATALHA_FACIL = "batalhaFacil";
    public static final String BATALHA_MEDIA = "batalhaMedia";
    public static final String BATALHA_DIFICIL = "batalhaDificil";

    public static final String BATALHANDO = "Btalha esta acontecendo!";
    public static final String BATALHA_ENCERRADA_HEROI_MORREU = "Heroi morreu!";
    public static final String BATALHA_ENCERRADA_HEROI_DESISTIU = "Heroi desistiu!";
    public static final String BATALHA_ENCERRADA_HEROI_VENCEU_MONSTRO = "Heroi Venceu Monstro!";
    public static final String BATALHA_ENCERRADA_HEROI_VENCEU_BATALHA = "Heroi Venceu Batalha!";
    
    // BATALHA -- 1
    public static final String NOME_MUNDO_FASE_1 = "FLORESTA TENEBROSA";
    public static final String DESCRICAO_BATALHA_1 = "<html>Ao entrar na floresta, você vê 3 caminhos.<br>Você vai seguir o caminho cercado por:</html>";
    public static final String BATALHA_1_OPCAO_1 = "Arbustos";
    public static final String BATALHA_1_OPCAO_2 = "Pedras";
    public static final String BATALHA_1_OPCAO_3 = "Árvores";

    // BATALHA -- 2
    public static final String NOME_MUNDO_FASE_2 = "FLORESTA TENEBROSA";
    public static final String DESCRICAO_BATALHA_2 = "<html>Após uma batalha memorável na floresta, você se depara novamente com 3 possibilidades.<br>Qual o rumo que sua jornada deverá tomar?:</html>";
    public static final String BATALHA_2_OPCAO_1 = "Arbustos";
    public static final String BATALHA_2_OPCAO_2 = "Pedras";
    public static final String BATALHA_2_OPCAO_3 = "Árvores";

    // BATALHA -- 3
    public static final String NOME_MUNDO_FASE_3 = "FLORESTA TENEBROSA";
    public static final String DESCRICAO_BATALHA_3 = "<html>Um desafio maior te aguarda a frente, prossiga sua jornada.</html>";
    public static final String NOME_BOSS_1 = "1° Ministro Ithaurus O Indígno";


    // BATALHA -- 4
    public static final String NOME_MUNDO_FASE_4 = "CIDADE ASSOMBRADA";
    public static final String DESCRICAO_BATALHA_4 = "<html>Ao entrar na cidade, você vê 3 caminhos.<br>Você ira seguir por:</html>";
    public static final String BATALHA_4_OPCAO_1 = "Rua Escura";
    public static final String BATALHA_4_OPCAO_2 = "Bairro Pobre";
    public static final String BATALHA_4_OPCAO_3 = "Porto";

    // BATALHA -- 5
    public static final String NOME_MUNDO_FASE_5 = "CIDADE ASSOMBRADA";
    public static final String DESCRICAO_BATALHA_5 = "<html>Após uma batalha árdua, você prossegue pela cidade.<br>Mais adiante se depara com 3 possibilidades, e escolhe seguir por:</html>";
    public static final String BATALHA_5_OPCAO_1 = "Rua estreita";
    public static final String BATALHA_5_OPCAO_2 = "Cais do porto";
    public static final String BATALHA_5_OPCAO_3 = "Casa misteriosa";

    // BATALHA -- 6
    public static final String NOME_MUNDO_FASE_6 = "CIDADE ASSOMBRADA";
    public static final String DESCRICAO_BATALHA_6 = "<html>O maior desafio da cidade está adiante...</html>";
    public static final String NOME_BOSS_2 = "2° Ministro Maltus O Executor";

    // BATALHA -- 7
    public static final String NOME_MUNDO_FASE_7 = "CASTELO APODRECIDO";
    public static final String DESCRICAO_BATALHA_7 = "<html>Chegando ao castelo, logo de cara, há 3 escolhas a se fazer.<br>Qual a sua escolha?</html>";
    public static final String BATALHA_7_OPCAO_1 = "Seguir em frente";
    public static final String BATALHA_7_OPCAO_2 = "Virar a esquerda";
    public static final String BATALHA_7_OPCAO_3 = "Virar a direita";

    // BATALHA -- 8
    public static final String NOME_MUNDO_FASE_8 = "CASTELO APODRECIDO";
    public static final String DESCRICAO_BATALHA_8 = "<html>Ainda no castelo, você vê 3 caminhos.<br>Você vai seguir seu instinto e vai:</html>";
    public static final String BATALHA_8_OPCAO_1 = "Abrir porta";
    public static final String BATALHA_8_OPCAO_2 = "Dar meia volta";
    public static final String BATALHA_8_OPCAO_3 = "Ir a masmorra";

    // BATALHA -- 9
    public static final String NOME_MUNDO_FASE_9 = "CASTELO APODRECIDO";
    public static final String DESCRICAO_BATALHA_9 = "<html>Somente os corajosos irão prosseguir...</html>";
    public static final String NOME_BOSS_3 = "3° Ministro Letholdus O Traidor";

    // BATALHA -- 10
    public static final String NOME_MUNDO_FASE_10 = "SALA DO TRONO REAL";
    public static final String DESCRICAO_BATALHA_10 = "<html>Você chegou a sala do trono.<br>Há 3 opções a se escolher aqui:</html>";
    public static final String BATALHA_10_OPCAO_1 = "Ir até o trono";
    public static final String BATALHA_10_OPCAO_2 = "Vasculhar a sala";
    public static final String BATALHA_10_OPCAO_3 = "Checar um baú";

    // BATALHA -- 11
    public static final String NOME_MUNDO_FASE_11 = "SALA DO TRONO REAL";
    public static final String DESCRICAO_BATALHA_11 = "<html>A sala do trono reserva mais desafios<br>Há 3 opções a se escolher aqui:</html>";
    public static final String BATALHA_11_OPCAO_1 = "Ir até o trono";
    public static final String BATALHA_11_OPCAO_2 = "Vasculhar a sala";
    public static final String BATALHA_11_OPCAO_3 = "Sair";

    // BATALHA -- 12
    public static final String NOME_MUNDO_FASE_12 = "SALA DO TRONO REAL";
    public static final String DESCRICAO_BATALHA_12 = "<html>O maior desafio de sua jornada está bem a frente!</html>";
    public static final String NOME_BOSS_4 = "O Rei Apodrecido";
    
    
}
