package com.example.escola_curso.controller;

import java.util.List;

import com.example.escola_curso.dto.CursoDTO;
import com.example.escola_curso.model.Curso;
import com.example.escola_curso.service.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    @GetMapping
    public List<Curso> getAllCursos() {
        return service.getAllCursos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable int id) {
        Curso curso = service.getCursoById(id);
        return ResponseEntity.ok(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizar(@PathVariable int id, @RequestBody CursoDTO cursoDTO) {
        Curso curso = service.fromDTO(cursoDTO);
        curso.setId(id);
        curso = service.update(curso);
        return ResponseEntity.ok(curso);
    }

}
