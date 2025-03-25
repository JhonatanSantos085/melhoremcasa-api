package br.com.melhoremcasa.melhor_em_casa_api.dtos.login_dtos;

public record LoginResponse(
        String token,
        Long id,
        String nome,
        String tipoUsuario
) {

}
