package dev.guiweber.backend.servicos.api.controller;

import dev.guiweber.backend.servicos.api.mapper.ServicoApiMapper;
import dev.guiweber.backend.servicos.api.request.CreateServicoRequest;
import dev.guiweber.backend.servicos.api.response.ServicoResponse;
import dev.guiweber.backend.servicos.application.command.CreateServicoCommand;
import dev.guiweber.backend.servicos.application.usecase.CreateServicoUseCase;
import dev.guiweber.backend.servicos.domain.model.Servico;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    private final ServicoApiMapper mapper;

    private final CreateServicoUseCase createServicoUseCase;

    public ServicoController(ServicoApiMapper mapper, CreateServicoUseCase createServicoUseCase) {
        this.mapper = mapper;
        this.createServicoUseCase = createServicoUseCase;
    }

    @PostMapping
    public ResponseEntity<ServicoResponse> create(@Valid @RequestBody CreateServicoRequest request) {
        CreateServicoCommand command = mapper.toCreateServicoCommand(request);

        Servico servico = createServicoUseCase.execute(command);

        return ResponseEntity.ok(mapper.toResponse(servico));
    }

}
