/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lpii.dao;

import br.com.lpii.jdbc.ConnectionFactory;
import br.com.lpii.model.AreaInteresse;
import br.com.lpii.model.Proposta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre Lima
 */
public class AreaInteresseDAO {
    // Atributo para conexão
    private Connection con;

    // Construtor
    public AreaInteresseDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

//    // Método para cadastro de propostas
//    public void cadastrarProposta(Proposta proposta) {
//
//    }

//    public void alterarProposta(Proposta proposta) {
//
//      
//    }
//
//    public void excluirAluno(Proposta proposta) {
//
//    }
//
//    public List<Proposta> listarPropostas() {
//
//
//    }
//    
//    public List<Proposta> listarMinhasPropostas(int id) {
//
//    }
//
//    public List<Proposta> buscarPropostas(String param) {
//
//
//    }
//
//    public boolean verificaProposta(int id) {
//  
//    
//    }
//
    public AreaInteresse getAreaInteresse(int id) {
         
        AreaInteresse ai = new AreaInteresse();
        
        try {
            // Verifica se existe o usuário no banco
            String sql = "SELECT * FROM area_interesse WHERE id_area_interesse = ?";
            // prepara sql para execução
            PreparedStatement stmt = con.prepareStatement(sql);
            // o resultado do select é armazenada em um objeto ResultSet
            stmt.setInt(1, id);

            // Armazena o resultado
            ResultSet rs = stmt.executeQuery();

            // verifica se encontrou
            if (rs.next()) {
                // É setado os atributos. Os parâmetros do get são os nomes das colunas
                ai.setId_area_interesse(id);
                ai.setNome(rs.getString("nome"));
            }
            return ai;    

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "Erro sql: " + error);
            return null;
        }
        
    }
}
