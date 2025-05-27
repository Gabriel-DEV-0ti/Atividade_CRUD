package com.example.Compras.controller;

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

import com.example.Compras.model.ComprasModel;
import com.example.Compras.servicer.ComprasServicer;

@RestController
@RequestMapping ("/api/compras")
public class ComprasController {
    @Autowired
    private ComprasServicer service;

    @GetMapping
    public List<ComprasModel> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity <ComprasModel> buscarPorId(@PathVariable Long id){
        return service.buscarPorId(id)
            .map(ResponseEntity::ok)    
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ComprasModel salvarCompras (@RequestBody ComprasModel compras){
        return service.salvarCompras(compras);
    }

    @PutMapping ("/{id}")
    public ResponseEntity <ComprasModel> atualizar (@PathVariable Long id, @RequestBody ComprasModel compras){
        if(!service.buscarPorId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        ComprasModel compra = new ComprasModel();
        compra.setId_compra(id);

    return ResponseEntity.ok(service.salvarCompras(compras));
    } 

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deletar (@PathVariable Long id){
        if(!service.buscarPorId(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        service.deletarCompras(id);
        return ResponseEntity.noContent().build();
    }
}
