package br.com.melhoremcasa.melhor_em_casa_api.dtos;

import br.com.melhoremcasa.melhor_em_casa_api.model.usuario.TipoUsuario;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponseDTO {
    private String nome;
    private String login;
    private String cpf;
    private TipoUsuario tipoUsuario;
}
