package com.example.Compras.servicer;

import com.example.Compras.model.ComprasModel;
import com.example.Compras.repository.ComprasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComprasServicer {
      @Autowired
    private ComprasRepository repository;

    public List<ComprasModel> listarTodos(){
        return repository.findAll();
    }
    public Optional<ComprasModel> buscarPorId(Long id_compra){
        return repository.findById(id_compra);
    }

    public ComprasModel salvarCompras(ComprasModel comprasModel){
        return repository.save(comprasModel);
    }
    
    public void deletarCompras(Long id){
        repository.deleteById(id);
    }
}
