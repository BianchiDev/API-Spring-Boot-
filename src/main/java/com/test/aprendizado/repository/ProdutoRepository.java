package com.test.aprendizado.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.aprendizado.model.Produto;

import jakarta.persistence.Entity;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
    
}
