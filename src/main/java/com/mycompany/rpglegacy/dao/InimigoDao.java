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
        
        
        if(resultado.next()){
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
        
        if(resultado.next()){
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
        
        
        if(resultado.next()){
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
        
        while(resultado.next()){
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
        
        if(lvelMin<1){
        pstm.setInt(1, 1);
        }
        if(lvelMax<1 || lvelMax<lvelMin){
        pstm.setInt(2, lvelMin);
        }
        
        if(lvelMin>=1 && lvelMax>=lvelMin){
        pstm.setInt(1, lvelMin);      
        }
        if(lvelMax>=1 && lvelMax>=lvelMin){
        pstm.setInt(2, lvelMax);            
        }

        ResultSet resultado = pstm.executeQuery();
        ArrayList<Monstro> respostaFinal = new ArrayList();
        
        while(resultado.next()){
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
    
//    public static void main(String[] args) throws SQLException {
//        InimigoDao dao = new InimigoDao();
//        
////      Bosses
//        Vilao boss1 = new Vilao(Batalha.NOME_BOSS_1, 12, 10, 8, 340, 5, 32);
//        Vilao boss2 = new Vilao(Batalha.NOME_BOSS_2, 5, 5, 5, 5, 5, 5);
//        Vilao boss3 = new Vilao(Batalha.NOME_BOSS_3, 5, 5, 5, 5, 5, 5);
//        
////      ARANHAS =>>
//        Monstro monstro1 = new Monstro(MonsTipos.ARANHA, 14, 5, 4, 50, 1, 5);
//        Monstro monstro2 = new Monstro(MonsTipos.ARANHA, 16, 4, 3, 50, 1, 5);
//        Monstro monstro3 = new Monstro(MonsTipos.ARANHA, 14, 4, 3, 70, 1, 5);
//        Monstro monstro4 = new Monstro(MonsTipos.ARANHA, 16, 7, 6, 70, 2, 7);
//        Monstro monstro5 = new Monstro(MonsTipos.ARANHA, 18, 6, 5, 70, 2, 7);
//        Monstro monstro6 = new Monstro(MonsTipos.ARANHA, 16, 6, 5, 90, 2, 8);
//        Monstro monstro7 = new Monstro(MonsTipos.ARANHA, 18, 9, 8, 90, 3, 9);
//        Monstro monstro8 = new Monstro(MonsTipos.ARANHA, 20, 8, 7, 90, 3, 9);
//        Monstro monstro9 = new Monstro(MonsTipos.ARANHA, 18, 8, 7, 110, 3, 10);
//        Monstro monstro10 = new Monstro(MonsTipos.ARANHA, 20, 11, 10, 110, 4, 11);
//        Monstro monstro11 = new Monstro(MonsTipos.ARANHA, 22, 10, 9, 110, 4, 11);
//        Monstro monstro12 = new Monstro(MonsTipos.ARANHA, 20, 10, 9, 130, 4, 12);
//        Monstro monstro13 = new Monstro(MonsTipos.ARANHA, 22, 13, 12, 130, 5, 15);
//        Monstro monstro14 = new Monstro(MonsTipos.ARANHA, 24, 12, 11, 130, 5, 15);
//        Monstro monstro15 = new Monstro(MonsTipos.ARANHA, 22, 12, 11, 150, 5, 16);
//        
//        
////      CRIAR VILÕES NO DB =>>
//        dao.criar(boss1);
//        dao.criar(boss2);
//        dao.criar(boss3);
//        
////      CRIAR MONSTROS NO DB =>>
//        dao.criar(monstro1);
//        dao.criar(monstro2);
//        dao.criar(monstro3);
//        dao.criar(monstro4);
//        dao.criar(monstro5);
//        dao.criar(monstro6);
//        dao.criar(monstro7);
//        dao.criar(monstro8);
//        dao.criar(monstro9);
//        dao.criar(monstro10);
//        dao.criar(monstro11);
//        dao.criar(monstro12);
//        dao.criar(monstro13);
//        dao.criar(monstro14);
//        dao.criar(monstro15);
//    }
}
