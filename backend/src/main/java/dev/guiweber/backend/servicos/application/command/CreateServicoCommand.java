package dev.guiweber.backend.servicos.application.command;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateServicoCommand(
        UUID clienteId,
        String nome,
        String descricao,
        BigDecimal preco
) {
}
