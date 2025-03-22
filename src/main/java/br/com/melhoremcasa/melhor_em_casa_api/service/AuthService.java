package br.com.melhoremcasa.melhor_em_casa_api.service;

import br.com.melhoremcasa.melhor_em_casa_api.exception.CustomException;
import br.com.melhoremcasa.melhor_em_casa_api.model.usuario.Usuario;
import br.com.melhoremcasa.melhor_em_casa_api.repository.UsuarioRepository;
import br.com.melhoremcasa.melhor_em_casa_api.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final JwtUtil jwtUtil;

    public String authenticate(String username, String password) {
        try {
            // Verifique se as credenciais estão corretas
            System.out.println("Tentando autenticar usuário: " + username);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            // Gerar o token após autenticação bem-sucedida
            return jwtUtil.generateToken(username);
        } catch (BadCredentialsException e) {
            System.out.println("Credenciais inválidas!");
            throw new CustomException("Credenciais inválidas!");
        }
    }
}
