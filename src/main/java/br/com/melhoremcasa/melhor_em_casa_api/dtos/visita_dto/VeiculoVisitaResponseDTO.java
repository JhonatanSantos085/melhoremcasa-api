package br.com.melhoremcasa.melhor_em_casa_api.dtos.visita_dto;

import br.com.melhoremcasa.melhor_em_casa_api.dtos.usuario_dtos.UsuarioResumoDTO;
import br.com.melhoremcasa.melhor_em_casa_api.dtos.veiculo_dtos.VeiculoResumoDTO;

import java.time.LocalTime;

public record VeiculoVisitaResponseDTO(

        Long id,

        VeiculoResumoDTO veiculo,

        UsuarioResumoDTO responsavel,

        Integer kmInicial,

        Integer kmFinal,

        LocalTime horaSaida,

        LocalTime horaChegada

) {
}
