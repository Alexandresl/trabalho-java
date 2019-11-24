/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lpii.dao;

import br.com.lpii.jdbc.ConnectionFactory;
import br.com.lpii.model.Aluno;
import br.com.lpii.model.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * ?
 * Classe responsável pela interação com o banco de dados
 */
public class ProfessorDAO {

    private Connection con;

    public ProfessorDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    // Método cadastrar aluno
    public void cadastrarProfessor(Professor professor) {
        try {
            // Comando SQL
            String sql = "INSERT INTO professor (nome, email, count_banca, senha, perfil) "
                    + "VALUES (?, ?, ?, ?, ?)";
            // Conectar o banco de dados e organizar o SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            // insere os valores no sql
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setInt(3, 0);
            stmt.setString(4, professor.getSenha());
            stmt.setString(5, "Professor");
            
            //Executa sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error);
        }
    }

    // Método alterar aluno
    public void alterarProfessor(Professor professor) {
        try {
            // Comando SQL
            String sql = "UPDATE professor SET nome = ?, email = ?, count_banca = ?, " +
                    "senha = ?, perfil = ? WHERE id_professor = ?";
            
            
            // Conectar o banco de dados e organizar o SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            // insere os valores no sql
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setInt(3, professor.getNumBancas());
            stmt.setString(4, professor.getSenha());
            stmt.setString(5, "Professor");
            stmt.setInt(6, professor.getCodigo());
            

            //Executa sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error);
        }
    }

    // Método exluir aluno
    public void excluirProfessor(Professor professor) {

        try {
            
            // Comando SQL
            String sql = "DELETE FROM aluno WHERE id_professor = ?";
            // Conectar o banco de dados e organizar o SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            // insere os valores no sql
            stmt.setInt(1, professor.getCodigo());

            //Executa sql
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error);
        }
        
    }

    // Método para listar todos os alunos
    public List<Professor> listarProfessor() {
        // try...catch para tratar eventual erro
        try {
            // Cria a lista
            List<Professor> lista = new ArrayList<>();
            // Cria comando sql
            String sql = "SELECT * FROM professor ORDER BY id_professor";
            // prepara sql para execução
            PreparedStatement stmt = con.prepareStatement(sql);
            // o resultado do select é armazenada em um objeto ResultSet
            ResultSet rs = stmt.executeQuery();
            /**
             * Armazena o resultado da pesquisa que está no ResultSet na nossa
             * lista
             */
            while (rs.next()) {
                // Para casda ocorrência de rs é gerado um novo objeto Aluno
                Professor professor = new Professor();
                // É setado os atributos. Os parâmetros do get são os nomes das colunas
                professor.setCodigo(rs.getInt("id_professor"));
                professor.setNome(rs.getString("nome"));
                professor.setEmail(rs.getString("email"));
                professor.setPerfil(rs.getString("perfil"));
                professor.setSenha(rs.getString("senha"));
                professor.setNumBancas(rs.getInt("count_banca"));
                // Após setar todos os atributos, o objeto é adicionado à lista
                lista.add(professor);
            }

            return lista;

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, "Erro ao carregar alunos: " + error);
            return null;
        }

    }
    
    // Método para pesquisar alunos por nome
    
    public List<Professor> buscaProfessor(String param) {
        // try...catch para tratar eventual erro
        try {
            // Cria a lista
            List<Professor> lista = new ArrayList<>();
            // Cria comando sql
            String sql = "SELECT * FROM professor WHERE id_professor LIKE ? OR nome LIKE ? ORDER BY id_professor";
            // prepara sql para execução
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, param);
            stmt.setString(2, param);
            // o resultado do select é armazenada em um objeto ResultSet
            ResultSet rs = stmt.executeQuery();
            /**
             * Armazena o resultado da pesquisa que está no ResultSet na nossa
             * lista
             */
            while (rs.next()) {
               // Para casda ocorrência de rs é gerado um novo objeto Aluno
                Professor professor = new Professor();
                // É setado os atributos. Os parâmetros do get são os nomes das colunas
                professor.setCodigo(rs.getInt("id_professor"));
                professor.setNome(rs.getString("nome"));
                professor.setEmail(rs.getString("email"));
                professor.setPerfil(rs.getString("perfil"));
                professor.setSenha(rs.getString("senha"));
                professor.setNumBancas(rs.getInt("count_banca"));
                // Após setar todos os atributos, o objeto é adicionado à lista
                lista.add(professor);
            }

            return lista;

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, "Erro ao carregar alunos: " + error);
            return null;
        }

    }
    
    // Método para pesquisar um Professor por id
    
    public Professor buscaProfessor(int codigo) {
        // cria um professor que será retornado
           Professor professor = new Professor();
        // try...catch para tratar eventual erro
        try {
            // Cria comando sql
            String sql = "SELECT * FROM professor WHERE id_professor LIKE ?";
            // prepara sql para execução
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, codigo);
            // o resultado do select é armazenada em um objeto ResultSet
            ResultSet rs = stmt.executeQuery();
            /**
             * Armazena o resultado da pesquisa que está no ResultSet na nossa
             * lista
             */
            while (rs.next()) {
               
                // É setado os atributos. Os parâmetros do get são os nomes das colunas
                professor.setCodigo(rs.getInt("id_professor"));
                professor.setNome(rs.getString("nome"));
                professor.setEmail(rs.getString("email"));
                professor.setPerfil(rs.getString("perfil"));
                professor.setSenha(rs.getString("senha"));
                professor.setNumBancas(rs.getInt("count_banca"));
                
            }

            return professor;

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, "Erro ao carregar alunos: " + error);
            return null;
        }

    }
    
    
}
