package com.example.CadastroProdutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CadastroProdutos.model.ProdutosModel;

@Repository
public interface ProdutosRepository extends JpaRepository<ProdutosModel, Long>  {
}
