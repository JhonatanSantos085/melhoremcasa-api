package com.hps.vilanova.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Corrida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long veiculoId;

    private Long usuarioId;

    private BigDecimal kmInicial;
    private BigDecimal kmFinal;

    private LocalTime horaInicial;
    private LocalTime horaFinal;

    private BigDecimal posicaoInicial;
    private BigDecimal posicaoFinal;



}
