/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.dao;

import com.mycompany.rpglegacy.connection.DatabaseConnection;
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
    
    public void save(Usuario user) throws SQLException {
        String sql = "INSERT INTO usuarios (login, senha) "
                + "VALUES (?, SHA2(?, 256))";

        Connection con = DatabaseConnection.getConnection();
        PreparedStatement pstm = con.prepareStatement(sql);

        pstm.setString(1, user.getLogin());
        pstm.setString(2, user.getSenha() + SALT);

        pstm.execute();
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
        UsuarioDao dao = new UsuarioDao();
        
        Usuario novoUsuario1 = new Usuario( "User1", "yoyo");
        Usuario novoUsuario2 = new Usuario( "Caba_Bom", "123456");
        
        dao.save(novoUsuario1);
        dao.save(novoUsuario2);
        
        System.out.println(dao.validarLogin("User1", "fasvjvbjkasbvja"));
        System.out.println(dao.validarLogin("User1", "yoyo"));
    }
}
