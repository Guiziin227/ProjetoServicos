package dev.guiweber.backend.clientes.application.usecase;

import dev.guiweber.backend.clientes.domain.model.Cliente;
import dev.guiweber.backend.clientes.domain.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FindAllClienteUseCase {

    private final ClienteRepository clienteRepository;

    public FindAllClienteUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional(readOnly = true)
    public List<Cliente> execute(){
        return clienteRepository.findAll();
    }
}
