package dev.guiweber.backend.servicos.domain.exceptions;

public class ServicoNotFoundException extends RuntimeException {
    public ServicoNotFoundException(String message) {
        super("Serviço não encontrado: " + message);
    }
}
