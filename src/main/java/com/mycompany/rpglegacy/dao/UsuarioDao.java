/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.dao;

import com.mycompany.rpglegacy.connection.DatabaseConnection;
import com.mycompany.rpglegacy.model.Heroi;
import com.mycompany.rpglegacy.model.Monstro;
import com.mycompany.rpglegacy.model.Usuario;
import com.mycompany.rpglegacy.model.Vilao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
        InimigoDao inimigoDao = new InimigoDao();
        
        Usuario novoUsuario1 = new Usuario( "User1", "yoyo");
        Usuario novoUsuario2 = new Usuario( "Caba_Bom", "123456");
        Vilao novoVilao1 = new Vilao("Rei Malvado", 5, 5, 5, 150, 5, 24);
        Monstro novoMonstro1 = new Monstro("aranha_da_caverna", 5, 5, 5, 90, 4, 7);
        Monstro novoMonstro2 = new Monstro("lobo_sanguinario", 5, 5, 5, 90, 3, 7);
        

//  
        inimigoDao.criar(novoVilao1);
        inimigoDao.criar(novoMonstro1);
        inimigoDao.criar(novoMonstro2);
        usuarioDao.criar(novoUsuario1);
        usuarioDao.criar(novoUsuario2);
        
        
        Usuario usuarioSQL = usuarioDao.getUsuarioPorId(1);
        Heroi novoHeroi1 = new Heroi("Sr. TopanHead", 5, 5, 5, 150, usuarioSQL);
        Heroi novoHeroi2 = new Heroi("Sr. Heroizaum", 5, 4, 6, 170, usuarioSQL);
        
        
        heroiDao.criar(novoHeroi1);
        heroiDao.criar(novoHeroi2);
        usuarioDao.mudarUsuarioNome("Cabeça de arupemba", 2);

        heroiDao.mudarHeroiNome("Sr. Cavalheiro", 1);
        heroiDao.deletarHeroiPorId(2);
        
        System.out.println(usuarioDao.getUsuarioPorId(1).getLogin());
        System.out.println(usuarioDao.validarLogin("User1", "fasvjvbjkasbvja"));
        System.out.println(usuarioDao.validarLogin("User1", "yoyo"));
        System.out.println(heroiDao.getHeroiPorId(1).getPersonName());
        System.out.println(heroiDao.getHeroiPorId(1).getProgress());
        System.out.println(usuarioDao.getUsuarioPorId(2).getLogin());
        System.out.println(inimigoDao.getVilaoPorLvel(5).getPersonName());
        System.out.println(inimigoDao.getMonstroPorId(2).getTipo());
//        System.out.println(inimigoDao.getMonstroPorFachaLvel(2, 5));
        List<Monstro> listaMonstros = inimigoDao.getMonstroPorFachaLvel(2, 5);
        for(Monstro monAtual : listaMonstros){
            System.out.println(monAtual.getTipo());
        }
    }
}
