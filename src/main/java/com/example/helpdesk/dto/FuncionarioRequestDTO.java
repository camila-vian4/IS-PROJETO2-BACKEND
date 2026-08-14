package com.example.helpdesk.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FuncionarioRequestDTO {

    @NotBlank(message = "Preencher o nome é obrigatório.")
    @Size(max = 200, message = "O nome deve ter no máximo 200 caracteres.")
    private String nome;

    @NotBlank(message = "Preencher a matricula é obrigatória.")
    @Size(min = 10, max = 14, message = "A matrícula deve estar entre 10 à 14 caracteres.")
    private String matricula;

    @NotBlank(message = "Preencher o cargo é obrigatório.")
    private String cargo;

    public FuncionarioRequestDTO() {
    }

    public FuncionarioRequestDTO(String nome, String matricula, String cargo) {
        this.nome = nome;
        this.matricula = matricula;
        this.cargo = cargo;
    }

    public @NotBlank(message = "Preencher o nome é obrigatório.") @Size(max = 200, message = "O nome deve ter no máximo 200 caracteres.") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Preencher o nome é obrigatório.") @Size(max = 200, message = "O nome deve ter no máximo 200 caracteres.") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Preencher a matricula é obrigatória.") @Size(min = 10, max = 14, message = "A matrícula deve estar entre 10 à 14 caracteres.") String getMatricula() {
        return matricula;
    }

    public void setMatricula(@NotBlank(message = "Preencher a matricula é obrigatória.") @Size(min = 10, max = 14, message = "A matrícula deve estar entre 10 à 14 caracteres.") String matricula) {
        this.matricula = matricula;
    }

    public @NotBlank(message = "Preencher o cargo é obrigatório.") String getCargo() {
        return cargo;
    }

    public void setCargo(@NotBlank(message = "Preencher o cargo é obrigatório.") String cargo) {
        this.cargo = cargo;
    }
}
