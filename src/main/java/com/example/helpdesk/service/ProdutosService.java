package com.example.helpdesk.service;

import com.example.helpdesk.dto.funcionario.ProdutosRequestDTO;
import com.example.helpdesk.dto.funcionario.ProdutosResponseDTO;
import com.example.helpdesk.model.ProdutosModel;
import com.example.helpdesk.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosService {

    @Autowired
    private ProdutosRepository repository;

    public List<ProdutosResponseDTO> listarTodos(){
        return repository.findAll()
                .stream()
                .map(ProdutosModel -> new ProdutosResponseDTO(ProdutosModel.getNome(), ProdutosModel.getQuantidade(),
                        ProdutosModel.getPreco())).toList();
    }

    public ProdutosModel salvar (ProdutosRequestDTO requestDTO) {
        if (repository.findByNome(requestDTO.getNome()).isPresent()) {
            throw new RuntimeException("Produto já cadastrado. ❌");
        }

        ProdutosModel novoProduto = new ProdutosModel();
        novoProduto.setNome(requestDTO.getNome());
        novoProduto.setQuantidade(requestDTO.getQuantidade());
        novoProduto.setPreco(requestDTO.getPreco());

        return repository.save(novoProduto);

    }

    public ProdutosModel atualizar (Long id, ProdutosRequestDTO requestDTO){
        ProdutosModel novoProduto = repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Cadastro de cliente não localizado. 🔎❌"));

        repository.findByNome(requestDTO.getNome()).ifPresent(clienteModel -> {
            if (!clienteModel.getId().equals(id)) {
                throw new RuntimeException("Produto já cadastrado.❌");
            }
        });
        novoProduto.setNome(requestDTO.getNome());
        novoProduto.setQuantidade(requestDTO.getQuantidade());
        novoProduto.setPreco(requestDTO.getPreco());


        return  repository.save(novoProduto);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Cadastro de cliente não localizado.🔎❌");
        }
        repository.deleteById(id);
    }


}
