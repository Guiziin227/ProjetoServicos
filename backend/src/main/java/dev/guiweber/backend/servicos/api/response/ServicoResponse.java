package dev.guiweber.backend.servicos.api.response;

import java.math.BigDecimal;
import java.util.UUID;

public record ServicoResponse(
        UUID id,
        UUID clienteId,
        String nome,
        String descricao,
        BigDecimal preco
) {
}
