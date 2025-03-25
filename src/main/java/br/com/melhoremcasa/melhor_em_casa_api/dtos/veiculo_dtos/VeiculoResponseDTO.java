package br.com.melhoremcasa.melhor_em_casa_api.dtos.veiculo_dtos;

import br.com.melhoremcasa.melhor_em_casa_api.dtos.manutencao_dtos.ManutencaoResumoDTO;
import br.com.melhoremcasa.melhor_em_casa_api.dtos.visita_dto.VeiculoVisitaResumoDTO;

import java.util.List;

public record VeiculoResponseDTO(

        Long id,

        String modelo,

        String placa,

        Integer kmAtual,

        Integer kmRodadoAtual,

        List<VeiculoVisitaResumoDTO> historicoUtilizacoes,

        List<ManutencaoResumoDTO> manutencoes

) {
}
