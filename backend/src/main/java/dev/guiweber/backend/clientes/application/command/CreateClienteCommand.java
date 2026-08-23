package dev.guiweber.backend.clientes.application.command;

public record CreateClienteCommand(
        String nome,
        String email,
        String telefone
) {
}
