/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lpii.dao;

import br.com.lpii.jdbc.ConnectionFactory;
import br.com.lpii.model.AreaInteresse;
import br.com.lpii.model.Professor;
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
 */
public class AreaInteresseDAO {

    // Atributo para conexão
    private Connection con;

    // Construtor
    public AreaInteresseDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    /**
     * Método responsável por cadastrar áreas de interesse
     * @param lista de objetos do tipo AreaInteresse
     */
    public void cadastrarAreaInteresse(List<AreaInteresse> lista) {

        try {

            // Comando SQL
            String sql = "INSERT INTO professor_area_interesse (professor_id, area_interesse_id) "
                    + "VALUES (?, ?)";
            // Percorre a lista para salvar no banco de dados
            for (AreaInteresse ai : lista) {

                // Conectar o banco de dados e organizar o SQL
                PreparedStatement stmt = con.prepareStatement(sql);

                stmt.setInt(1, ai.getProfessor_id());
                stmt.setInt(2, ai.getId_area_interesse());

                //Executa sql
                stmt.execute();
                stmt.close();
                con.close();

            }

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "Erro: " + error);

        }
    }

    // Exclui áreas de interesse do professor que é recebido por parâmetro
    public void deletarAreaInteresse(Professor professor) {
        try {

            // Comando SQL
            String sql = "DELETE FROM professor_area_interesse WHERE professor_id = ?";
            // Conectar o banco de dados e organizar o SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            // insere os valores no sql
            stmt.setInt(1, professor.getCodigo());

            //Executa sql
            stmt.execute();
            stmt.close();
            con.close();

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "Erro: " + error);

        }
    }

    // Lista professores que possuem áreas de interesse em comum
    public List<Professor> ListaProfessorAreaInteresse(int areaInteresse, int usuarioId, int banca1, int banca2) {
        try {
            // Cria uma lista com os professorea que possuem a área de interesse
            List<Professor> lista = new ArrayList<>();

            // Cria a seleção
            String sql = "SELECT * FROM professor_area_interesse pai "
                    + "INNER JOIN professor p ON pai.professor_id = p.id_professor  "
                    + "WHERE pai.area_interesse_id = ? AND pai.professor_id != ? "
                    + "AND p.id_professor != ? AND p.id_professor != ? "
                    + "GROUP BY pai.professor_id, pai.area_interesse_id";

            // Conectar o banco de dados e organizar o SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, areaInteresse);
            stmt.setInt(2, usuarioId);
            stmt.setInt(3, banca1);
            stmt.setInt(4, banca2);

            // Armazena o resultado
            ResultSet rs = stmt.executeQuery();

            // verifica se encontrou
            while (rs.next()) {

                Professor professor = new Professor();
                professor.setCodigo(rs.getInt("id_professor"));
                professor.setNome(rs.getString("nome"));
                professor.setEmail(rs.getString("email"));
                professor.setConta_banca(rs.getInt("conta_banca"));
                professor.setConta_orientador(rs.getInt("conta_orientador"));
                professor.setSenha(rs.getString("senha"));
                lista.add(professor);
            }

            // retorna lista de professores
            stmt.close();
            rs.close();
            con.close();
            
            return lista;

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error);
            return null;
        }
    }

    // Lista todos os professores que participam que possuem até 5 bancas
    public List<Professor> ListaTodosProfessores(int usuarioId) {
        try {
            // Cria uma lista com os professorea que possuem a área de interesse
            List<Professor> lista = new ArrayList<>();

            // Cria a seleção
            String sql = "SELECT * FROM professor_area_interesse pai "
                    + "INNER JOIN professor p ON pai.professor_id = p.id_professor "
                    + "WHERE p.conta_banca <= 5 AND pai.professor_id != ? "
                    + "GROUP BY pai.professor_id";

            // Conectar o banco de dados e organizar o SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, usuarioId);

            // Armazena o resultado
            ResultSet rs = stmt.executeQuery();

            // verifica se encontrou
            while (rs.next()) {

                Professor professor = new Professor();
                professor.setCodigo(rs.getInt("id_professor"));
                professor.setNome(rs.getString("nome"));
                professor.setEmail(rs.getString("email"));
                professor.setConta_banca(rs.getInt("conta_banca"));
                professor.setConta_orientador(rs.getInt("conta_orientador"));
                professor.setSenha(rs.getString("senha"));
                lista.add(professor);

            }

            stmt.close();
            rs.close();
            con.close();
            // retorna lista de professores
            return lista;

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error);
            return null;
        }
    }

    // retorna uma área de interesse a partir do id recebido por parâmetro
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
            stmt.close();
            rs.close();
            con.close();
            return ai;

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "Erro sql: " + error);
            return null;
        }

    }

    // Retorna a área de interesse do professor
    public List<AreaInteresse> PegaAreaInteresseProfessor(Professor professor) {

        try {
            // Cria uma lista com os professorea que possuem a área de interesse
            List<AreaInteresse> lista = new ArrayList<>();

            // Cria a seleção
            String sql = "SELECT * FROM professor_area_interesse pai "
                    + "INNER JOIN professor p ON pai.professor_id = p.id_professor  "
                    + "INNER JOIN area_interesse ai ON ai.id_area_interesse = pai.area_interesse_id  "
                    + "WHERE p.id_professor = ?";

            // Conectar o banco de dados e organizar o SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, professor.getCodigo());

            // Armazena o resultado
            ResultSet rs = stmt.executeQuery();

            // verifica se encontrou
            while (rs.next()) {

                AreaInteresse ai = new AreaInteresse();
                ai.setId_area_interesse(rs.getInt("pai.area_interesse_id"));
                ai.setNome(rs.getString("ai.nome"));
                ai.setProfessor_id(rs.getInt("pai.professor_id"));

                professor.setConta_orientador(rs.getInt("conta_orientador"));
                professor.setSenha(rs.getString("senha"));
                lista.add(ai);
            }
            stmt.close();
            rs.close();
            con.close();
            // retorna lista de professores
            return lista;

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error);
            return null;
        }

    }
}
