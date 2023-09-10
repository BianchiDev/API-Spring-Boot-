package com.test.aprendizado.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.test.aprendizado.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
