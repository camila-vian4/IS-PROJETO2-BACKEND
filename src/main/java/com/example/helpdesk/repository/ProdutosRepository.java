package com.example.helpdesk.repository;


import com.example.helpdesk.model.ProdutosModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutosRepository extends JpaRepository<ProdutosModel, Long> {
    Optional<ProdutosModel> findByNome(String nome);

}
