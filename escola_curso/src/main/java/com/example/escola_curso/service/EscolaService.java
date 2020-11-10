package com.example.escola_curso.service;

import java.util.List;
import java.util.Optional;

import com.example.escola_curso.dto.EscolaDTO;
import com.example.escola_curso.model.Curso;
import com.example.escola_curso.model.Escola;
import com.example.escola_curso.repository.EscolaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EscolaService {

    @Autowired
    private EscolaRepository repository;

    public Escola fromDTO(EscolaDTO escolaDTO) {
        Escola escola = new Escola();
        escola.setCidade(escolaDTO.getCidade());
        escola.setUnidade(escolaDTO.getUnidade());
        return escola;
    }

    public List<Escola> getAllEscolas() {
        return repository.getAllEscolas();
    }

    public Escola getEscolaByCodigo(long codigo) {
        Optional<Escola> op = repository.getEscolaByCodigo(codigo);
        return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Escola inexistente"));
    }

    public Escola save(Escola escola) {
        return repository.save(escola);
    }

    public void removeByCodigo(long codigo) {
        repository.remove(getEscolaByCodigo(codigo));
    }

    public Escola update(Escola escola) {
        getEscolaByCodigo(escola.getCodigo());
        return repository.update(escola);
    }

    public List<Curso> getCursosByEscola(Escola escola) {
        return repository.getCursos(escola);
    }

    public void removeCurso(Escola escola, Curso curso) {
        repository.removeCurso(escola, curso);
    }

}
