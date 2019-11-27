/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lpii.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * Classe responsável por realizar a conexão com o Banco de dados
 */
public class ConnectionFactory {
    
    public Connection getConnection() {
        
        // try... catch. Para tratar eventuais erros na conexão
        try {
            return DriverManager.getConnection("jdbc:mysql://br538.hostgator.com.br:3306/alexa577_trabalhoJava", "alexa577_admin", "admin");
        } catch (Exception error) {
            throw new RuntimeException(error);
        }
    }
    
}
