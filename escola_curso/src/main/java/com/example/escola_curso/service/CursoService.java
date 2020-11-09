package com.example.escola_curso.service;

import java.util.List;
import java.util.Optional;

import com.example.escola_curso.model.Curso;
import com.example.escola_curso.model.Escola;
import com.example.escola_curso.repository.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CursoService {

    @Autowired
    private CursoRepository repository;

    @Autowired
    private EscolaService escolaService;

    public List<Curso> getAllCursos() {
        return repository.getAllCursos();
    }

    public Curso getCursoById(int id) {
        Optional<Curso> op = repository.getCursoById(id);
        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso inexistente"));
    }

    public Curso save(Curso curso, long codigo) {
        Escola escola = escolaService.getEscolaByCodigo(codigo);
        curso.setEscola(escola);
        escola.addCurso(curso);

        return repository.save(curso);
    }
}
