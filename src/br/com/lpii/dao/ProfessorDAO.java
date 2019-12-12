/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lpii.dao;

import br.com.lpii.jdbc.ConnectionFactory;
import br.com.lpii.model.Professor;
import br.com.lpii.view.FrmMenu;
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

    // Método cadastrar professor
    public void cadastrarProfessor(Professor professor) {
        try {
            // Comando SQL
            String sql = "INSERT INTO professor (nome, email, conta_banca, senha, conta_orientador) "
                    + "VALUES (?, ?, ?, ?, ?)";
            // Conectar o banco de dados e organizar o SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            // insere os valores no sql
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setInt(3, professor.getConta_banca());
            stmt.setString(4, professor.getSenha());
            stmt.setInt(5, professor.getConta_orientador());

            //Executa sql
            stmt.execute();
            stmt.close();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error);
        }
    }

    // Método alterar professor
    public void alterarProfessor(Professor professor) {
        try {
            // Comando SQL
            String sql = "UPDATE professor SET nome = ?, email = ?, conta_banca = ?, conta_orientador = ?, "
                    + "senha = ? WHERE id_professor = ?";

            // Conectar o banco de dados e organizar o SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            // insere os valores no sql
            stmt.setString(1, professor.getNome());
            stmt.setString(2, professor.getEmail());
            stmt.setInt(3, professor.getConta_banca());
            stmt.setInt(4, professor.getConta_orientador());
            stmt.setString(5, professor.getSenha());
            stmt.setInt(6, professor.getCodigo());

            //Executa sql
            stmt.execute();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Professor alterado com sucesso!");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error);
        }
    }

    // Método exluir professor
    public void excluirProfessor(Professor professor) {

        try {

            // Comando SQL
            String sql = "DELETE FROM professor WHERE id_professor = ?";
            // Conectar o banco de dados e organizar o SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            // insere os valores no sql
            stmt.setInt(1, professor.getCodigo());

            //Executa sql
            stmt.execute();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error);
        }

    }

    // Método para listar todos os professores
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
                // Para casda ocorrência de rs é gerado um novo objeto professor
                Professor professor = new Professor();
                // É setado os atributos. Os parâmetros do get são os nomes das colunas
                professor.setCodigo(rs.getInt("id_professor"));
                professor.setNome(rs.getString("nome"));
                professor.setEmail(rs.getString("email"));
                professor.setSenha(rs.getString("senha"));
                professor.setConta_banca(rs.getInt("conta_banca"));
                professor.setConta_orientador(rs.getInt("conta_orientador"));

                // Após setar todos os atributos, o objeto é adicionado à lista
                lista.add(professor);
            }
            stmt.close();
            rs.close();
            con.close();
            return lista;

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, "Erro ao carregar alunos: " + error);
            return null;
        }

    }

    // Método para pesquisar professores por nome
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
                professor.setSenha(rs.getString("senha"));
                professor.setConta_banca(rs.getInt("conta_banca"));
                professor.setConta_orientador(rs.getInt("conta_orientador"));
                // Após setar todos os atributos, o objeto é adicionado à lista
                lista.add(professor);
            }

            stmt.close();
            rs.close();
            con.close();
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
                professor.setSenha(rs.getString("senha"));
                professor.setConta_banca(rs.getInt("conta_banca"));
                professor.setConta_orientador(rs.getInt("conta_orientador"));

            }
            stmt.close();
            rs.close();
            con.close();
            return professor;

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, "Erro ao carregar alunos: " + error);
            return null;
        }

    }

    // realiza o login professor
    public boolean loginProfessor(String email, String senha) {
        try {
            // Verifica se existe o usuário no banco
            String sql = "SELECT * FROM professor WHERE email = ? AND senha = ?";
            // prepara sql para execução
            PreparedStatement stmt = con.prepareStatement(sql);
            // o resultado do select é armazenada em um objeto ResultSet
            stmt.setString(1, email);
            stmt.setString(2, senha);

            // Armazena o resultado
            ResultSet rs = stmt.executeQuery();

            // verifica se encontrou
            if (rs.next()) {
                // usuário logou
                // Pega os dados do professor
                Professor professor = new Professor();
                // É setado os atributos. Os parâmetros do get são os nomes das colunas
                professor.setCodigo(rs.getInt("id_professor"));
                professor.setNome(rs.getString("nome"));
                professor.setEmail(rs.getString("email"));
                professor.setSenha(rs.getString("senha"));
                professor.setConta_banca(rs.getInt("conta_banca"));
                professor.setConta_orientador(rs.getInt("conta_orientador"));

                // Abre tela principal
                FrmMenu tela = new FrmMenu();
                tela.setProfesso(professor);
                tela.setPerfil("Professor");
                // Desabilita os menus que não estarão visível para o aluno
                tela.submenu_aluno_meuCadastro.setVisible(false);
                tela.submenu_aluno_escolherTema.setVisible(false);
                //tela.submenu_aluno.setVisible(false);
                //tela.menu_professor.setVisible(false);
                tela.setVisible(true);
                stmt.close();
                rs.close();
                con.close();
                return true;

            } else {
                // dados incoretos
                JOptionPane.showMessageDialog(null, "Usuário ou senha incorretos.");
                return false;
            }

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "Erro sql: " + error);
            return false;

        }
    }

    public boolean verificaProfessor(int id) {
        try {
            // Verifica se existe o usuário no banco
            String sql = "SELECT * FROM professor WHERE id_professor = ?";
            // prepara sql para execução
            PreparedStatement stmt = con.prepareStatement(sql);
            // o resultado do select é armazenada em um objeto ResultSet
            stmt.setInt(1, id);

            // Armazena o resultado
            ResultSet rs = stmt.executeQuery();

            // verifica se encontrou
            if (rs.next()) {
                stmt.close();
                rs.close();
                con.close();
                // Usuário existe
                return true;
            } else {
                stmt.close();
                rs.close();
                con.close();
                return false;
            }

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "Erro sql: " + error);
            return false;

        }
    }

    public void addBanca(int professorId, int contaBanca) {
        try {
            // Comando SQL
            String sql = "UPDATE professor SET conta_banca = ? "
                    + "WHERE id_professor = ?";

            // Conectar o banco de dados e organizar o SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            // insere os valores no sql
            stmt.setInt(1, contaBanca + 1);
            stmt.setInt(2, professorId);

            //Executa sql
            stmt.execute();
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
