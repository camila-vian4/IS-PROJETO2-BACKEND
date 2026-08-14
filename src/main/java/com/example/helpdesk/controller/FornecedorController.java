package com.example.helpdesk.controller;


import com.example.helpdesk.dto.FornecedorRequestDTO;
import com.example.helpdesk.dto.FornecedorResponseDTO;
import com.example.helpdesk.model.FornecedorModel;
import com.example.helpdesk.service.FornecedorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    //Para facilitar na hora de testar deixo o que cada um faz

    // Get - Lista todos os fornecedores
    @GetMapping
    public ResponseEntity<List<FornecedorResponseDTO>> listarTodos() {
        List<FornecedorResponseDTO> fornecedores = service.listarFornecedores();
        return ResponseEntity.ok(fornecedores);
    }

    // Get - Busca um fornecedor por Id
    @GetMapping("/{id}")
    public ResponseEntity<FornecedorResponseDTO> buscarPorId(@PathVariable Long id){
        FornecedorResponseDTO fornecedor = service.buscarPorId(id);
        return ResponseEntity.ok(fornecedor);
    }

    // Post - Atualiza um fornecedor existente
    @PostMapping
    public ResponseEntity<FornecedorModel> criarFornecedor(@RequestBody @Valid FornecedorRequestDTO dto) {
        FornecedorModel novoFornecedor = service.salvarFornecedor(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoFornecedor);
    }

    // Put - Cria um novo fornecedor
    @PutMapping("/{id}")
    public ResponseEntity<FornecedorResponseDTO> atualizarFornecedor(
            @PathVariable Long id,
            @RequestBody @Valid FornecedorRequestDTO dto) {
        FornecedorResponseDTO fornecedorAtualizado = service.atualizarFornecedor(id, dto); // Mapeado para o método do seu Service
        return ResponseEntity.ok(fornecedorAtualizado);
    }

    // Delete - Deleta um fornecedor por Id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFornecedor (@PathVariable Long id) {
        service.deletarFornecedor(id);
        return ResponseEntity.noContent().build();
    }


}
