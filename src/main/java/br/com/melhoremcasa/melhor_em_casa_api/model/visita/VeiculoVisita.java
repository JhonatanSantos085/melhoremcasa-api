package br.com.melhoremcasa.melhor_em_casa_api.model.visita;

import br.com.melhoremcasa.melhor_em_casa_api.model.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VeiculoVisita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

    private Integer KmInicial;
    private Integer KmFinal;
    private LocalTime horaSaida;
    private LocalTime horaChegada;
}
