package br.com.melhoremcasa.melhor_em_casa_api.dtos.visita_dto;

import br.com.melhoremcasa.melhor_em_casa_api.model.visita.ClassificacaoVisita;
import br.com.melhoremcasa.melhor_em_casa_api.model.visita.StatusVisita;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public record VisitaRequestDTO(

        @NotNull
        Long pacienteId,

        @NotNull
        Long responsavelId,

        @NotNull
        Set<Long> equipeIds,

        @NotNull
        LocalDate dataVisita,

        @NotNull
        LocalTime horarioVisita,

        @NotNull
        StatusVisita status,

        ClassificacaoVisita classicacao,

        boolean agudizado,

        boolean intercorreu,

        Long veiculoVisitaId

) {
}
