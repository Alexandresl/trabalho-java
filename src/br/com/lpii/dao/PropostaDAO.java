/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lpii.dao;

import br.com.lpii.jdbc.ConnectionFactory;
import br.com.lpii.model.Aluno;
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
 * @author
 */
public class PropostaDAO {

    // Atributo para conexão
    private Connection con;

    // Construtor
    public PropostaDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    // Método para cadastro de propostas
    public void cadastrarProposta(Proposta proposta) {

        try {
            // Comando SQL
            String sql = "INSERT INTO proposta (id_proposta, id_area_interesse, id_professor, titulo, descricao, status) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            // Conectar o banco de dados e organizar o SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            // insere os valores no sql
            stmt.setInt(1, proposta.getPropostaId());
            stmt.setInt(2, proposta.getPropostaCodAreaInteresse());
            stmt.setInt(3, proposta.getPropostaIdProfessor());
            stmt.setString(4, proposta.getPropostaTitulo());
            stmt.setString(5, proposta.getPropostaDescricao());
            stmt.setString(6, proposta.getPropostaStatus());

            //Executa sql
            stmt.execute();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error);
        }

    }

    // Este método não atualiza a matricula do aluno que estará vinculado a proposta
    public void alterarProposta(Proposta proposta) {

        try {

            // Comando SQL
            String sql = "UPDATE proposta SET id_area_interesse = ?, matricula = ?, id_professor = ?, titulo = ?, descricao = ?, status = ? "
                    + "WHERE id_proposta = ?";

            // Conectar o banco de dados e organizar o SQL
            PreparedStatement stmt = con.prepareStatement(sql);

            // insere os valores no sql
            stmt.setInt(1, proposta.getPropostaCodAreaInteresse());
            stmt.setInt(2, proposta.getPropostaAlunoMatricula());
            stmt.setInt(3, proposta.getPropostaIdProfessor());
            stmt.setString(4, proposta.getPropostaTitulo());
            stmt.setString(5, proposta.getPropostaDescricao());
            stmt.setString(6, proposta.getPropostaStatus());
            stmt.setInt(7, proposta.getPropostaId());

            //Executa sql
            stmt.execute();
            stmt.close();
            con.close();;

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error);
        }

    }

    public void alterarPropostaIncluirBanca(Proposta proposta) { // Método para inclur professores das bancas

        try {

            // Comando SQL
            String sql = "UPDATE proposta SET banca1 = ?, banca2 = ? "
                    + "WHERE id_proposta = ?";

            // Conectar o banco de dados e organizar o SQL
            PreparedStatement stmt = con.prepareStatement(sql);

            // insere os valores no sql
            stmt.setInt(1, proposta.getBanca1());
            stmt.setInt(2, proposta.getBanca2());
            stmt.setInt(3, proposta.getPropostaId());

            //Executa sql
            stmt.execute();
            stmt.close();
            con.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error);
        } catch (RuntimeException error) {
            JOptionPane.showMessageDialog(null, "A conexão demorou para responder... Tente novamente");
        }

    }

    public void excluirProposta(Proposta proposta) {

        try {

            // Comando SQL
            String sql = "DELETE FROM proposta WHERE id_proposta = ?";
            // Conectar o banco de dados e organizar o SQL
            PreparedStatement stmt = con.prepareStatement(sql);
            // insere os valores no sql
            stmt.setInt(1, proposta.getPropostaId());

            //Executa sql
            stmt.execute();
            stmt.close();
            con.close();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "Erro: " + error);

        }

    }

    public List<Proposta> listarPropostas() {

        // try...catch para tratar eventual erro
        try {
            // Cria a lista
            List<Proposta> lista = new ArrayList<>();
            // Cria comando sql

            String sql = "SELECT * FROM proposta p "
                    + "INNER JOIN area_interesse ai ON p.id_area_interesse = ai.id_area_interesse "
                    + "INNER JOIN professor prof ON p.id_professor = prof.id_professor "
                    + "ORDER BY id_proposta";
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
                Proposta proposta = new Proposta();
                // É setado os atributos. Os parâmetros do get são os nomes das colunas
                // É setado os atributos. Os parâmetros do get são os nomes das colunas
                proposta.setPropostaId(rs.getInt("id_proposta"));
                proposta.setPropostaAlunoMatricula(rs.getInt("matricula"));
                proposta.setPropostaCodAreaInteresse(rs.getInt("id_area_interesse"));
                proposta.setPropostaNomeAreaInteresse(rs.getString("ai.nome"));
                proposta.setPropostaIdProfessor(rs.getInt("id_professor"));
                proposta.setPropostaNomeProfessor(rs.getString("prof.nome"));
                proposta.setPropostaProfEmail(rs.getString("prof.email"));
                proposta.setPropostaTitulo(rs.getString("titulo"));
                proposta.setPropostaDescricao(rs.getString("descricao"));
                proposta.setPropostaStatus(rs.getString("status"));
                // Após setar todos os atributos, o objeto é adicionado à lista
                lista.add(proposta);
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

    public List<Proposta> listarMinhasPropostas(int id) {

        // try...catch para tratar eventual erro
        try {
            // Cria a lista
            List<Proposta> lista = new ArrayList<>();
            // Cria comando sql
            String sql = "SELECT * FROM proposta p "
                    + "INNER JOIN area_interesse ai ON ai.id_area_interesse = p.id_area_interesse "
                    + "WHERE id_professor = ? ORDER BY titulo";
            // prepara sql para execução
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);
            // o resultado do select é armazenada em um objeto ResultSet
            ResultSet rs = stmt.executeQuery();
            /**
             * Armazena o resultado da pesquisa que está no ResultSet na nossa
             * lista
             */
            while (rs.next()) {
                // Para casda ocorrência de rs é gerado um novo objeto Aluno
                Proposta proposta = new Proposta();
                // É setado os atributos. Os parâmetros do get são os nomes das colunas
                proposta.setPropostaId(rs.getInt("id_proposta"));
                proposta.setPropostaAlunoMatricula(rs.getInt("matricula"));
                proposta.setPropostaCodAreaInteresse(rs.getInt("id_area_interesse"));
                proposta.setPropostaNomeAreaInteresse(rs.getString("ai.nome"));
                proposta.setPropostaIdProfessor(rs.getInt("id_professor"));
                proposta.setPropostaTitulo(rs.getString("titulo"));
                proposta.setPropostaDescricao(rs.getString("descricao"));
                proposta.setPropostaStatus(rs.getString("status"));
                proposta.setBanca1((rs.getInt("banca1") != 0) ? 0 : rs.getInt("banca1"));
                proposta.setBanca2((rs.getInt("banca2") != 0) ? 0 : rs.getInt("banca2"));
                // Após setar todos os atributos, o objeto é adicionado à lista
                lista.add(proposta);
            }
            
            stmt.close();
            rs.close();
            con.close();
            
            return lista;

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "Erro ao carregar alunos: " + error);
            return null;

        }

    }

    public List<Proposta> buscarPropostas(String param) {

        // try...catch para tratar eventual erro
        try {

            // Cria a lista
            List<Proposta> lista = new ArrayList<>();

            // Cria comando sql
            String sql = "SELECT * FROM proposta WHERE id_proposta LIKE ? OR titulo LIKE ? ORDER BY titulo";

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
                Proposta proposta = new Proposta();
                // É setado os atributos. Os parâmetros do get são os nomes das colunas
                proposta.setPropostaId(rs.getInt("id_proposta"));
                proposta.setPropostaAlunoMatricula(rs.getInt("matricula"));
                proposta.setPropostaCodAreaInteresse(rs.getInt("id_area_interesse"));
                proposta.setPropostaIdProfessor(rs.getInt("id_professor"));
                proposta.setPropostaTitulo(rs.getString("titulo"));
                proposta.setPropostaDescricao(rs.getString("descricao"));
                proposta.setPropostaStatus(rs.getString("status"));
                // Após setar todos os atributos, o objeto é adicionado à lista
                lista.add(proposta);
            }
            stmt.close();
            rs.close();
            con.close();
            return lista;

        } catch (Exception error) {

            JOptionPane.showMessageDialog(null, "Erro ao carregar propostas: " + error);
            return null;
        }

    }

    public boolean verificaProposta(int id) {

        try {
            // Verifica se existe o usuário no banco
            String sql = "SELECT * FROM proposta WHERE id_proposta = ?";
            // prepara sql para execução
            PreparedStatement stmt = con.prepareStatement(sql);
            // o resultado do select é armazenada em um objeto ResultSet
            stmt.setInt(1, id);

            // Armazena o resultado
            ResultSet rs = stmt.executeQuery();
            stmt.close();
            rs.close();
            con.close();
            // verifica se encontrou
            return rs.next(); // Usuário existe

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "Erro sql: " + error);
            return false;

        }

    }

    public Proposta getProposta(int id) {

        Proposta proposta = new Proposta();

        try {
            // Verifica se existe o usuário no banco
            String sql = "SELECT * FROM proposta p "
                    + "INNER JOIN area_interesse ai ON p.id_area_interesse = ai.id_area_interesse "
                    + "INNER JOIN professor profO ON p.id_professor = profO.id_professor "
                    + "WHERE id_proposta = ?";
            // prepara sql para execução
            PreparedStatement stmt = con.prepareStatement(sql);
            // o resultado do select é armazenada em um objeto ResultSet
            stmt.setInt(1, id);

            // Armazena o resultado
            ResultSet rs = stmt.executeQuery();

            // verifica se encontrou
            if (rs.next()) {
                // É setado os atributos. Os parâmetros do get são os nomes das colunas
                proposta.setPropostaId(rs.getInt("id_proposta"));
                proposta.setPropostaAlunoMatricula(rs.getInt("matricula"));
                proposta.setPropostaCodAreaInteresse(rs.getInt("id_area_interesse"));
                proposta.setPropostaNomeAreaInteresse(rs.getString("ai.nome"));
                proposta.setPropostaIdProfessor(rs.getInt("id_professor"));
                proposta.setPropostaNomeProfessor(rs.getString("profO.nome"));
                proposta.setPropostaProfEmail(rs.getString("profO.email"));
                proposta.setPropostaTitulo(rs.getString("titulo"));
                proposta.setPropostaDescricao(rs.getString("descricao"));
                proposta.setPropostaStatus(rs.getString("status"));
                proposta.setBanca1(rs.getInt("banca1"));
                proposta.setBanca2(rs.getInt("banca2"));
            }
            stmt.close();
            rs.close();
            con.close();
            return proposta;

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "Erro sql: " + error);
            return null;
        }

    }

    public Proposta getPropostaAluno(Aluno aluno) {

        Proposta proposta = new Proposta();

        try {
            // Verifica se existe o usuário no banco
            String sql = "SELECT * FROM proposta p "
                    + "INNER JOIN area_interesse ai ON p.id_area_interesse = ai.id_area_interesse "
                    + "INNER JOIN professor prof ON p.id_professor = prof.id_professor "
                    + "WHERE p.matricula = ?";
            // prepara sql para execução
            PreparedStatement stmt = con.prepareStatement(sql);
            // o resultado do select é armazenada em um objeto ResultSet
            stmt.setInt(1, aluno.getMatricula());

            // Armazena o resultado
            ResultSet rs = stmt.executeQuery();

            // verifica se encontrou
            if (rs.next()) {
                // É setado os atributos. Os parâmetros do get são os nomes das colunas
                proposta.setPropostaId(rs.getInt("id_proposta"));
                proposta.setPropostaAlunoMatricula(rs.getInt("matricula"));
                proposta.setPropostaCodAreaInteresse(rs.getInt("id_area_interesse"));
                proposta.setPropostaNomeAreaInteresse(rs.getString("ai.nome"));
                proposta.setPropostaIdProfessor(rs.getInt("id_professor"));
                proposta.setPropostaNomeProfessor(rs.getString("prof.nome"));
                proposta.setPropostaProfEmail(rs.getString("prof.email"));
                proposta.setPropostaTitulo(rs.getString("titulo"));
                proposta.setPropostaDescricao(rs.getString("descricao"));
                proposta.setPropostaStatus(rs.getString("status"));

            }
            con.close();
            return proposta;

        } catch (SQLException error) {

            JOptionPane.showMessageDialog(null, "Erro sql: " + error);
            return null;
        }

    }

}
