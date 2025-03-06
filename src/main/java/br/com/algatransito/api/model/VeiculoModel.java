package br.com.algatransito.api.model;

import java.time.OffsetDateTime;

import br.com.algatransito.domain.model.StatusVeiculo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VeiculoModel {

    private Long id;
    private ProprietarioResumoModel proprietario;
    private String marca;
    private String modelo;
    private String numeroPlaca;
    private StatusVeiculo status;
    private OffsetDateTime dataCadastro;
    private OffsetDateTime dataApreensao;

}
