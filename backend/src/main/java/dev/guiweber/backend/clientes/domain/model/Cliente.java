package dev.guiweber.backend.clientes.domain.model;

import lombok.Getter;

import java.util.Objects;
import java.util.UUID;

@Getter
public class Cliente {

    private UUID id;
    private String nome;
    private String email;
    private String telefone;

    public Cliente(UUID id, String nome, String email, String telefone) {
        this.id = Objects.requireNonNull(id, "id não pode ser nulo");

        validateNome(nome);
        validateEmail(email);
        validateTelefone(telefone);

        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public static Cliente create(
            String nome,
            String email,
            String telefone
    ){
        return new Cliente(
                UUID.randomUUID(),
                nome,
                email,
                telefone);
    }

    public static Cliente restore(
            UUID id,
            String nome,
            String email,
            String telefone
    ){
        return new Cliente(
                id,
                nome,
                email,
                telefone
        );
    }



    private void validateNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
    }
    private void validateEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email não pode ser nulo ou vazio");
        }
    }
    private void validateTelefone(String telefone) {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("Telefone não pode ser nulo ou vazio");
        }
    }
}
