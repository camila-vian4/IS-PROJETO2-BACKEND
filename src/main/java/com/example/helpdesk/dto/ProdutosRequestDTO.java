package com.example.helpdesk.dto.funcionario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProdutosRequestDTO {

    @NotBlank (message = "Nome é obrigatório ❌")
    private String nome;

    @NotNull(message = "Quantidade é obrigatório ❌")
    private int  quantidade;

    @NotNull(message = "Preço é obrigatório ❌")
    private Double preco;

    public ProdutosRequestDTO() {
    }

    public ProdutosRequestDTO(String nome, int quantidade, Double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public @NotBlank(message = "Nome é obrigatório ❌") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório ❌") String nome) {
        this.nome = nome;
    }

    @NotNull(message = "Quantidade é obrigatório ❌")
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(@NotNull(message = "Quantidade é obrigatório ❌") int quantidade) {
        this.quantidade = quantidade;
    }

    public @NotNull(message = "Preço é obrigatório ❌") Double getPreco() {
        return preco;
    }

    public void setPreco(@NotNull(message = "Preço é obrigatório ❌") Double preco) {
        this.preco = preco;
    }
}
