package com.example.helpdesk.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class FuncionarioRequestDTO {

    @NotBlank (message = "Nome é obrigatório ❌")
    @Size(min = 3,max = 40, message = "O nome deve conter o mínimo de 3 e máximo de 40 caracteres" )
    private String nome;

    @NotBlank (message = "Matricula é obrigatório ❌")
    @Size(min = 5, max = 20, message = "A matricula deve conter o mínimo de 14 e máximo de 18 dígitos")
    private String matricula;

    @NotBlank (message = "Cargo é obrigatório ❌")
    private String cargo;

    public FuncionarioRequestDTO() {
    }

    public FuncionarioRequestDTO(String nome, String matricula, String cargo) {
        this.nome = nome;
        this.matricula = matricula;
        this.cargo = cargo;
    }

    public @NotBlank(message = "Nome é obrigatório ❌") @Size(min = 3, max = 40, message = "O nome deve conter o mínimo de 3 e máximo de 40 caracteres") String getNome() {
        return nome;
    }

    public void setNome(@NotBlank(message = "Nome é obrigatório ❌") @Size(min = 3, max = 40, message = "O nome deve conter o mínimo de 3 e máximo de 40 caracteres") String nome) {
        this.nome = nome;
    }

    public @NotBlank(message = "Matricula é obrigatório ❌") @Size(min = 5, max = 20, message = "A matricula deve conter o mínimo de 14 e máximo de 18 dígitos") String getMatricula() {
        return matricula;
    }

    public void setMatricula(@NotBlank(message = "Matricula é obrigatório ❌") @Size(min = 5, max = 20, message = "A matricula deve conter o mínimo de 14 e máximo de 18 dígitos") String matricula) {
        this.matricula = matricula;
    }

    public @NotBlank(message = "Cargo é obrigatório ❌") String getCargo() {
        return cargo;
    }

    public void setCargo(@NotBlank(message = "Cargo é obrigatório ❌") String cargo) {
        this.cargo = cargo;
    }
}
