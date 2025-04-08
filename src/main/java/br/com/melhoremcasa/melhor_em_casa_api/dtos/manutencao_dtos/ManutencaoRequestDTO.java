package br.com.melhoremcasa.melhor_em_casa_api.dtos.manutencao_dtos;

import br.com.melhoremcasa.melhor_em_casa_api.model.veiculo.TipoManutencao;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

public record ManutencaoRequestDTO(

        @NotNull
        Long veiculoId,

        @NotNull
        TipoManutencao tipo,

        @Positive
        BigDecimal valor,

        @PositiveOrZero
        Integer kmRodado

) {
}
