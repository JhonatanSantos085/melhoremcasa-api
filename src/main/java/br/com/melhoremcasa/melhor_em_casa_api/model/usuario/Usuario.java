package br.com.melhoremcasa.melhor_em_casa_api.model.usuario;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String login;

    @Column(nullable = false)
    @JsonIgnore
    private String senha;

    @Column(nullable = false, unique = true)
    @JsonProperty("cpf")
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoUsuario tipoUsuario;

}
