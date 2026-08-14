package com.example.helpdesk.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClienteRequestDTO {

    @NotBlank (message = "Nome é obrigatório ❌")
    private String nome;

    @NotBlank(message = "Telefone é obrigatório ❌")
    @Email(message = "Informe um e-mail válido ❌")
    private String email;

    @NotBlank(message = "Telefone é obrigatório ❌")
    private String telefone;

    public ClienteRequestDTO() {
    }

    public ClienteRequestDTO(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public @NotBlank(message = "Nome é obrigatório ❌") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório ❌") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Telefone é obrigatório ❌") @Email(message = "Informe um e-mail válido ❌") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "Telefone é obrigatório ❌") @Email(message = "Informe um e-mail válido ❌") String email) {
        this.email = email;
    }

    public @NotBlank(message = "Telefone é obrigatório ❌") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "Telefone é obrigatório ❌") String telefone) {
        this.telefone = telefone;
    }
}
