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
        pstm.setInt(3, monstro.getAtak());
        pstm.setInt(4, monstro.getAtak());
        pstm.setInt(5, monstro.getAtak());
        pstm.setInt(6, monstro.getAtak());
        pstm.setInt(7, monstro.getAtak());        
        pstm.setInt(8, monstro.getExpGanho());        

        pstm.execute();
    }
    
    public Vilao getVilaoPorId(int id) throws SQLException {
        String sql = "SELECT * FROM herois WHERE "
                + "id = ?";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setInt(1, id);

        ResultSet resultado = pstm.executeQuery();
        Vilao respostaFinal = null;
        
        
        if(resultado.next() && resultado.getString("tipo") == null){
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
        String sql = "SELECT * FROM herois WHERE "
                + "id = ?";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setInt(1, id);

        ResultSet resultado = pstm.executeQuery();
        Monstro respostaFinal = null;
        
        
        if(resultado.next() && resultado.getString("personName") == null){
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
}
