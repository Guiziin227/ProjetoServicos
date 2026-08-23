package dev.guiweber.backend.servicos.application.usecase;

import dev.guiweber.backend.clientes.domain.exceptions.ClienteNotFoundException;
import dev.guiweber.backend.clientes.domain.repository.ClienteRepository;
import dev.guiweber.backend.servicos.application.command.CreateServicoCommand;
import dev.guiweber.backend.servicos.domain.model.Servico;
import dev.guiweber.backend.servicos.domain.repository.ServicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateServicoUseCase {

    private final ServicoRepository servicoRepository;
    private final ClienteRepository clienteRepository;

    public CreateServicoUseCase(ServicoRepository servicoRepository, ClienteRepository clienteRepository) {
        this.servicoRepository = servicoRepository;
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public Servico execute(CreateServicoCommand command) {

        clienteRepository.findById(command.clienteId())
                .orElseThrow(() -> new ClienteNotFoundException("Cliente não cadastrado no sistema"));

        Servico servico = Servico.create(
                command.clienteId(),
                command.nome(),
                command.descricao(),
                command.preco()
        );

        return servicoRepository.save(servico);
    }
}
