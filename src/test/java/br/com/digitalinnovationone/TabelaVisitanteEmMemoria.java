package br.com.digitalinnovationone;

import br.com.digitalinnovationone.application.entidades.Visitante;
import br.com.digitalinnovationone.application.ports.dtos.VisitanteRepositoryPort;

import java.util.Hashtable;

public class TabelaVisitanteEmMemoria implements VisitanteRepositoryPort {

    private Hashtable<String, Visitante> repository;

    public TabelaVisitanteEmMemoria(){
        this.repository = new Hashtable<String, Visitante>();
    }


    @Override
    public void cadastrar(Visitante visitante) {
        this.repository.put(visitante.getCpf(), visitante);
    }
}
