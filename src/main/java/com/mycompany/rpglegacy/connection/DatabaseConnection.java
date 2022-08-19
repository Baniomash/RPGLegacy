/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.rpglegacy.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author aluno
 */
public class DatabaseConnection {
    
    private static final String host = "jdbc:mysql://localhost/RPGLegacy";
    private static final String user = "root";
    private static final String password = "ifrn.cn";
//    private static final String password = "";
//    private static final String password = "ZICO509";
    private static Connection conexao = null;

    // Padrão Singleton
    private DatabaseConnection() {
    }

    public static Connection getConnection() throws SQLException {
        if (conexao == null) {
            conexao = DriverManager.
                    getConnection(host, user, password);
        }
        return conexao;
    }
}
