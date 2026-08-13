package dev.guiweber.backend.clientes.infra.persistence.repository;

import dev.guiweber.backend.clientes.infra.persistence.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataClienteRepository extends JpaRepository<ClienteEntity, UUID> {

    Optional<ClienteEntity> findByEmail(String email);

    Optional<ClienteEntity> findByName(String name);

    boolean existsById(UUID id);
}
