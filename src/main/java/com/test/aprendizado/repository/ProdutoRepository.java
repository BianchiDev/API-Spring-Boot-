package com.test.aprendizado.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.aprendizado.model.Produto;

@Repository
public class ProdutoRepository {
    
    private List<Produto> produtos = new ArrayList<>();
    private Integer ultimoId = 0;
    
    public List<Produto> obterTodos(){
        return produtos;
    }
}