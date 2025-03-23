package br.com.melhoremcasa.melhor_em_casa_api.controller;

import br.com.melhoremcasa.melhor_em_casa_api.dtos.UsuarioRequestDTO;
import br.com.melhoremcasa.melhor_em_casa_api.dtos.UsuarioResponseDTO;
import br.com.melhoremcasa.melhor_em_casa_api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    // Registra um novo usuário
    @PostMapping("/register")
    public ResponseEntity<UsuarioResponseDTO> registerUser(@RequestBody @Valid UsuarioRequestDTO usuarioDTO) {
        UsuarioResponseDTO responseDTO = usuarioService.criarUsuario(usuarioDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    // Lista todos os usuários com paginação
    @GetMapping
    public ResponseEntity<Page<UsuarioResponseDTO>> listarUsuarios(Pageable pageable) {
        Page<UsuarioResponseDTO> usuarios = usuarioService.listarUsuarios(pageable);
        return ResponseEntity.ok(usuarios);
    }

    // Busca um usuário por ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarUsuarioPorId(@PathVariable Long id) {
        UsuarioResponseDTO usuario = usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.ok(usuario);
    }

    // Atualiza um usuário existente
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> atualizarUsuario(
            @PathVariable Long id, @RequestBody @Valid UsuarioRequestDTO usuarioDTO) {
        UsuarioResponseDTO responseDTO = usuarioService.atualizarUsuario(id, usuarioDTO);
        return ResponseEntity.ok(responseDTO);
    }

    // Deleta um usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        usuarioService.deletarUsuario(id);
        return ResponseEntity.noContent().build();
    }
}