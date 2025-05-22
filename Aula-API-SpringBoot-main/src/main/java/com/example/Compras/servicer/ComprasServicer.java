package com.example.Compras.servicer;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Compras.model.ComprasModel;
import com.example.Compras.repository.ComprasRepository;

@Service
public class ComprasServicer {
      @Autowired
    private ComprasRepository repository;

    public List<ComprasModel> listarTodos(){
        return repository.findAll();
    }
    public Optional <ComprasModel> buscarPorId(Long id){
        return repository.findById(id);
    }

    public ComprasModel salvarCompras(ComprasModel compras){
        return repository.save(compras);
    }
    
    public void deletarCompras(Long id){
        repository.deleteById(id);
    }
}
