package br.com.melhoremcasa.melhor_em_casa_api.dtos.veiculo_dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public record VeiculoRequestDTO(
        @NotNull
        String modelo,

        @NotNull
        String placa,

        @PositiveOrZero
        Integer kmAtual
) {
}
