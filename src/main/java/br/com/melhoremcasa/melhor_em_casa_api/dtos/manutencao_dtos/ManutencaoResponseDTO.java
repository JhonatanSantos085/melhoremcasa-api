package br.com.melhoremcasa.melhor_em_casa_api.dtos.manutencao_dtos;

import br.com.melhoremcasa.melhor_em_casa_api.model.veiculo.TipoManutencao;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ManutencaoResponseDTO(
        Long id,

        Long veiculoId,

        TipoManutencao tipo,

        BigDecimal valor,

        String informacoes,

        Integer kmRodado,

        LocalDate dataRegistro


) {
}
