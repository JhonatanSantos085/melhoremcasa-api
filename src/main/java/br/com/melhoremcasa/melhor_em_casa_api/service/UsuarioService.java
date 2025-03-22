package br.com.melhoremcasa.melhor_em_casa_api.service;

import br.com.melhoremcasa.melhor_em_casa_api.dtos.UsuarioRequestDTO;
import br.com.melhoremcasa.melhor_em_casa_api.dtos.UsuarioResponseDTO;
import br.com.melhoremcasa.melhor_em_casa_api.exception.CustomException;
import br.com.melhoremcasa.melhor_em_casa_api.mapper.UsuarioMapper;
import br.com.melhoremcasa.melhor_em_casa_api.model.usuario.Usuario;
import br.com.melhoremcasa.melhor_em_casa_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioMapper usuarioMapper;

    // Cria um novo usuário
    public UsuarioResponseDTO criarUsuario(UsuarioRequestDTO usuarioDTO) {
        // Verifica se o login já está em uso
        if (usuarioRepository.findByLogin(usuarioDTO.getLogin()).isPresent()) {
            throw new CustomException("Login já está em uso", HttpStatus.BAD_REQUEST);
        }

        // Verifica se o CPF já está cadastrado
        if (usuarioRepository.findByCpf(usuarioDTO.getCpf()).isPresent()) {
            throw new CustomException("CPF já cadastrado", HttpStatus.BAD_REQUEST);
        }

        // Mapeia o DTO para a entidade e criptografa a senha
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        usuario.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));

        // Salva o usuário no banco de dados
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuarioSalvo);
    }

    // Busca um usuário por ID
    public UsuarioResponseDTO buscarUsuarioPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new CustomException("Usuário não encontrado", HttpStatus.NOT_FOUND));
        return usuarioMapper.toDTO(usuario);
    }

    // Verifica as credenciais do usuário
    public Usuario verificarCredenciais(String login, String senha) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByLogin(login);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            // Verifica se a senha fornecida corresponde à senha criptografada
            if (passwordEncoder.matches(senha, usuario.getSenha())) {
                return usuario;
            }
        }
        throw new CustomException("Credenciais inválidas", HttpStatus.UNAUTHORIZED);
    }

    // Lista todos os usuários com paginação
    public Page<UsuarioResponseDTO> listarUsuarios(Pageable pageable) {
        return usuarioRepository.findAll(pageable)
                .map(usuarioMapper::toDTO);
    }

    // Atualiza um usuário existente
    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioRequestDTO usuarioDTO) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new CustomException("Usuário não encontrado", HttpStatus.NOT_FOUND));

        // Atualiza os campos permitidos
        usuario.setNome(usuarioDTO.getNome());
        usuario.setLogin(usuarioDTO.getLogin());

        // Criptografa a senha, caso tenha sido modificada
        if (usuarioDTO.getSenha() != null && !usuarioDTO.getSenha().isEmpty()) {
            usuario.setSenha(passwordEncoder.encode(usuarioDTO.getSenha()));
        }

        // Salva as alterações
        Usuario usuarioAtualizado = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuarioAtualizado);
    }

    // Deleta um usuário
    public void deletarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new CustomException("Usuário não encontrado", HttpStatus.NOT_FOUND);
        }
        usuarioRepository.deleteById(id);
    }
}