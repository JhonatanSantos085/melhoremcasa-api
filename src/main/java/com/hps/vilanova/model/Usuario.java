package com.hps.vilanova.model;

import com.hps.vilanova.model.enums.Roles;
import jakarta.persistence.*;
import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String nome;
    private String senha;

    @Enumerated(EnumType.STRING)
    private Roles role;

}
