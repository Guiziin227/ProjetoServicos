package dev.guiweber.backend.clientes.domain.exceptions;

public class ClienteTelefoneAlreadyExistsException extends RuntimeException {
    public ClienteTelefoneAlreadyExistsException(String message) {
        super("Um cliente com esse telefone já existe: " + message);
    }
}
