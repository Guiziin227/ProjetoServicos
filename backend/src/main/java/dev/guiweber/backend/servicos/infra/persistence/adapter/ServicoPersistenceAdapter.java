package dev.guiweber.backend.servicos.infra.persistence.adapter;

import dev.guiweber.backend.servicos.domain.model.Servico;
import dev.guiweber.backend.servicos.domain.repository.ServicoRepository;
import dev.guiweber.backend.servicos.infra.persistence.entity.ServicoEntity;
import dev.guiweber.backend.servicos.infra.persistence.mapper.ServicoPersistenceMapper;
import dev.guiweber.backend.servicos.infra.persistence.repository.SpringDataServicoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class ServicoPersistenceAdapter implements ServicoRepository {

    private final ServicoPersistenceMapper mapper;
    private final SpringDataServicoRepository repository;

    public ServicoPersistenceAdapter(ServicoPersistenceMapper mapper, SpringDataServicoRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public Servico save(Servico servico) {
        ServicoEntity entity = mapper.toEntity(servico);
        ServicoEntity savedEntity = repository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Servico> findById(UUID id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Optional<Servico> findByClienteId(UUID clientId) {
        return repository.findByClientId(clientId).map(mapper::toDomain);
    }

    @Override
    public List<Servico> findAll() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public Optional<Servico> findByNome(String nome) {
        return repository.findByNome(nome).map(mapper::toDomain);
    }

    @Override
    public Optional<List<Servico>> findByPreco(BigDecimal preco) {
        return repository.findByPreco(preco).map(entities -> entities.stream()
                .map(mapper::toDomain)
                .toList());
    }

    @Override
    public boolean existsById(UUID id) {
        return repository.existsById(id);
    }
}
