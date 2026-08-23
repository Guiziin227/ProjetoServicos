package dev.guiweber.backend.clientes.domain.exceptions;

public class ClienteNotFoundException extends RuntimeException {
    public ClienteNotFoundException(String message) {
        super("Cliente não encontrado: " + message);
    }
}
