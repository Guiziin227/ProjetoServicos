package dev.guiweber.backend.clientes.api.response;

import java.util.UUID;

public record ClienteReponse(
        UUID id,
        String nome,
        String email,
        String telefone
) {
}
