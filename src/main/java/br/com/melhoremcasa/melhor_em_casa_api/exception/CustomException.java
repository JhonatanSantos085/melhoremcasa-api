package br.com.melhoremcasa.melhor_em_casa_api.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

    private final HttpStatus status;

    // Construtor que recebe uma mensagem e um HttpStatus
    public CustomException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    // Construtor que recebe apenas uma mensagem (status padrão: BAD_REQUEST)
    public CustomException(String message) {
        this(message, HttpStatus.BAD_REQUEST);
    }

    // Getter para o status
    public HttpStatus getStatus() {
        return status;
    }
}