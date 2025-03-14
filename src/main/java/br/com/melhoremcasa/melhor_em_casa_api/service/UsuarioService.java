package br.com.melhoremcasa.melhor_em_casa_api.service;

import br.com.melhoremcasa.melhor_em_casa_api.model.usuario.Usuario;
import br.com.melhoremcasa.melhor_em_casa_api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario){
        System.out.println(usuario.getCpf());
        return usuarioRepository.save(usuario);
    }
    
    public Usuario verificarCredenciais(String login, String senha) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByLoginAndSenha(login, senha);
        return usuarioOptional.orElse(null);
    }

    public List<Usuario> getAllUsers(){
        return usuarioRepository.findAll();
    }

}
