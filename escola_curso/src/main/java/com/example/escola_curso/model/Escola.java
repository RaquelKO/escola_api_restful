package com.example.escola_curso.model;

import java.util.ArrayList;

//import com.fasterxml.jackson.annotation.JsonIgnore;

public class Escola {
    private long codigo;
    private String nome;
    private String cidade;
    private String unidade;
    private String tipo;

    // @JsonIgnore
    private ArrayList<Curso> cursos = new ArrayList<Curso>();

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public boolean addCurso(Curso curso) {
        return cursos.add(curso);
    }

    public boolean removeCurso(Curso curso) {
        return cursos.remove(curso);
    }

}
