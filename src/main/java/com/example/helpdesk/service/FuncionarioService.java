package com.example.helpdesk.service;

import com.example.helpdesk.dto.FuncionarioRequestDTO;
import com.example.helpdesk.dto.FuncionarioResponseDTO;
import com.example.helpdesk.model.FuncionarioModel;
import com.example.helpdesk.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository repository;

    public FuncionarioModel cadastrar(FuncionarioRequestDTO funcionarioDTO){
        if(repository.findByMatricula(funcionarioDTO.getMatricula()).isPresent()){
            throw new RuntimeException("Funcionário já cadastrado! ❌");
        }

        FuncionarioModel funcionario = new FuncionarioModel();
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setMatricula(funcionarioDTO.getMatricula());
        funcionario.setCargo(funcionarioDTO.getCargo());

        return repository.save(funcionario);
    }

    public List<FuncionarioResponseDTO> listar(){
        return repository
                .findAll()
                .stream()
                .map(f -> new FuncionarioResponseDTO(f.getId(), f.getNome(), f.getMatricula(), f.getCargo()))
                .toList();
    }

    public FuncionarioModel atualizar(Long id, FuncionarioRequestDTO funcionarioDTO){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Funcionário não encontrado! 🔍");
        }

        FuncionarioModel novoFuncionario = new FuncionarioModel();
        novoFuncionario.setId(id);
        novoFuncionario.setNome(funcionarioDTO.getNome());
        novoFuncionario.setMatricula(funcionarioDTO.getMatricula());
        novoFuncionario.setCargo(funcionarioDTO.getCargo());

        return repository.save(novoFuncionario);
    }

    public void deletar(Long id){
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("Funcionário não encontrado! 🔍");
        }

        repository.deleteById(id);
    }

}
