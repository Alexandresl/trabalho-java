/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lpii.model;

/**
 *@author Alexandre Lima
 
 */
public class Aluno extends Pessoa{
    
    /**
     * Atributos da classe Aluno
     * Os atributos nome, email e senha serão extendidos da classe Pessoa
     */
    private int matricula;
    private String cpf;
    private String telefone;
    private String nota;
    private Proposta proposta;
    

    
    /**
     * Contrutores da classe aluno
     * Os atributos, nome, email e senha são heradados da super classe Pessoa
     */
    public Aluno () {
        super();
    }
     // Getters Setters
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

    public Proposta getProposta() {
        return proposta;
    }

    public void setProposta(Proposta proposta) {
        this.proposta = proposta;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
    
    
    
}
