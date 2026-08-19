package dev.guiweber.backend.clientes.api.controller;

import dev.guiweber.backend.clientes.api.mapper.ClienteApiMapper;
import dev.guiweber.backend.clientes.api.request.CreateClienteRequest;
import dev.guiweber.backend.clientes.api.request.UpdateClienteRequest;
import dev.guiweber.backend.clientes.api.response.ClienteReponse;
import dev.guiweber.backend.clientes.application.command.CreateClienteCommand;
import dev.guiweber.backend.clientes.application.command.UpdateClienteCommand;
import dev.guiweber.backend.clientes.application.usecase.CreateClienteUseCase;
import dev.guiweber.backend.clientes.application.usecase.FindAllClienteUseCase;
import dev.guiweber.backend.clientes.application.usecase.FindByEmailClienteUseCase;
import dev.guiweber.backend.clientes.application.usecase.FindByNameClienteUseCase;
import dev.guiweber.backend.clientes.application.usecase.UpdateClienteUseCase;
import dev.guiweber.backend.clientes.domain.model.Cliente;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final CreateClienteUseCase createClienteUseCase;
    private final ClienteApiMapper mapper;
    private final FindAllClienteUseCase findAllClienteUseCase;
    private final FindByEmailClienteUseCase findByEmailClienteUseCase;
    private final FindByNameClienteUseCase findByNameClienteUseCase;
    private final UpdateClienteUseCase updateClienteUseCase;

    public ClienteController(CreateClienteUseCase createClienteUseCase, ClienteApiMapper mapper, FindAllClienteUseCase findAllClienteUseCase, FindByEmailClienteUseCase findByEmailClienteUseCase, FindByNameClienteUseCase findByNameClienteUseCase, UpdateClienteUseCase updateClienteUseCase) {
        this.createClienteUseCase = createClienteUseCase;
        this.mapper = mapper;
        this.findAllClienteUseCase = findAllClienteUseCase;
        this.findByEmailClienteUseCase = findByEmailClienteUseCase;
        this.findByNameClienteUseCase = findByNameClienteUseCase;
        this.updateClienteUseCase = updateClienteUseCase;
    }

    @PostMapping
    public ResponseEntity<ClienteReponse> createCliente(
            @Valid @RequestBody CreateClienteRequest request) {

        CreateClienteCommand createClienteCommand = mapper.toCreateClienteCommand(request);

        Cliente cliente = createClienteUseCase.execute(createClienteCommand);

        return ResponseEntity.ok(mapper.toClienteResponse(cliente));
    }

    @GetMapping
    public ResponseEntity<List<ClienteReponse>> listClientes() {

        List<ClienteReponse> reponse = findAllClienteUseCase.execute().stream()
                .map(mapper::toClienteResponse)
                .toList();

        return ResponseEntity.ok(reponse);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ClienteReponse> getClienteByEmail(
            @PathVariable String email) {
        Cliente cliente = findByEmailClienteUseCase.execute(email);
        return ResponseEntity.ok(mapper.toClienteResponse(cliente));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ClienteReponse> getClienteByName(
            @PathVariable String name) {
        Cliente cliente = findByNameClienteUseCase.execute(name);
        return ResponseEntity.ok(mapper.toClienteResponse(cliente));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClienteReponse> updateCliente(
            @PathVariable UUID id,
            @Valid @RequestBody UpdateClienteRequest request) {

        UpdateClienteCommand updateClienteCommand = mapper.toUpdateClienteCommand(request);

        Cliente cliente = updateClienteUseCase.execute(id, updateClienteCommand);

        return ResponseEntity.ok(mapper.toClienteResponse(cliente));
    }


}
