package com.hps.vilanova.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;
    private LocalDate dataNascimento;

    private Long enderecoId;
    private String cpf;
    private String cid;
    private String telefone;
    private boolean status;
}
