package br.com.melhoremcasa.melhor_em_casa_api.service;


import br.com.melhoremcasa.melhor_em_casa_api.model.usuario.Usuario;
import br.com.melhoremcasa.melhor_em_casa_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutenticacaoService {

    private final UsuarioRepository usuarioRepository;

    private final PasswordEncoder passwordEncoder;

    public boolean autenticar(String login, String senha){
        Usuario usuario = usuarioRepository.findByLogin(login)
                .orElseThrow( () -> new RuntimeException("Usuario nao encontrado"));

        return passwordEncoder.matches(senha, usuario.getSenha());

    }


}
