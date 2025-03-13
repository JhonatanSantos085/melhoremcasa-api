package br.com.melhoremcasa.melhor_em_casa_api.model.consultoria;

import java.time.LocalDate;

public record ConsultoriaRequestDTO(
        Long pacienteId,

        Long usuarioId,

        String unidadeSaude,

        String equipe,

        LocalDate dataConsultoria,

        String solicitante)
{}
