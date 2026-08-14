package com.example.helpdesk.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FornecedorRequestDTO {

    @NotBlank(message = "O nome da empresa é obrigatório")
    @Size(min = 3,max = 40, message = "O nome deve conter o mínimo de 3 e máximo de 40 caracteres" )
    private String nome;

    @NotBlank(message = "O cnpj é obrigatório")
    @Size(min = 14, max = 18, message = "O cnpj deve conter o mínimo de 14 e máximo de 18 dígitos")
    private String cnpj;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O email inserido deve ser válido")
    private String email;

    @NotBlank(message = "O número para contato é obrigatório")
    @Size(min = 9, max = 11, message = "O telefone deve conter o mínimo de 9 e máximo 11 dígitos")
    private String telefone;

    public FornecedorRequestDTO() {
    }

    public FornecedorRequestDTO(String nome, String cnpj, String email, String telefone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.email = email;
        this.telefone = telefone;
    }

    public @NotBlank(message = "O nome da empresa é obrigatório") @Size(min = 3, max = 40, message = "O nome deve conter o mínimo de 3 e máximo de 40 caracteres") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "O nome da empresa é obrigatório") @Size(min = 3, max = 40, message = "O nome deve conter o mínimo de 3 e máximo de 40 caracteres") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "O cnpj é obrigatório") @Size(min = 14, max = 18, message = "O cnpj deve conter o mínimo de 14 e máximo de 18 dígitos") String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotBlank(message = "O cnpj é obrigatório") @Size(min = 14, max = 18, message = "O cnpj deve conter o mínimo de 14 e máximo de 18 dígitos") String cnpj) {
        this.cnpj = cnpj;
    }

    public @NotBlank(message = "O email é obrigatório") @Email(message = "O email inserido deve ser válido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "O email é obrigatório") @Email(message = "O email inserido deve ser válido") String email) {
        this.email = email;
    }

    public @NotBlank(message = "O número para contato é obrigatório") @Size(min = 9, max = 11, message = "O telefone deve conter o mínimo de 9 e máximo 11 dígitos") String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank(message = "O número para contato é obrigatório") @Size(min = 9, max = 11, message = "O telefone deve conter o mínimo de 9 e máximo 11 dígitos") String telefone) {
        this.telefone = telefone;
    }
}
