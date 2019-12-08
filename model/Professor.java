/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lpii.model;

/**
 *@author Caroline Coelho

 */
public class Professor extends Pessoa{
    
    /**
     * Atributos da classe Aluno
     * Os atributos nome, email e senha serão extendidos da classe Pessoa
     */
    private int codigo;
    private int conta_banca;
    private int conta_orientador;
    
    public Professor () {
        super();
    }
    
    /**
     * Contrutores da classe Professor
     * Os atributos, nome, email e senha são heradados da super classe Pessoa
     */

    public int getCodigo() {
        return codigo;
    }
     // Getters Setters
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getConta_banca() {
        return conta_banca;
    }

    public void setConta_banca(int conta_banca) {
        this.conta_banca = conta_banca;
    }

    public int getConta_orientador() {
        return conta_orientador;
    }

    public void setConta_orientador(int conta_orientador) {
        this.conta_orientador = conta_orientador;
    }

    
    
}
