package br.com.melhoremcasa.melhor_em_casa_api.model.endereco;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estado;

    private String cidade;

    private String bairro;

    private String rua;

    private String numero;

    @Column(name = "ponto_referencia")
    private String pontoReferencia;

}
