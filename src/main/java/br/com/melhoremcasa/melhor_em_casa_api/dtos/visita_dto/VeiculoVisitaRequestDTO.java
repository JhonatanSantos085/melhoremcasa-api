package br.com.melhoremcasa.melhor_em_casa_api.dtos.visita_dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalTime;

public record VeiculoVisitaRequestDTO (
        @NotNull
        Long veiculoId,

        @NotNull
        Long usuarioId,

        @PositiveOrZero
        Integer kmInicial,

        @NotNull
        LocalTime horaSaida


){
}
