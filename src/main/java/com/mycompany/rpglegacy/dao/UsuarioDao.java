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
public class UsuarioDao {
    private final String SALT = "Increment";
    
    public void criar(Usuario user) throws SQLException {
        String sql = "INSERT INTO usuarios (login, senha) "
                + "VALUES (?, SHA2(?, 256))";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, user.getLogin());
        pstm.setString(2, user.getSenha() + SALT);

        pstm.execute();
    }
    
public void mudarUsuarioNome(String novoNome, int idUsuario) throws SQLException {
        String sql = "UPDATE usuarios SET login=?"
                + "WHERE id=?";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
        
        pstm.setString(1, novoNome);
        pstm.setInt(2, idUsuario);

        pstm.execute();
    }
    
    public Usuario getUsuarioPorId(int idUsuario) throws SQLException{
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        
        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);
        
        pstm.setInt(1, idUsuario);
        
        ResultSet resposta = pstm.executeQuery();
        Usuario usuarioResposta = null;
        
        if (resposta.next()){
        
            String novoLogin = resposta.getString("login");
            String novoSenha = resposta.getString("senha");
            int novoId = resposta.getInt("id");
            usuarioResposta = new Usuario(novoId, novoLogin, novoSenha);
        }
        
        return usuarioResposta;
    }
    
    public Boolean validarLogin(String login, String senha) throws SQLException {
        String sql = "SELECT * FROM usuarios WHERE "
                + "login = ? AND senha = SHA2(?, 256)";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, login);
        pstm.setString(2, senha + SALT);

        ResultSet resultado = pstm.executeQuery();
        
        return resultado.next();
    }
    
    public static void main(String[] args) throws SQLException {
        UsuarioDao usuarioDao = new UsuarioDao();
        HeroiDao heroiDao = new HeroiDao();
        
//        Usuario novoUsuario1 = new Usuario( "User1", "yoyo");
//        Usuario novoUsuario2 = new Usuario( "Caba_Bom", "123456");

//        Heroi editaHeroi1 = heroiDao.getHeroiById(1) ;
//        editaHeroi1.setPersonName("Sr. MudaNome");
//  
//        usuarioDao.salvar(novoUsuario1);
//        usuarioDao.salvar(novoUsuario2);
//        heroiDao.salvar(editaHeroi1);
//        usuarioDao.mudarUsuarioNome("Cabeça de arupemba", 2);

//        heroiDao.mudarHeroiNome("Sr. Cavalheiro", 1);
//        heroiDao.deletarHeroiPorId(2);
        
        System.out.println(usuarioDao.validarLogin("User1", "fasvjvbjkasbvja"));
        System.out.println(usuarioDao.validarLogin("User1", "yoyo"));
        System.out.println(heroiDao.getHeroiPorId(1).getPersonName());
        System.out.println(usuarioDao.getUsuarioPorId(2).getLogin());
    }
}
