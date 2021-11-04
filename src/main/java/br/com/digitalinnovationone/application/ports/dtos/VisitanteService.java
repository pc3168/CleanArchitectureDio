package br.com.digitalinnovationone.application.ports.dtos;

import br.com.digitalinnovationone.application.entidades.Visitante;

import java.util.Objects;

public class VisitanteService implements VisitanteServicePort{

    private VisitanteRepositoryPort repository;

    public VisitanteService (VisitanteRepositoryPort repository){
        this.repository = repository;
    }

    @Override
    public void cadastrar(VisitanteDto dto) {
        if (Objects.isNull(dto)){
            throw new IllegalArgumentException("Falta instruções do visitante");
        }

        var visitante = new Visitante(dto.getNome(), dto.getCpf(), dto.getFoto());
        this.repository.cadastrar(visitante);
    }
}
