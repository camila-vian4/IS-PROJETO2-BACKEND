package com.example.helpdesk.service;

import com.example.helpdesk.dto.ClienteRequestDTO;
import com.example.helpdesk.dto.ClienteResponseDTO;
import com.example.helpdesk.model.ClienteModel;
import com.example.helpdesk.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public List<ClienteResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(ClienteModel -> new ClienteResponseDTO(ClienteModel.getNome(),
                        ClienteModel.getTelefone())).toList();
    }

    public ClienteModel salvarCliente(ClienteRequestDTO requestDTO) {
        if (repository.findByEmail(requestDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Cliente já cadastrado. ❌");
        }

        ClienteModel novoCliente = new ClienteModel();
        novoCliente.setNome(requestDTO.getNome());
        novoCliente.setEmail(requestDTO.getEmail());
        novoCliente.setTelefone(requestDTO.getTelefone());

        return repository.save(novoCliente);
    }

    public ClienteModel atualizarCliente (Long id, ClienteRequestDTO requestDTO){
        ClienteModel novoCliente = repository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Cadastro de cliente não localizado. 🔎❌"));

        repository.findByEmail(requestDTO.getEmail()).ifPresent(clienteModel -> {
            if (!clienteModel.getId().equals(id)) {
                throw new RuntimeException("Cliente já cadastrado.❌");
            }
        });
        novoCliente.setNome(requestDTO.getNome());
        novoCliente.setEmail(requestDTO.getEmail());
        novoCliente.setTelefone(requestDTO.getTelefone());

        return  repository.save(novoCliente);
    }

    public void deletarCliente(Long id){
        if (!repository.existsById(id)) {
            throw new RuntimeException("Cadastro de cliente não localizado.🔎❌");
        }
        repository.deleteById(id);
    }


}