package br.com.melhoremcasa.melhor_em_casa_api.mapper;

import br.com.melhoremcasa.melhor_em_casa_api.dtos.UsuarioRequestDTO;
import br.com.melhoremcasa.melhor_em_casa_api.dtos.UsuarioResponseDTO;
import br.com.melhoremcasa.melhor_em_casa_api.model.usuario.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(UsuarioRequestDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setLogin(dto.getLogin());
        usuario.setCpf(dto.getCpf());
        usuario.setTipoUsuario(dto.getTipoUsuario());
        usuario.setSenha(dto.getSenha()); // Senha será criptografada no service
        return usuario;
    }

    public UsuarioResponseDTO toDTO(Usuario usuario) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setNome(usuario.getNome());
        dto.setLogin(usuario.getLogin());
        dto.setCpf(usuario.getCpf());
        dto.setTipoUsuario(usuario.getTipoUsuario());
        return dto;
    }
}
