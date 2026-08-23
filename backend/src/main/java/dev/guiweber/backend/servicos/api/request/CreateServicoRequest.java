package dev.guiweber.backend.servicos.api.request;

import jakarta.validation.constraints.Negative;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.UUID;

public record CreateServicoRequest(
        @NotNull(message = "ClienteId é obrigatório")
        UUID clienteId,

        @NotBlank(message = "Nome é obrigatório")
        @Size(max = 100, message = "Nome deve ter no máximo 100 caracteres")
        String nome,

        @NotBlank(message = "Descrição é obrigatória")
        @Size(max = 355, message = "Descrição deve ter no máximo 355 caracteres")
        String descricao,

        @Positive(message = "Preço deve ser positivo")
        BigDecimal preco
) {
}
