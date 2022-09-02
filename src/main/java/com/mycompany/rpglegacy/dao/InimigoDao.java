/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.dao;

import com.mycompany.rpglegacy.connection.DatabaseConnection;
import com.mycompany.rpglegacy.model.Monstro;
import com.mycompany.rpglegacy.model.Vilao;
import com.mycompany.rpglegacy.util.Batalha;
import com.mycompany.rpglegacy.util.MonsTipos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class InimigoDao {

    public void criar(Vilao vilao) throws SQLException {
        String sql = "INSERT INTO inimigos (personName, atak, defe, sped, vidaMaxima, vidaAtual, lvel, expGanho) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, vilao.getPersonName());
        pstm.setInt(2, vilao.getAtak());
        pstm.setInt(3, vilao.getDefe());
        pstm.setInt(4, vilao.getSped());
        pstm.setInt(5, vilao.getVidaMaxima());
        pstm.setInt(6, vilao.getVidaAtual());
        pstm.setInt(7, vilao.getLvel());
        pstm.setInt(8, vilao.getExpGanho());

        pstm.execute();
    }

    public void criar(Monstro monstro) throws SQLException {
        String sql = "INSERT INTO inimigos (tipo, atak, defe, sped, vidaMaxima, vidaAtual, lvel, expGanho) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, monstro.getTipo());
        pstm.setInt(2, monstro.getAtak());
        pstm.setInt(3, monstro.getDefe());
        pstm.setInt(4, monstro.getSped());
        pstm.setInt(5, monstro.getVidaMaxima());
        pstm.setInt(6, monstro.getVidaAtual());
        pstm.setInt(7, monstro.getLvel());
        pstm.setInt(8, monstro.getExpGanho());

        pstm.execute();
    }

    public Vilao getVilaoPorId(int id) throws SQLException {
        String sql = "SELECT * FROM inimigos WHERE "
                + "id = ? AND personName IS NOT NULL";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setInt(1, id);

        ResultSet resultado = pstm.executeQuery();
        Vilao respostaFinal = null;

        if (resultado.next()) {
            int novoId = resultado.getInt("id");
            int novoAtak = resultado.getInt("atak");
            int novoDefe = resultado.getInt("defe");
            int novoSped = resultado.getInt("sped");
            int novoVidaMaxima = resultado.getInt("vidaMaxima");
            int novoVidaAtual = resultado.getInt("vidaAtual");
            int novoLvel = resultado.getInt("lvel");
            int novoExpGanho = resultado.getInt("expGanho");
            String novoPersonName = resultado.getString("personName");

            respostaFinal = new Vilao(novoId, novoPersonName, novoAtak, novoDefe, novoSped, novoVidaMaxima, novoVidaAtual, novoLvel, novoExpGanho);

            return respostaFinal;
        }

        return respostaFinal;
    }

    public Vilao getVilaoPorLvel(int lvel) throws SQLException {
        String sql = "SELECT * FROM inimigos WHERE "
                + "lvel = ? AND personName IS NOT NULL";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setInt(1, lvel);

        ResultSet resultado = pstm.executeQuery();
        Vilao respostaFinal = null;

        if (resultado.next()) {
            int novoId = resultado.getInt("id");
            int novoAtak = resultado.getInt("atak");
            int novoDefe = resultado.getInt("defe");
            int novoSped = resultado.getInt("sped");
            int novoVidaMaxima = resultado.getInt("vidaMaxima");
            int novoVidaAtual = resultado.getInt("vidaAtual");
            int novoLvel = resultado.getInt("lvel");
            int novoExpGanho = resultado.getInt("expGanho");
            String novoPersonName = resultado.getString("personName");

            respostaFinal = new Vilao(novoId, novoPersonName, novoAtak, novoDefe, novoSped, novoVidaMaxima, novoVidaAtual, novoLvel, novoExpGanho);

            return respostaFinal;
        }

        return respostaFinal;
    }

    public Monstro getMonstroPorId(int id) throws SQLException {
        String sql = "SELECT * FROM inimigos WHERE "
                + "id = ? AND tipo IS NOT NULL";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setInt(1, id);

        ResultSet resultado = pstm.executeQuery();
        Monstro respostaFinal = null;

        if (resultado.next()) {
            int novoId = resultado.getInt("id");
            int novoAtak = resultado.getInt("atak");
            int novoDefe = resultado.getInt("defe");
            int novoSped = resultado.getInt("sped");
            int novoVidaMaxima = resultado.getInt("vidaMaxima");
            int novoVidaAtual = resultado.getInt("vidaAtual");
            int novoLvel = resultado.getInt("lvel");
            int novoExpGanho = resultado.getInt("expGanho");
            String novoTipo = resultado.getString("tipo");

            respostaFinal = new Monstro(novoId, novoTipo, novoAtak, novoDefe, novoSped, novoVidaMaxima, novoVidaAtual, novoLvel, novoExpGanho);

            return respostaFinal;
        }

        return respostaFinal;
    }

    public List<Monstro> getMonstroPorLvel(int lvel) throws SQLException {
        String sql = "SELECT * FROM inimigos WHERE "
                + "lvel = ? AND tipo IS NOT NULL";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setInt(1, lvel);

        ResultSet resultado = pstm.executeQuery();
        ArrayList<Monstro> respostaFinal = new ArrayList();

        while (resultado.next()) {
            int novoId = resultado.getInt("id");
            int novoAtak = resultado.getInt("atak");
            int novoDefe = resultado.getInt("defe");
            int novoSped = resultado.getInt("sped");
            int novoVidaMaxima = resultado.getInt("vidaMaxima");
            int novoVidaAtual = resultado.getInt("vidaAtual");
            int novoLvel = resultado.getInt("lvel");
            int novoExpGanho = resultado.getInt("expGanho");
            String novoTipo = resultado.getString("tipo");

            Monstro monstro = new Monstro(novoId, novoTipo, novoAtak, novoDefe, novoSped, novoVidaMaxima, novoVidaAtual, novoLvel, novoExpGanho);
            respostaFinal.add(monstro);
        }

        return respostaFinal;
    }

    public List<Monstro> getMonstroPorFachaLvel(int lvelMin, int lvelMax) throws SQLException {
        String sql = "SELECT * FROM inimigos WHERE "
                + "tipo IS NOT NULL AND (lvel >= ? AND lvel <= ?)";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);

        if (lvelMin < 1) {
            pstm.setInt(1, 1);
        }
        if (lvelMax < 1 || lvelMax < lvelMin) {
            pstm.setInt(2, lvelMin);
        }

        if (lvelMin >= 1 && lvelMax >= lvelMin) {
            pstm.setInt(1, lvelMin);
        }
        if (lvelMax >= 1 && lvelMax >= lvelMin) {
            pstm.setInt(2, lvelMax);
        }

        ResultSet resultado = pstm.executeQuery();
        ArrayList<Monstro> respostaFinal = new ArrayList();

        while (resultado.next()) {
            int novoId = resultado.getInt("id");
            int novoAtak = resultado.getInt("atak");
            int novoDefe = resultado.getInt("defe");
            int novoSped = resultado.getInt("sped");
            int novoVidaMaxima = resultado.getInt("vidaMaxima");
            int novoVidaAtual = resultado.getInt("vidaAtual");
            int novoLvel = resultado.getInt("lvel");
            int novoExpGanho = resultado.getInt("expGanho");
            String novoTipo = resultado.getString("tipo");

            Monstro monstro = new Monstro(novoId, novoTipo, novoAtak, novoDefe, novoSped, novoVidaMaxima, novoVidaAtual, novoLvel, novoExpGanho);
            respostaFinal.add(monstro);
        }

        return respostaFinal;
    }

    public static void main(String[] args) throws SQLException {
        InimigoDao dao = new InimigoDao();

//      Bosses
        Vilao boss1 = new Vilao(Batalha.NOME_BOSS_1, 12, 8, 10, 230, 5, 30);
        Vilao boss2 = new Vilao(Batalha.NOME_BOSS_2, 16, 14, 14, 270, 7, 55);
        Vilao boss3 = new Vilao(Batalha.NOME_BOSS_3, 22, 18, 20, 310, 9, 80);
        Vilao boss4 = new Vilao(Batalha.NOME_BOSS_4, 24, 20, 22, 500, 12, 300);

//      ARANHAS =>>
        Monstro monstro1 = new Monstro(MonsTipos.ARANHA, 10, 4, 5, 50, 1, 6);
        Monstro monstro2 = new Monstro(MonsTipos.ARANHA, 12, 5, 4, 50, 1, 6);
        Monstro monstro3 = new Monstro(MonsTipos.ARANHA, 10, 3, 4, 70, 1, 6);
        Monstro monstro4 = new Monstro(MonsTipos.ARANHA, 12, 6, 7, 70, 2, 8);
        Monstro monstro5 = new Monstro(MonsTipos.ARANHA, 14, 5, 6, 70, 2, 8);
        Monstro monstro6 = new Monstro(MonsTipos.ARANHA, 12, 5, 6, 90, 2, 9);
        Monstro monstro7 = new Monstro(MonsTipos.ARANHA, 14, 8, 9, 90, 3, 9);
        Monstro monstro8 = new Monstro(MonsTipos.ARANHA, 16, 7, 8, 90, 3, 9);
        Monstro monstro9 = new Monstro(MonsTipos.ARANHA, 14, 7, 8, 110, 3, 10);
        Monstro monstro10 = new Monstro(MonsTipos.ARANHA, 16, 10, 11, 110, 4, 11);
        Monstro monstro11 = new Monstro(MonsTipos.ARANHA, 18, 9, 10, 110, 4, 11);
        Monstro monstro12 = new Monstro(MonsTipos.ARANHA, 18, 12, 13, 130, 5, 13);

//      COISAS DA FLORESTA =>>        
        Monstro monstro13 = new Monstro(MonsTipos.COISA_FLORESTA, 14, 8, 3, 150, 3, 11);
        Monstro monstro14 = new Monstro(MonsTipos.COISA_FLORESTA, 15, 7, 3, 150, 3, 11);
        Monstro monstro15 = new Monstro(MonsTipos.COISA_FLORESTA, 12, 10, 3, 150, 3, 11);
        Monstro monstro16 = new Monstro(MonsTipos.COISA_FLORESTA, 16, 10, 5, 170, 4, 13);
        Monstro monstro17 = new Monstro(MonsTipos.COISA_FLORESTA, 18, 12, 7, 190, 5, 15);
        Monstro monstro18 = new Monstro(MonsTipos.COISA_FLORESTA, 16, 14, 7, 190, 5, 15);
        Monstro monstro19 = new Monstro(MonsTipos.COISA_FLORESTA, 22, 12, 5, 210, 6, 17);
        Monstro monstro20 = new Monstro(MonsTipos.COISA_FLORESTA, 22, 16, 9, 250, 7, 19);

//      LAGARTOS =>>
        Monstro monstro21 = new Monstro(MonsTipos.LAGARTO_TOXICO, 15, 8, 18, 130, 5, 11);
        Monstro monstro22 = new Monstro(MonsTipos.LAGARTO_TOXICO, 13, 8, 18, 130, 5, 11);
        Monstro monstro23 = new Monstro(MonsTipos.LAGARTO_TOXICO, 12, 8, 21, 130, 5, 11);
        Monstro monstro24 = new Monstro(MonsTipos.LAGARTO_TOXICO, 16, 10, 21, 150, 6, 13);
        Monstro monstro25 = new Monstro(MonsTipos.LAGARTO_TOXICO, 18, 12, 23, 170, 7, 15);

//      LOBISOMENS =>>
        Monstro monstro26 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 15, 20, 17, 180, 7, 18);
        Monstro monstro27 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 17, 18, 16, 190, 7, 20);
        Monstro monstro28 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 16, 19, 14, 200, 7, 22);
        Monstro monstro29 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 16, 22, 18, 210, 8, 24);
        Monstro monstro30 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 18, 24, 20, 230, 9, 26);
        
        Monstro monstro32 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 22, 24, 21, 260, 10, 26);
        Monstro monstro33 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 20, 26, 22, 250, 10, 26);
        Monstro monstro34 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 24, 26, 23, 280, 11, 26);
        Monstro monstro35 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 22, 28, 24, 270, 11, 26);
        Monstro monstro36 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 26, 28, 25, 300, 12, 26);
        Monstro monstro37 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 24, 30, 26, 290, 12, 27);
        Monstro monstro38 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 28, 30, 27, 320, 13, 27);
        Monstro monstro39 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 26, 32, 28, 310, 13, 27);
        Monstro monstro40 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 30, 32, 29, 340, 14, 27);
        Monstro monstro41 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 28, 34, 30, 330, 14, 28);
        Monstro monstro42 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 32, 34, 31, 360, 15, 28);
        Monstro monstro43 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 30, 36, 32, 350, 15, 28);
        Monstro monstro44 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 34, 36, 33, 380, 16, 29);
        Monstro monstro45 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 32, 38, 34, 370, 16, 29);
        Monstro monstro46 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 36, 38, 35, 400, 17, 29);
        Monstro monstro47 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 34, 40, 36, 390, 17, 30);
        Monstro monstro48 = new Monstro(MonsTipos.LOBISOMEN_SANGUINARIO, 38, 40, 37, 420, 18, 30);
        
