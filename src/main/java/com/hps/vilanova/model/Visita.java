package com.hps.vilanova.model;


import com.hps.vilanova.model.enums.StatusVisita;
import com.hps.vilanova.model.enums.ViaAdmin;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long pacienteId;
    private Long usuarioId;
    private Long equipeId;
    private boolean agudizacao;
    private boolean intercorreu;

    @Enumerated(EnumType.STRING)
    private StatusVisita statusVisita;

    private boolean internacaoEvitada;
    private LocalDate dataVisita;

    @Enumerated(EnumType.STRING)
    private ViaAdmin viaAdmin;
}
