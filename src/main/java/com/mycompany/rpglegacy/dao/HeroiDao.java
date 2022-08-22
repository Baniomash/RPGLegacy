/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.dao;

import com.mycompany.rpglegacy.connection.DatabaseConnection;
import com.mycompany.rpglegacy.model.Heroi;
import com.mycompany.rpglegacy.model.Progress;
import com.mycompany.rpglegacy.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Windows10
 */
public class HeroiDao {
    private UsuarioDao dao = new UsuarioDao();
    
    public Boolean criar(Heroi heroi) throws SQLException {
        Heroi heroiNomeIgual = this.getHeroiPorPersonNameEIdUsuario(heroi.getPersonName(), heroi.getUsuario().getId());
        List<Heroi> listaHeroisUsuario = this.getHeroisPorIdUsuario(heroi.getUsuario().getId());
        if(heroiNomeIgual != null){
            return false;
        } else if(listaHeroisUsuario.size()>4){
            return false;
        }
        
        String sql = "INSERT INTO herois (personName, atak, defe, sped, vidaMaxima, vidaAtual, expNxtLvel, lvel, progress, id_usuario) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
        
        pstm.setString(1, heroi.getPersonName());
        pstm.setInt(2, heroi.getAtak());
        pstm.setInt(3, heroi.getDefe());
        pstm.setInt(4, heroi.getSped());
        pstm.setInt(5, heroi.getVidaMaxima());
        pstm.setInt(6, heroi.getVidaAtual());
        pstm.setInt(7, heroi.getExpNxtLvel());
        pstm.setInt(8, heroi.getLvel());
        pstm.setInt(9, heroi.getProgress().getValor());
        pstm.setInt(10, heroi.getUsuario().getId());
        

        pstm.execute();
        return true;
    }
    
    public void salvar(Heroi heroi) throws SQLException {
        String sql = "UPDATE herois SET atak=?, defe=?, sped=?, "
                + "vidaMaxima=?, vidaAtual=?, expNxtLvel=?, lvel=?, progress=? "
                + "WHERE id=?";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
        
        pstm.setInt(1, heroi.getAtak());
        pstm.setInt(2, heroi.getDefe());
        pstm.setInt(3, heroi.getSped());
        pstm.setInt(4, heroi.getVidaMaxima());
        pstm.setInt(5, heroi.getVidaAtual());
        pstm.setInt(6, heroi.getExpNxtLvel());
        pstm.setInt(7, heroi.getLvel());
        pstm.setInt(8, heroi.getProgress().getValor());
        pstm.setInt(9, heroi.getId());
        

        pstm.execute();
    }
    
    public Boolean mudarHeroiNome(String novoNome, int idHeroi) throws SQLException {
        Heroi heroiOriginal = this.getHeroiPorId(idHeroi);
        Heroi heroiNomeIgual = this.getHeroiPorPersonNameEIdUsuario(novoNome, heroiOriginal.getUsuario().getId());
        if(heroiNomeIgual != null){
            return false;
        }
        String sql = "UPDATE herois SET personName=?"
                + "WHERE id=?";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, novoNome);
        pstm.setInt(2, idHeroi);

        pstm.execute();
        return true;
    }
    
    public void deletarHeroiPorId(int idHeroi) throws SQLException {
        String sql = "DELETE FROM herois WHERE id=?";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
        
        pstm.setInt(1, idHeroi);
        
        pstm.execute();
    }
    
    public Heroi getHeroiPorId(int id) throws SQLException {
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
            Progress novoProgress = new Progress(resultado.getInt("progress"));
            Usuario novoUsuario = dao.getUsuarioPorId(resultado.getInt("id_usuario"));
            
            respostaFinal = new Heroi(novoId, novoPersonName, novoAtak, novoDefe, novoSped, novoVidaMaxima, novoVidaAtual, novoExpNxtLvel, novoLvel, novoProgress, novoUsuario);
        }
        return respostaFinal;
    }
    public Heroi getHeroiPorPersonNameEIdUsuario(String personName, int idUsuario) throws SQLException {
        String sql = "SELECT * FROM herois WHERE "
                + "personName = ? AND id_usuario = ?";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
        
        pstm.setString(1, personName);
        pstm.setInt(2, idUsuario);

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
            Progress novoProgress = new Progress(resultado.getInt("progress"));
            Usuario novoUsuario = dao.getUsuarioPorId(resultado.getInt("id_usuario"));
            
            respostaFinal = new Heroi(novoId, novoPersonName, novoAtak, novoDefe, novoSped, novoVidaMaxima, novoVidaAtual, novoExpNxtLvel, novoLvel, novoProgress, novoUsuario);
        }
        return respostaFinal;
    }
    
    public List getHeroisPorIdUsuario(int idUsuario) throws SQLException {
        String sql = "SELECT * FROM herois WHERE "
                + "id_usuario = ?";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setInt(1, idUsuario);

        ResultSet resultado = pstm.executeQuery();
        ArrayList<Heroi> respostaFinal = new ArrayList();
        
        while(resultado.next()){
            int novoId = resultado.getInt("id");
            String novoPersonName = resultado.getString("personName");
            int novoAtak = resultado.getInt("atak");
            int novoDefe = resultado.getInt("defe");
            int novoSped = resultado.getInt("sped");
            int novoVidaMaxima = resultado.getInt("vidaMaxima");
            int novoVidaAtual = resultado.getInt("vidaAtual");
            int novoExpNxtLvel = resultado.getInt("expNxtLvel");
            int novoLvel = resultado.getInt("lvel");
            Progress novoProgress = new Progress(resultado.getInt("progress"));
            Usuario novoUsuario = dao.getUsuarioPorId(resultado.getInt("id_usuario"));
            
            Heroi heroi = new Heroi(novoId, novoPersonName, novoAtak, novoDefe, novoSped, novoVidaMaxima, novoVidaAtual, novoExpNxtLvel, novoLvel, novoProgress, novoUsuario);
            respostaFinal.add(heroi); 
        }
        return respostaFinal;
    }
}
