/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.lpii.model;

/**
 *
 * @author
 */
public class Proposta {

    // Atributos 
    private int propostaId;
    private int propostaAlunoMatricula;
    private int propostaCodAreaInteresse;
    private int propostaIdProfessor;
    private String propostaTitulo;
    private String propostaDescricao;
    private String propostaStatus;
    private int banca1;
    private int banca2;

    // Getters and Setters
    public int getPropostaId() {
        return propostaId;
    }

    public void setPropostaId(int propostaId) {
        this.propostaId = propostaId;
    }

    public int getPropostaAlunoMatricula() {
        return propostaAlunoMatricula;
    }

    public void setPropostaAlunoMatricula(int propostaAlunoMatricula) {
        this.propostaAlunoMatricula = propostaAlunoMatricula;
    }

    public int getPropostaCodAreaInteresse() {
        return propostaCodAreaInteresse;
    }

    public void setPropostaCodAreaInteresse(int propostaCodAreaInteresse) {
        this.propostaCodAreaInteresse = propostaCodAreaInteresse;
    }

    private String propostaNomeAreaInteresse;

    public String getPropostaNomeAreaInteresse() {
        return propostaNomeAreaInteresse;
    }

    public void setPropostaNomeAreaInteresse(String propostaNomeAreaInteresse) {
        this.propostaNomeAreaInteresse = propostaNomeAreaInteresse;
    }

    private String propostaNomeProfessor;

    public String getPropostaNomeProfessor() {
        return propostaNomeProfessor;
    }

    public void setPropostaNomeProfessor(String propostaNomeProfessor) {
        this.propostaNomeProfessor = propostaNomeProfessor;
    }

    private String propostaProfEmail;

    public String getPropostaProfEmail() {
        return propostaProfEmail;
    }

    public void setPropostaProfEmail(String propostaProfEmail) {
        this.propostaProfEmail = propostaProfEmail;
    }

    public int getPropostaIdProfessor() {
        return propostaIdProfessor;
    }

    public void setPropostaIdProfessor(int propostaIdProfessor) {
        this.propostaIdProfessor = propostaIdProfessor;
    }

    public String getPropostaTitulo() {
        return propostaTitulo;
    }

    public void setPropostaTitulo(String propostaTitulo) {
        this.propostaTitulo = propostaTitulo;
    }

    public String getPropostaDescricao() {
        return propostaDescricao;
    }

    public void setPropostaDescricao(String propostaDescricao) {
        this.propostaDescricao = propostaDescricao;
    }

    public String getPropostaStatus() {
        return propostaStatus;
    }

    public void setPropostaStatus(String propostaStatus) {
        this.propostaStatus = propostaStatus;
    }

    private String PropostaAlunoNome;

    public String getPropostaAlunoNome() {
        return PropostaAlunoNome;
    }

    public void setPropostaAlunoNome(String PropostaAlunoNome) {
        this.PropostaAlunoNome = PropostaAlunoNome;
    }

    private int PropostaAlunoNota;

    public int getPropostaAlunoNota() {
        return PropostaAlunoNota;
    }

    public void setPropostaAlunoNota(int PropostaAlunoNota) {
        this.PropostaAlunoNota = PropostaAlunoNota;
    }

    public int getBanca1() {
        return banca1;
    }

    public void setBanca1(int banca1) {
        this.banca1 = banca1;
    }

    public int getBanca2() {
        return banca2;
    }

    public void setBanca2(int banca2) {
        this.banca2 = banca2;
    }

    private String banca1Nome;

    public String getBanca1Nome() {
        return banca1Nome;
    }

    public void setBanca1Nome(String banca1Nome) {
        this.banca1Nome = banca1Nome;
    }

    private String banca2Nome;

    public String getBanca2Nome() {
        return banca2Nome;
    }

    public void setBanca2Nome(String banca2Nome) {
        this.banca2Nome = banca2Nome;
    }

}
