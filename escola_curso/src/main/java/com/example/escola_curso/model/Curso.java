package com.example.escola_curso.model;

public class Curso {
    private int id;
    private String nome;
    private String descricao;
    private double valor;
    private boolean matriculasAbertas;
    private Escola escola;

    public Curso() {

    }

    public Curso(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isMatriculasAbertas() {
        return matriculasAbertas;
    }

    public void setMatriculasAbertas(boolean matriculasAbertas) {
        this.matriculasAbertas = matriculasAbertas;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    @Override
    public String toString() {
        return "Curso [escola=" + escola.getCodigo() + ", id=" + id + ", nome=" + nome + ", descricao=" + descricao
                + ",  matriculasAbertas=" + matriculasAbertas + ",  valor=" + valor + "]";
    }

}
