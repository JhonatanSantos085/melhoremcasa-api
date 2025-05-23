package com.hps.vilanova.model;

import com.hps.vilanova.model.enums.ModalidadeVisita;
import com.hps.vilanova.model.enums.StatusBaixa;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
public class Consultoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pacienteId;
    private Long usuarioId;
    private String unidadeSaude;
    private LocalDate dataConsultoria;
    private String solicitante;
    private LocalTime hora;
    private StatusBaixa statusBaixa;
    private ModalidadeVisita modalidadeVisita;

}
