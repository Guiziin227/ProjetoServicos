package dev.guiweber.backend.clientes.application.usecase;

import dev.guiweber.backend.clientes.application.command.CreateClienteCommand;
import dev.guiweber.backend.clientes.domain.exceptions.ClienteEmailAlreadyExistsException;
import dev.guiweber.backend.clientes.domain.exceptions.ClienteTelefoneAlreadyExistsException;
import dev.guiweber.backend.clientes.domain.model.Cliente;
import dev.guiweber.backend.clientes.domain.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateClienteUseCase {

    private final ClienteRepository clienteRepository;

    public CreateClienteUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Cliente execute(
            CreateClienteCommand command
    ) {
        verifyDuplicateData(command);

        Cliente cliente = Cliente.create(
                command.nome(),
                command.email(),
                command.telefone()
        );

        return clienteRepository.save(cliente);
    }

    private void verifyDuplicateData(CreateClienteCommand command){
        if(clienteRepository.findByEmail(command.email()).isPresent()){
            throw new ClienteEmailAlreadyExistsException(command.email());
        }

        if(clienteRepository.findByTelefone(command.telefone()).isPresent()){
            throw new ClienteTelefoneAlreadyExistsException(command.telefone());
        }
    }
}
