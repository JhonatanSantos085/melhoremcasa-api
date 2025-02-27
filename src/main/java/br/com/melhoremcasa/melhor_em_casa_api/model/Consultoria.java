package br.com.melhoremcasa.melhor_em_casa_api.model;


import br.com.melhoremcasa.melhor_em_casa_api.model.paciente.Paciente;
import br.com.melhoremcasa.melhor_em_casa_api.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consultoria {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "paciente_id, nullable = false")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "unidade_saude")
    private String  UnidadeSaude;

    private String equipe;

    @Column(name = "data_consultoria", nullable = false)
    private LocalDateTime data_consultoria;

    private String solicitante;

}
