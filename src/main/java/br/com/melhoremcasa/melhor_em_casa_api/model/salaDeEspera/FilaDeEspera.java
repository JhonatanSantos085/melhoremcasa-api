package br.com.melhoremcasa.melhor_em_casa_api.model.salaDeEspera;


import br.com.melhoremcasa.melhor_em_casa_api.model.paciente.Paciente;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilaDeEspera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Paciente paciente;

    @Enumerated(EnumType.STRING)
    private StatusFila stauts;

    private LocalDate dataStatus;

    private String hospital;

    private String novoEndereco;


}
