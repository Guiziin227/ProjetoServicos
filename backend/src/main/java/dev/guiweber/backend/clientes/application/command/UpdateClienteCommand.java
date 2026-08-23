package dev.guiweber.backend.clientes.application.command;

public record UpdateClienteCommand(
        String nome,
        String email,
        String telefone
) {
}
