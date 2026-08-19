package dev.guiweber.backend.clientes.domain.repository;

import dev.guiweber.backend.clientes.domain.model.Cliente;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClienteRepository {
    Cliente save(Cliente cliente);

    Optional<Cliente> findById(UUID id);

    List<Cliente> findAll();

    Optional<Cliente> findByEmail(String email);

    Optional<Cliente> findByTelefone(String telefone);

    Optional<Cliente> findByNome(String nome);

    boolean existsById(UUID id);
}
