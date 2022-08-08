/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.dao;

import com.mycompany.rpglegacy.connection.DatabaseConnection;
import com.mycompany.rpglegacy.model.Heroi;
import com.mycompany.rpglegacy.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class MonstroDao {
    public void criar(Heroi heroi) throws SQLException {
        String sql = "INSERT INTO inimigos (personName, atak, defe, sped, vidaMaxima, vidaAtual, expNxtLvel, lvel, progress, id_usuario) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
        
        pstm.setString(1, heroi.getPersonName());
        pstm.setInt(2, heroi.getAtak());
        pstm.setInt(3, heroi.getAtak());
        pstm.setInt(4, heroi.getAtak());
        pstm.setInt(5, heroi.getAtak());
        pstm.setInt(6, heroi.getAtak());
        pstm.setInt(7, heroi.getAtak());
        pstm.setInt(8, heroi.getAtak());
        pstm.setInt(9, heroi.getProgress());
        pstm.setInt(10, heroi.getUsuario().getId());
        

        pstm.execute();
    }
    
    public void salvar(Heroi heroi) throws SQLException {
        String sql = "UPDATE herois SET personName=?, atak=?, defe=?, sped=?, "
                + "vidaMaxima=?, vidaAtual=?, expNxtLvel=?, lvel=?, progress=? "
                + "WHERE id=?";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
        
        pstm.setString(1, heroi.getPersonName());
        pstm.setInt(2, heroi.getAtak());
        pstm.setInt(3, heroi.getAtak());
        pstm.setInt(4, heroi.getAtak());
        pstm.setInt(5, heroi.getAtak());
        pstm.setInt(6, heroi.getAtak());
        pstm.setInt(7, heroi.getAtak());
        pstm.setInt(8, heroi.getAtak());
        pstm.setInt(9, heroi.getProgress());
        pstm.setInt(10, heroi.getId());
        

        pstm.execute();
    }
    
    public void mudarHeroiNome(String novoNome, int idHeroi) throws SQLException {
        String sql = "UPDATE herois SET personName=?"
                + "WHERE id=?";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
        
        pstm.setString(1, novoNome);
        pstm.setInt(2, idHeroi);

        pstm.execute();
    }
    
    public void deletarHeroiPorId(int idHeroi) throws SQLException {
        String sql = "DELETE FROM herois WHERE id=?";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
        
        pstm.setInt(1, idHeroi);
        
        pstm.execute();
    }
    
    public Heroi getHeroiById(int id) throws SQLException {
        String sql = "SELECT * FROM herois WHERE "
                + "id = ?";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setInt(1, id);

        ResultSet resultado = pstm.executeQuery();
        Heroi respostaFinal = null;
        
        if(resultado.next()){
            int novoId = resultado.getInt("id");
            String novoPersonName = resultado.getString("personName");
            int novoAtak = resultado.getInt("atak");
            int novoDefe = resultado.getInt("defe");
            int novoSped = resultado.getInt("sped");
            int novoVidaMaxima = resultado.getInt("vidaMaxima");
            int novoVidaAtual = resultado.getInt("vidaAtual");
            int novoExpNxtLvel = resultado.getInt("expNxtLvel");
            int novoLvel = resultado.getInt("lvel");
            int novoProgress = resultado.getInt("progress");
            Usuario novoUsuario = null;
            respostaFinal = new Heroi(novoId, novoPersonName, novoAtak, novoDefe, novoSped, novoVidaMaxima, novoVidaAtual, novoExpNxtLvel, novoLvel, novoProgress, novoUsuario);
        }
        return respostaFinal;
    }
}
