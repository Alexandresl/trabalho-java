/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lpii.model;

/**
 * Olá,
 *
 * @author maria
 */
public class AreaInteresse {

    /**
     * Atributos da classe Area de interesse Os atributos nome, id_interesse,
     * nome
     */
    private int id_area_interesse;
    private String nome;
    private int professor_id;

    
    /**
     * Contrutores da classe área de interesse
     *
     * @param id_area_interesse
     * @param nome
     * @param professor_id
     */
    public AreaInteresse(int id_area_interesse, String nome, int professor_id) {
        this.id_area_interesse = id_area_interesse;
        this.nome = nome;
        this.professor_id = professor_id;
    }

    // Contrutores
    public AreaInteresse() {
        
    }
    
    public int getId_area_interesse() {
        return id_area_interesse;
    }

    public void setId_area_interesse(int id_area_interesse) {
        this.id_area_interesse = id_area_interesse;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }
}
