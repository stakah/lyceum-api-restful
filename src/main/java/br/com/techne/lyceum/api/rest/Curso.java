package br.com.techne.lyceum.api.rest;

public class Curso {

    private final long id;
    private final String curso;

    public Curso(long id, String curso) {
        this.id = id;
        this.curso = curso;
    }

    public long getId() {
        return id;
    }

    public String getCurso() {
        return curso;
    }
}