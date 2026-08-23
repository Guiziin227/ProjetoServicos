package dev.guiweber.backend.servicos.domain.model;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Getter
public class Servico {

    private UUID id;
    private UUID clientId;

    private String nome;
    private String descricao;
    private BigDecimal preco;


    public Servico(
            UUID id,
            UUID clientId,
            String nome,
            String descricao,
            BigDecimal preco) {
        this.id = Objects.requireNonNull(id, "O id do serviço não pode ser nulo");
        this.clientId = Objects.requireNonNull(clientId, "O id do cliente não pode ser nulo");

        validateNome(nome);
        validatePreco(preco);

        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public static Servico create(
            UUID clientId,
            String nome,
            String descricao,
            BigDecimal preco
    ){
        return new Servico(
                UUID.randomUUID(),
                clientId,
                nome,
                descricao,
                preco);
    }

    public static Servico restore(
            UUID id,
            UUID clientId,
            String nome,
            String descricao,
            BigDecimal preco
    ){
        return new Servico(
                id,
                clientId,
                nome,
                descricao,
                preco
        );
    }

    public void alterarNome(String nome) {
        validateNome(nome);
        this.nome = nome;
    }

    public void alterarDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void alterarPreco(BigDecimal preco) {
        validatePreco(preco);
        this.preco = preco;
    }

    private void validatePreco(BigDecimal preco) {
        if (preco == null || preco.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(
                    "Preço não pode ser nulo ou negativo"
            );
        }
    }

    private void validateNome(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
        }
    }

}