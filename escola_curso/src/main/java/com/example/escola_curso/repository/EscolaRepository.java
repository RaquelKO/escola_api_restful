package com.example.escola_curso.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import com.example.escola_curso.model.Escola;

import org.springframework.stereotype.Component;

@Component
public class EscolaRepository {

    private List<Escola> escolas;
    private long nextCode;

    @PostConstruct
    public void createEscola() {
        Escola escola = new Escola();
        escola.setCodigo(1);
        escola.setNome("Yesterday Idiomas");
        escola.setCidade("Sorocaba");
        escola.setUnidade("Campolim");
        escola.setTipo("Escola de Idiomas");

        escolas = new ArrayList<Escola>();
        escolas.add(escola);
        nextCode = escolas.size() + 1;

    }

    public List<Escola> getAllEscolas() {
        return escolas;
    }

    public Optional<Escola> getEscolaByCodigo(long codigo) {
        for (Escola aux : escolas) {
            if (aux.getCodigo() == codigo) {
                return Optional.of(aux);
            }
        }
        return Optional.empty();
    }

    public Escola save(Escola escola) {
        escola.setCodigo(nextCode++);
        escolas.add(escola);
        return escola;
    }

    public void remove(Escola escola) {
        escolas.remove(escola);
    }

    public Escola update(Escola escola) {
        Escola aux = getEscolaByCodigo(escola.getCodigo()).get();

        if (aux != null) {
            aux.setCidade(escola.getCidade());
            aux.setUnidade(escola.getUnidade());
        }

        return aux;
    }
}
