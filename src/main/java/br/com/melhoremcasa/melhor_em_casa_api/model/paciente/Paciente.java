package br.com.melhoremcasa.melhor_em_casa_api.model.paciente;


import br.com.melhoremcasa.melhor_em_casa_api.model.Endereco;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoPaciente tipoPaciente = TipoPaciente.INATIVO;

    private String nome;

    private int idade;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate data_nascimento;

    private String cpf;

    private String cid;

    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @Column(updatable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();


}
