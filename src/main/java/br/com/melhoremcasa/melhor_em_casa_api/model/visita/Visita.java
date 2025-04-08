package br.com.melhoremcasa.melhor_em_casa_api.model.visita;

import br.com.melhoremcasa.melhor_em_casa_api.model.paciente.Paciente;
import br.com.melhoremcasa.melhor_em_casa_api.model.usuario.Usuario;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Visita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusVisita status;

    @Enumerated(EnumType.STRING)
    @Column(name = "classificacao_visita_id")
    private ClassificacaoVisita classificacaoVisita;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToMany
    @JoinTable(
            name = "visita_profissionais",
            joinColumns = @JoinColumn(name = "visita_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> profissionais;

    @Column(nullable = false)
    private LocalDate dataValidade;

    @Column(nullable = false)
    private LocalTime horarioVisita;

    @Column(nullable = false)
    private boolean agudizado;

    @Column(nullable = false)
    private boolean intercorreu;

    @ManyToOne
    @JoinColumn(name = "veiculo_dados_visita_id")
    private VeiculoVisita veiculoDadosVisita;




}
