package com.example.CadastroProdutos.servicer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CadastroProdutos.model.ProdutosModel;
import com.example.CadastroProdutos.repository.ProdutosRepository;

@Service
public class ProdutosService {
    @Autowired
    private ProdutosRepository repository;

    public List<ProdutosModel> listarTodos(){
        return repository.findAll();
    }

    public Optional<ProdutosModel> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public ProdutosModel salvarProdutos(ProdutosModel produtosModel) {
        return repository.save(produtosModel);
    }

    public void deletarProdutos(Long id) {
        repository.deleteById(id);
    }
}
