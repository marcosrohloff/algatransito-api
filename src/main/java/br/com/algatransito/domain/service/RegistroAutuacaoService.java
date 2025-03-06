package br.com.algatransito.domain.service;

import org.springframework.stereotype.Service;

import br.com.algatransito.domain.model.Autuacao;
import br.com.algatransito.domain.model.Veiculo;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegistroAutuacaoService {

    private RegistroVeiculoService registroVeiculoService;

    public Autuacao registrar(Long veiculoId, Autuacao novAutuacao) {
        Veiculo veiculo = registroVeiculoService.buscar(veiculoId);
        return veiculo.adicionarAutuacao(novAutuacao);        
    }

}
