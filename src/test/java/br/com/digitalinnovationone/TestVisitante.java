package br.com.digitalinnovationone;

import br.com.digitalinnovationone.application.ports.dtos.VisitanteDto;
import br.com.digitalinnovationone.application.ports.dtos.VisitanteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestVisitante {

    @Test
    void deveCadastrarUmVisitante(){
        var nome = "Visitante 1";
        var cpf = "11111111111";
        var foto = "base64";
        var dto = new VisitanteDto(nome, cpf , foto);

        var tabelaVisitanteEmMemoria = new TabelaVisitanteEmMemoria();
        var visitanteService = new VisitanteService(tabelaVisitanteEmMemoria);

        Assertions.assertDoesNotThrow(() -> visitanteService.cadastrar(dto));
    }

    @Test
    void deveLancarExcecaoSeNaoPassarInformacoesDoUsuario(){

        var tabelaVisitanteEmMemoria = new TabelaVisitanteEmMemoria();
        var visitanteService = new VisitanteService(tabelaVisitanteEmMemoria);

        Assertions.assertThrows(IllegalArgumentException.class, () -> visitanteService.cadastrar(null));
    }


}
