/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Objects;

/**
 *
 * @author Alexandre Lima
 */
public class Aluno extends Pessoa{
 
    private String matricula;
    private String telefone;
    private String tema;
    
    public Aluno() {
        
    }
    
    public Aluno (String nome, String matricula, String email, String telefone) {
        super(nome, email);
        this.matricula = matricula;
        this.telefone = telefone;
        this.tema = "Indefinido";
    }

    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public String toString() {
        return super.toString() + "Aluno{ Matrícula: " + matricula + ", Telefone: " + telefone + " }";
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluno other = (Aluno) obj;
        return Objects.equals(this.matricula, other.matricula);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.matricula);
        hash = 37 * hash + Objects.hashCode(this.telefone);
        return hash;
    }
    
}
