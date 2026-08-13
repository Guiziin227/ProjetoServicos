package dev.guiweber.backend.clientes.infra.persistence.adapter;

import dev.guiweber.backend.clientes.domain.model.Cliente;
import dev.guiweber.backend.clientes.domain.repository.ClienteRepository;
import dev.guiweber.backend.clientes.infra.persistence.entity.ClienteEntity;
import dev.guiweber.backend.clientes.infra.persistence.mapper.ClientePersistenceMapper;
import dev.guiweber.backend.clientes.infra.persistence.repository.SpringDataClienteRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ClientePersistenceAdapter implements ClienteRepository {

    private final SpringDataClienteRepository repository;
    private final ClientePersistenceMapper mapper;

    public ClientePersistenceAdapter(SpringDataClienteRepository repository, ClientePersistenceMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntity entity = mapper.toEntity(cliente);
        ClienteEntity savedEntity = repository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Cliente> findById(UUID id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Cliente> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Cliente> findByEmail(String email) {
        return repository.findByEmail(email).map(mapper::toDomain);
    }

    @Override
    public Optional<Cliente> findByName(String name) {
        return repository.findByName(name).map(mapper::toDomain);
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }
}
