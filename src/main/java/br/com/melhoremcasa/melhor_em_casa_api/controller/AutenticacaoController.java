package br.com.melhoremcasa.melhor_em_casa_api.controller;


import br.com.melhoremcasa.melhor_em_casa_api.dtos.LoginRequestDTO;
import br.com.melhoremcasa.melhor_em_casa_api.service.AutenticacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
@RequiredArgsConstructor
public class AutenticacaoController {

    private final AutenticacaoService autenticacaoService;

    @PostMapping("/login")
    public ResponseEntity<String> login (@RequestBody LoginRequestDTO loginRequestDTO){
        boolean autenticado = autenticacaoService.autenticar(loginRequestDTO.login(), loginRequestDTO.senha());
        if (autenticado){
            return ResponseEntity.ok("Login bem-sucedido");
        }
        return ResponseEntity.status(401).body("Credenciais invalidas");
    }

}
