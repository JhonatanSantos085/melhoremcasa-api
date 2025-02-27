package br.com.melhoremcasa.melhor_em_casa_api.model.paciente;


import br.com.melhoremcasa.melhor_em_casa_api.model.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {

    @Id
    @GeneratedValue( strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private TipoPaciente tipoPaciente;

    private String nome;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate data_nascimento;

    @Column(unique = true, nullable = false, length = 11)
    private String cpf;

    private String cid;

    private String telefone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco endereco;

    @Column(updatable = false)
    private LocalDateTime dataCadastro = LocalDateTime.now();


}
