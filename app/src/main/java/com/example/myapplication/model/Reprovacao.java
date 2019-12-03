package com.example.myapplication.model;

public class Reprovacao {
    public String cpf;
    public String discplina;
    public String matricula;
    public String nome;
    public String professor;

    public Reprovacao(String cpf, String discplina, String matricula, String nome, String professor) {
        this.cpf = cpf;
        this.discplina = discplina;
        this.matricula = matricula;
        this.nome = nome;
        this.professor = professor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDiscplina() {
        return discplina;
    }

    public void setDiscplina(String discplina) {
        this.discplina = discplina;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }
}
