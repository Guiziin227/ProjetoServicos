package dev.guiweber.backend.servicos.infra.persistence.repository;

import dev.guiweber.backend.servicos.domain.model.Servico;
import dev.guiweber.backend.servicos.infra.persistence.entity.ServicoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SpringDataServicoRepository extends JpaRepository<ServicoEntity, UUID> {

    Optional<ServicoEntity> findByClienteId(UUID clientId);

    Optional<ServicoEntity> findByNome(String nome);

    Optional<List<ServicoEntity>> findByPreco(BigDecimal preco);

    boolean existsById(UUID id);
}
