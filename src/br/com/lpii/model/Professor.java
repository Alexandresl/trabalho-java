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
public class Professor extends Pessoa{
    
    /**
     * Atributos da classe Aluno
     * Os atributos nome, email e senha serão extendidos da classe Pessoa
     */
    private int codigo;
    private int numBancas;
    
    public Professor () {
        super();
    }
    
    /**
     * Contrutores da classe aluno
     * Os atributos, nome, email e senha são heradados da super classe Pessoa
     */
    public Professor (int codigo, String nome, String email, String senha, int numBancas, String perfil) {
        super(nome, email, senha, perfil);
        this.codigo = codigo;
        this.numBancas = numBancas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getNumBancas() {
        return numBancas;
    }

    public void setNumBancas(int numBancas) {
        this.numBancas = numBancas;
    }



    
    
    
    
}