//      UNDEAD:
        Monstro monstro31 = new Monstro(MonsTipos.HEROI_MORTO_VIVO, 29, 15, 18, 410, 12, 101);

//      CRIAR VILÕES NO DB =>>
        dao.criar(boss1);
        dao.criar(boss2);
        dao.criar(boss3);
        dao.criar(boss4);

//      CRIAR MONSTROS NO DB =>>
        dao.criar(monstro1);
        dao.criar(monstro2);
        dao.criar(monstro3);
        dao.criar(monstro4);
        dao.criar(monstro5);
        dao.criar(monstro6);
        dao.criar(monstro7);
        dao.criar(monstro8);
        dao.criar(monstro9);
        dao.criar(monstro10);
        dao.criar(monstro11);
        dao.criar(monstro12);
        dao.criar(monstro13);
        dao.criar(monstro14);
        dao.criar(monstro15);
        dao.criar(monstro16);
        dao.criar(monstro17);
        dao.criar(monstro18);
        dao.criar(monstro19);
        dao.criar(monstro20);
        dao.criar(monstro21);
        dao.criar(monstro22);
        dao.criar(monstro23);
        dao.criar(monstro24);
        dao.criar(monstro25);
        dao.criar(monstro26);
        dao.criar(monstro27);
        dao.criar(monstro28);
        dao.criar(monstro29);
        dao.criar(monstro30);
        dao.criar(monstro31);
    }
}
