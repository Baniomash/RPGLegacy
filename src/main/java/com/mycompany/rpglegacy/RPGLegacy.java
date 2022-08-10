/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.rpglegacy;

import com.mycompany.rpglegacy.controller.RPGController;
import com.mycompany.rpglegacy.view.CriarPersonagem;
import com.mycompany.rpglegacy.view.MainFrame;
import com.mycompany.rpglegacy.view.TelaPrincipal;

/**
 *
 * @author aluno
 */
public class RPGLegacy {

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        CriarPersonagem criarPersonagem = new CriarPersonagem();
        
        RPGController controller = new RPGController(mainFrame, telaPrincipal, criarPersonagem);
        
        controller.iniciaTelas();
    }
}
