package br.com.melhoremcasa.melhor_em_casa_api.service;

import br.com.melhoremcasa.melhor_em_casa_api.model.usuario.Usuario;
import br.com.melhoremcasa.melhor_em_casa_api.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
    
    public Usuario verificarCredenciais(String login, String senha) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByLoginAndSenha(login, senha);
        return usuarioOptional.orElse(null);
    }

    public List<Usuario> getAllUsers(){
        return usuarioRepository.findAll();
    }

    public Usuario atualizarUsuario(Long id, Usuario usuarioDetalhado){
        var usuario = usuarioRepository.findById(id).orElseThrow();
        usuario.setNome(usuarioDetalhado.getNome());
        return usuarioRepository.save(usuario);

    }

    public void deletarUsuario(Long id){
        var usuario = usuarioRepository.findById(id).orElseThrow();
        usuarioRepository.delete(usuario);
    }

}
