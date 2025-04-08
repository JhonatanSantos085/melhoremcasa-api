package br.com.melhoremcasa.melhor_em_casa_api.dtos.visita_dto;

import br.com.melhoremcasa.melhor_em_casa_api.model.visita.VeiculoVisita;

import java.time.LocalTime;

public record VeiculoVisitaResumoDTO(
        Long id,
        String modeloVeiculo,
        String placa,
        LocalTime horaSaida,
        LocalTime horaChegada
) {
    public static VeiculoVisitaResumoDTO fromEntity(VeiculoVisita veiculoVisita){
        return new VeiculoVisitaResumoDTO(
                veiculoVisita.getId(),
                veiculoVisita.getVeiculo().getModelo(),
                veiculoVisita.getVeiculo().getPlaca(),
                veiculoVisita.getHoraSaida(),
                veiculoVisita.getHoraChegada()
        );
    }
}
