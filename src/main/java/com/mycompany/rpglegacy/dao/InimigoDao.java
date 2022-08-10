/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.dao;

import com.mycompany.rpglegacy.connection.DatabaseConnection;
import com.mycompany.rpglegacy.model.Monstro;
import com.mycompany.rpglegacy.model.Vilao;
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
                + "tipo IS NOT NULL AND (lvel >= ? OR lvel <= ?)";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setInt(1, lvelMin);
        pstm.setInt(2, lvelMax);

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
}