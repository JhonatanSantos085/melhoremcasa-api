package br.com.melhoremcasa.melhor_em_casa_api.dtos.manutencao_dtos;

import br.com.melhoremcasa.melhor_em_casa_api.model.veiculo.TipoManutencao;

import java.time.LocalDate;

public record ManutencaoResumoDTO (
        Long id,

        TipoManutencao tipo,

        LocalDate dataRegistro
){
}
