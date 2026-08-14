package com.example.helpdesk.service;

import com.example.helpdesk.dto.FornecedorRequestDTO;
import com.example.helpdesk.dto.FornecedorResponseDTO;
import com.example.helpdesk.model.FornecedorModel;
import com.example.helpdesk.repository.FornecedorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository repository;


    // Aqui começamos o CRUD (Create(criar), Read(listar), Update(Atualizar), Delete(Deletar)

    // Read (Todos)
    public List<FornecedorResponseDTO> listarFornecedores() {
        return repository
                .findAll()
                .stream()
                .map(f -> new FornecedorResponseDTO(
                        f.getNome(),
                        f.getEmail(),
                        f.getTelefone()
                ))
                .toList();
    }

    // Read (Por id, caso precise listar um por um)
    public FornecedorResponseDTO buscarPorId(Long id) {
        FornecedorModel f = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Este fornecedor não existe!"));

        return new FornecedorResponseDTO(
                f.getNome(),
                f.getEmail(),
                f.getTelefone()
        );
    }

    // Create
    public FornecedorModel salvarFornecedor(FornecedorRequestDTO dto) {
        if (repository.findByCnpj(dto.getCnpj()).isPresent()) {
            throw new RuntimeException("Fornecedor já cadastrado!");
        }

        FornecedorModel novoFornecedor = new FornecedorModel();
        novoFornecedor.setNome(dto.getNome());
        novoFornecedor.setCnpj(dto.getCnpj());
        novoFornecedor.setEmail(dto.getEmail());
        novoFornecedor.setTelefone(dto.getTelefone());

        return repository.save(novoFornecedor);
    }

    //Update
    @Transactional
    public FornecedorResponseDTO atualizarFornecedor(Long id, FornecedorRequestDTO dto){
        FornecedorModel fornecedorExistente = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Este fornecedor não existe!"));

        fornecedorExistente.setNome(dto.getNome());
        fornecedorExistente.setCnpj(dto.getCnpj());
        fornecedorExistente.setEmail(dto.getEmail());
        fornecedorExistente.setTelefone(dto.getTelefone());

        FornecedorModel fornecedorAtualizado = repository.save(fornecedorExistente);

        return new FornecedorResponseDTO(
                fornecedorAtualizado.getNome(),
                fornecedorAtualizado.getEmail(),
                fornecedorAtualizado.getTelefone()
        );
    }

    //Delete
    @Transactional
    public void deletarFornecedor(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Este fornecedor não existe!");
        }
        repository.deleteById(id);
    }
}

