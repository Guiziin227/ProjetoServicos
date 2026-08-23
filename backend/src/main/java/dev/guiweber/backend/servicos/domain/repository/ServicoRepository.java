package dev.guiweber.backend.servicos.domain.repository;

import dev.guiweber.backend.clientes.domain.model.Cliente;
import dev.guiweber.backend.servicos.domain.model.Servico;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ServicoRepository {

    Servico save(Servico servico);

    Optional<Servico> findById(UUID id);

    Optional<Servico> findByClienteId(UUID clientId);

    List<Servico> findAll();

    Optional<Servico> findByNome(String nome);

    Optional<List<Servico>> findByPreco(BigDecimal preco);

    boolean existsById(UUID id);
}
