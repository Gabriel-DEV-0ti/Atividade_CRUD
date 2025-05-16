package com.example.CadastroProdutos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CadastroProdutos.model.ProdutosModel;
import com.example.CadastroProdutos.servicer.ProdutosService;

@RestController
@RequestMapping("/api/produtos")


public class ProdutosController {
    @Autowired
    private ProdutosService service;

    @GetMapping
    public List<ProdutosModel> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutosModel> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());

    }

     @PostMapping
    public ProdutosModel salvarProdutos(@RequestBody ProdutosModel produtosModel) {
        return service.salvarProdutos(produtosModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutosModel> atualizarProdutos(@PathVariable Long id, @RequestBody ProdutosModel produtosModel) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        produtosModel.setId(id);
        return ResponseEntity.ok(service.salvarProdutos(produtosModel));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProdutos(@PathVariable Long id) {
        if (!service.buscarPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        service.deletarProdutos(id);
        return ResponseEntity.noContent().build();
    }

}
