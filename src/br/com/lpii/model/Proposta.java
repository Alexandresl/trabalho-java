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
    
    private int propostaId;
    private int propostaAlunoMatricula;
    private int propostaAreaInteresse;
    private int propostaIdProfessor;
    private String propostaTitulo;
    private String propostaDescricao;
    private String propostaStatus;
    private String PropostaAlunoNome;
    private String banca1;
    private String banca2;
    private int PropostaAlunoNota;

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

    public int getPropostaAreaInteresse() {
        return propostaAreaInteresse;
    }

    public void setPropostaAreaInteresse(int propostaAreaInteresse) {
        this.propostaAreaInteresse = propostaAreaInteresse;
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

    public String getPropostaAlunoNome() {
        return PropostaAlunoNome;
    }

    public void setPropostaAlunoNome(String PropostaAlunoNome) {
        this.PropostaAlunoNome = PropostaAlunoNome;
    }

    public int getPropostaAlunoNota() {
        return PropostaAlunoNota;
    }

    public void setPropostaAlunoNota(int PropostaAlunoNota) {
        this.PropostaAlunoNota = PropostaAlunoNota;
    }

    public String getBanca1() {
        return banca1;
    }

    public void setBanca1(String banca1) {
        this.banca1 = banca1;
    }

    public String getBanca2() {
        return banca2;
    }

    public void setBanca2(String banca2) {
        this.banca2 = banca2;
    }    
    
}
