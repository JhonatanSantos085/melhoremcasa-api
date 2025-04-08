package br.com.melhoremcasa.melhor_em_casa_api.model.veiculo;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "veiculo_id", nullable = false)
    private Veiculo veiculo;

    @Enumerated(EnumType.STRING)
    private TipoManutencao tipo;

    private BigDecimal valor;

    @Column(columnDefinition = "TEXT")
    private String informacoes;

    private Integer kmRodado;


}
