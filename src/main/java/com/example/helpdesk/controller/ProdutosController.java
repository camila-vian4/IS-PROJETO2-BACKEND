package com.example.helpdesk.controller;

import com.example.helpdesk.dto.funcionario.ProdutosRequestDTO;
import com.example.helpdesk.dto.funcionario.ProdutosResponseDTO;
import com.example.helpdesk.service.ProdutosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("produtos")

public class ProdutosController {

    @Autowired
    private ProdutosService service;

    @GetMapping
    public ResponseEntity<List<ProdutosResponseDTO>>  listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listarTodos());

    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> salvarCliente(@Valid @RequestBody ProdutosRequestDTO requestDTO){
        service.salvar(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("Mensagem", "Produto cadastrado com sucesso. ✅"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> atualizarCliente(@PathVariable Long id, @Valid @RequestBody ProdutosRequestDTO requestDTO){
        service.atualizar(id, requestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", "Cadastro atualizado com sucesso. ✅"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletarCliente(@PathVariable Long id){
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("Mensagem", "Cadastro de Produto deletado com sucesso. ✅"));
    }

}
