package dev.guiweber.backend.clientes.domain.exceptions;

public class ClienteEmailAlreadyExistsException extends RuntimeException {
    public ClienteEmailAlreadyExistsException(String message) {
        super("Um cliente com esse email já existe: " + message);
    }
}
