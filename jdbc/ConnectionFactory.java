/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lpii.jdbc;

import java.sql.*;

/**
 *
 * Classe responsável por realizar a conexão com o Banco de dados
 */
public class ConnectionFactory {
    
    public Connection getConnection() {
        
        // try... catch. Para tratar eventuais erros na conexão
        try {
            return DriverManager.getConnection("jdbc:mysql://br538.hostgator.com.br:3306/alexa577_trabalhoJava", "alexa577_admin", "admin");
            //return DriverManager.getConnection("jdbc:oracle:thin:@200.132.53.144:1521:XEpdb1", "usr35", "usr35");
        } catch (Exception error) {
            throw new RuntimeException(error);
        }
    }
    
}
