package dev.guiweber.backend.clientes.infra.persistence.mapper;

import dev.guiweber.backend.clientes.domain.model.Cliente;
import dev.guiweber.backend.clientes.infra.persistence.entity.ClienteEntity;
import org.springframework.stereotype.Component;

@Component
public class ClientePersistenceMapper {

    public ClienteEntity toEntity(Cliente cliente) {
        return new ClienteEntity(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone()
        );
    }

    public Cliente toDomain(ClienteEntity entity) {
        return Cliente.restore(
                entity.getId(),
                entity.getNome(),
                entity.getEmail(),
                entity.getTelefone()
        );
    }

    public void updateEntity(ClienteEntity entity, Cliente cliente) {
        entity.setNome(cliente.getNome());
        entity.setEmail(cliente.getEmail());
        entity.setTelefone(cliente.getTelefone());
    }

}
