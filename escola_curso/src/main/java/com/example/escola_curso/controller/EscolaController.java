package com.example.escola_curso.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.escola_curso.dto.EscolaDTO;
import com.example.escola_curso.model.Curso;
import com.example.escola_curso.model.Escola;
import com.example.escola_curso.service.CursoService;
import com.example.escola_curso.service.EscolaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/escolas")
public class EscolaController {

    @Autowired
    private EscolaService escolaService;

    @Autowired
    private CursoService cursoService;

    @GetMapping()
    public List<Escola> getEscolas() {
        return escolaService.getAllEscolas();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Escola> getEscola(@PathVariable long codigo) {
        Escola escola = escolaService.getEscolaByCodigo(codigo);
        return ResponseEntity.ok(escola);
    }

    @PostMapping()
    public ResponseEntity<Void> cadastrar(@RequestBody Escola escola, HttpServletRequest request,
            UriComponentsBuilder builder) {
        escola = escolaService.save(escola);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + escola.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletar(@PathVariable long codigo) {
        escolaService.removeByCodigo(codigo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Escola> atualizar(@PathVariable long codigo, @RequestBody EscolaDTO escolaDTO) {
        Escola escola = escolaService.fromDTO(escolaDTO);
        escola.setCodigo(codigo);
        escola = escolaService.update(escola);
        return ResponseEntity.ok(escola);
    }

    @PostMapping("/{codigo}/cursos")
    public ResponseEntity<Void> cadastrar(@PathVariable long codigo, @RequestBody Curso curso,
            HttpServletRequest request, UriComponentsBuilder builder) {
        curso = cursoService.save(curso, codigo);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + curso.getId()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

}
