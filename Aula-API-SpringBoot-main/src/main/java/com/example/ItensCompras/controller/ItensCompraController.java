package com.example.ItensCompras.controller;

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

import com.example.ItensCompras.model.ItensComprasModel;
import com.example.ItensCompras.servicer.ItensComprasServicer;

@RestController
@RequestMapping ("/api/itensCompras")
public class ItensCompraController{
    @Autowired
    private ItensComprasServicer service;

    @GetMapping
    public List <ItensComprasModel> listarTodos(){
        return service.listarTodos();
    }

    @GetMapping ("/{id}")
    public ResponseEntity <ItensComprasModel> buscarPorId(@PathVariable Long id){
        return service.buscarPorID(id)
            .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping
    public ItensComprasModel salvarItens(@RequestBody ItensComprasModel itens){
        return service.salvatItens(itens);
    }
    @PutMapping ("/{id}")
    public ResponseEntity <ItensComprasModel> atualizarItens(@PathVariable Long id, @RequestBody ItensComprasModel itens){
        if(!service.buscarPorID(id).isPresent()){
            return ResponseEntity.notFound().build();
        }
        ItensComprasModel idItens = new ItensComprasModel();
        idItens.setId(id);

        return ResponseEntity.ok(service.salvatItens(itens));
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity <Void> deletar (@PathVariable Long id){
        if(!service.buscarPorID(id).isPresent()){
            return ResponseEntity .notFound().build();
        }
        service.deletarItens(id);
        return ResponseEntity.noContent().build();
    }
}
