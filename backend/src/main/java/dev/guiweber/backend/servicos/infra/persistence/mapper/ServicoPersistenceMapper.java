package dev.guiweber.backend.servicos.infra.persistence.mapper;

import dev.guiweber.backend.servicos.domain.model.Servico;
import dev.guiweber.backend.servicos.infra.persistence.entity.ServicoEntity;
import org.springframework.stereotype.Component;

@Component
public class ServicoPersistenceMapper {

    public Servico toDomain(ServicoEntity entity) {
        return new Servico(
                entity.getId(),
                entity.getClientId(),
                entity.getNome(),
                entity.getDescricao(),
                entity.getPreco()
        );
    }

    public ServicoEntity toEntity(Servico servico) {
        return new ServicoEntity(
                servico.getId(),
                servico.getClientId(),
                servico.getNome(),
                servico.getDescricao(),
                servico.getPreco()
        );
    }
}
