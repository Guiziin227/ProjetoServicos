package dev.guiweber.backend.servicos.api.mapper;

import dev.guiweber.backend.servicos.api.request.CreateServicoRequest;
import dev.guiweber.backend.servicos.api.response.ServicoResponse;
import dev.guiweber.backend.servicos.application.command.CreateServicoCommand;
import dev.guiweber.backend.servicos.domain.model.Servico;
import org.springframework.stereotype.Component;

@Component
public class ServicoApiMapper {
    public CreateServicoCommand toCreateServicoCommand(CreateServicoRequest request) {
        return new CreateServicoCommand(request.clienteId(), request.nome(), request.descricao(), request.preco());
    }

    public ServicoResponse toResponse(Servico servico){
        return new ServicoResponse(
                servico.getId(),
                servico.getClientId(),
                servico.getNome(),
                servico.getDescricao(),
                servico.getPreco());
    }
}
