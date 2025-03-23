package br.com.melhoremcasa.melhor_em_casa_api.controller;


import br.com.melhoremcasa.melhor_em_casa_api.dtos.LoginRequest;
import br.com.melhoremcasa.melhor_em_casa_api.dtos.LoginResponse;
import br.com.melhoremcasa.melhor_em_casa_api.security.JwtUtil;
import br.com.melhoremcasa.melhor_em_casa_api.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login (@RequestBody LoginRequest request){
        String token = authService.authenticate(request.username(), request.password());
        return ResponseEntity.ok(new LoginResponse(token));
    }

}
