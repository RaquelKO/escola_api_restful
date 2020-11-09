package com.example.escola_curso.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.escola_curso.model.Curso;

import org.springframework.stereotype.Component;

@Component
public class CursoRepository {

    private ArrayList<Curso> cursos = new ArrayList<Curso>();
    private static int nextId = 1;

    public List<Curso> getAllCursos() {
        return cursos;
    }

    public Optional<Curso> getCursoById(int id) {
        for (Curso aux : cursos) {
            if (aux.getId() == id) {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Curso save(Curso curso) {
        curso.setId(nextId++);
        cursos.add(curso);
        return curso;
    }

}
