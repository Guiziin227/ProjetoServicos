package dev.guiweber.backend.clientes.application.usecase;

import dev.guiweber.backend.clientes.application.command.CreateClienteCommand;
import dev.guiweber.backend.clientes.application.command.UpdateClienteCommand;
import dev.guiweber.backend.clientes.domain.exceptions.ClienteEmailAlreadyExistsException;
import dev.guiweber.backend.clientes.domain.exceptions.ClienteNotFoundException;
import dev.guiweber.backend.clientes.domain.exceptions.ClienteTelefoneAlreadyExistsException;
import dev.guiweber.backend.clientes.domain.model.Cliente;
import dev.guiweber.backend.clientes.domain.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UpdateClienteUseCase {

    private final ClienteRepository clienteRepository;

    public UpdateClienteUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }


    @Transactional
    public Cliente execute(UUID id, UpdateClienteCommand updateClienteCommand) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new ClienteNotFoundException("Cliente not found"));

        verifyDuplicateData(updateClienteCommand);

        cliente = Cliente.restore(
                cliente.getId(),
                updateClienteCommand.nome(),
                updateClienteCommand.email(),
                updateClienteCommand.telefone()
        );

        return clienteRepository.save(cliente);
    }

    private void verifyDuplicateData(UpdateClienteCommand command){
        if(clienteRepository.findByEmail(command.email()).isPresent()){
            throw new ClienteEmailAlreadyExistsException(command.email());
        }

        if(clienteRepository.findByTelefone(command.telefone()).isPresent()){
            throw new ClienteTelefoneAlreadyExistsException(command.telefone());
        }
    }

}
