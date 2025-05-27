package com.example.ItensCompras.servicer;

import com.example.ItensCompras.model.ItensComprasModel;
import com.example.ItensCompras.repository.ItensComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ItensComprasServicer {
    @Autowired
    private ItensComprasRepository repository;

    public List <ItensComprasModel> listarTodos(){
        return repository.findAll();
    }

    public Optional <ItensComprasModel> buscarPorID(Long id){
        return repository.findById(id);
    }

    public ItensComprasModel salvatItens(ItensComprasModel itensComprasModel){
        return repository.save(itensComprasModel);
    }
    
    public void deletarItens(Long id){
        repository.deleteById(id);
    }
}
