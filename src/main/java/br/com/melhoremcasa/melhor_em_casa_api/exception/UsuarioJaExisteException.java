package br.com.melhoremcasa.melhor_em_casa_api.exception;

public class UsuarioJaExisteException extends RuntimeException {
    public UsuarioJaExisteException(String message) {
        super(message);
    }
}
