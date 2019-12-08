/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lpii.jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre Lima
 */
public class TesteConexao {
    
    public static void main(String[] args) {
        try {
            
            new ConnectionFactory().getConnection();
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");
            
        } catch (Exception erro) {
            
            JOptionPane.showMessageDialog(null, "Ops! Aconteceu o erro: " + erro);
            
        }
    }
    
}
