package br.com.melhoremcasa.melhor_em_casa_api.dtos.visita_dto;

import br.com.melhoremcasa.melhor_em_casa_api.dtos.paciente_dtos.PacienteResumoDTO;
import br.com.melhoremcasa.melhor_em_casa_api.dtos.usuario_dtos.UsuarioResumoDTO;
import br.com.melhoremcasa.melhor_em_casa_api.model.visita.ClassificacaoVisita;
import br.com.melhoremcasa.melhor_em_casa_api.model.visita.StatusVisita;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

public record VisitaResponseDTO(

        Long id,

        PacienteResumoDTO paciente,

        UsuarioResumoDTO responsavel,

        Set<UsuarioResumoDTO> equipe,

        LocalDate dataVisita,

        LocalTime horarioVisita,

        StatusVisita status,

        ClassificacaoVisita classificacao,

        boolean agudizacao,

        boolean intercorreu,

        VeiculoVisitaResumoDTO veiculoUtilizado


) {
}
