package br.com.melhoremcasa.melhor_em_casa_api.controller;


import br.com.melhoremcasa.melhor_em_casa_api.dtos.LoginRequest;
import br.com.melhoremcasa.melhor_em_casa_api.dtos.LoginResponse;
import br.com.melhoremcasa.melhor_em_casa_api.model.usuario.Usuario;
import br.com.melhoremcasa.melhor_em_casa_api.service.AuthService;
import br.com.melhoremcasa.melhor_em_casa_api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    private final UsuarioService usuarioService;


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login (@RequestBody LoginRequest request){
        String token = authService.authenticate(request.username(), request.password());
        Usuario usuario = usuarioService.buscarPorLogin(request.username());
        return ResponseEntity.ok(new LoginResponse(
                token,
                usuario.getId(),
                usuario.getNome(),
                usuario.getTipoUsuario().toString()
        ));
    }

}
