package dev.guiweber.backend.clientes.application.usecase;

import dev.guiweber.backend.clientes.domain.exceptions.ClienteNotFoundException;
import dev.guiweber.backend.clientes.domain.model.Cliente;
import dev.guiweber.backend.clientes.domain.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class FindByEmailClienteUseCase {

    private final ClienteRepository clienteRepository;

    public FindByEmailClienteUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional(readOnly = true)
    public Cliente execute(String email) {
        return clienteRepository.findByEmail(email).orElseThrow(
                () -> new ClienteNotFoundException(email)
        );
    }
}
