package dev.guiweber.backend.clientes.api.mapper;

import dev.guiweber.backend.clientes.api.request.CreateClienteRequest;
import dev.guiweber.backend.clientes.api.request.UpdateClienteRequest;
import dev.guiweber.backend.clientes.api.response.ClienteReponse;
import dev.guiweber.backend.clientes.application.command.CreateClienteCommand;
import dev.guiweber.backend.clientes.application.command.UpdateClienteCommand;
import dev.guiweber.backend.clientes.domain.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteApiMapper {

    public CreateClienteCommand toCreateClienteCommand(CreateClienteRequest request) {
        return new CreateClienteCommand(
                request.nome(),
                request.email(),
                request.telefone());
    }

    public UpdateClienteCommand toUpdateClienteCommand(UpdateClienteRequest request) {
        return new UpdateClienteCommand(
                request.nome(),
                request.email(),
                request.telefone());
    }

    public ClienteReponse toClienteResponse(Cliente cliente) {
        return new ClienteReponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone());
    }

}
