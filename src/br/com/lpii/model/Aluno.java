/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lpii.model;

/**
 *
 * @author Alexandre Lima
 */
public class Aluno extends Pessoa{
    
    /**
     * Atributos da classe Aluno
     * Os atributos nome, email e senha serão extendidos da classe Pessoa
     */
    private int matricula;
    private String cpf;
    private String telefone;
    private String proposta;
    private String perfil;
    
    public Aluno () {
        super();
    }
    
    /**
     * Contrutor da classe aluno
     * Os atributos, nome, email e senha são heradados da super classe Pessoa
     */
    public Aluno (int matricula, String nome, String email, String senha, String cpf, String telefone, String proposta, String perfil) {
        super(nome, email, senha);
        this.cpf = cpf;
        this.telefone = telefone;
        this.proposta = proposta;
        this.perfil = perfil;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getProposta() {
        return proposta;
    }

    public void setProposta(String proposta) {
        this.proposta = proposta;
    }
    
    
    
    
}
