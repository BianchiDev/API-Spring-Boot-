package com.test.aprendizado.repository;

import java.util.ArrayList;   
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.test.aprendizado.model.Produto;
import com.test.aprendizado.model.exception.ResourceNotFoundExcpition;

@Repository
public class ProdutoRepository_old {
    
    private List<Produto> produtos = new ArrayList<Produto>();
    private Integer ultimoId = 0;
    
    /**
     * Método para retornar uma lista de produtos.
     * @return  Lista de produtos.
     */
    public List<Produto> obterTodos(){
        return produtos;
    }

    /**
     * Método que retorna o produto encontrado pelo seu Id.
     * @param id do produto  que será localizado.
     * @return Retorna o produto caso seja encontrado.
     */

    public Optional<Produto> obterPorId(Integer id){
         return produtos
         .stream()
         .filter(produtos -> produtos.getId() == id)
         .findFirst();
    }

    /**
     * Método para adicionar Produto na lista.
     * @param produto Produto que será adicionado.
     * @return Retorna o produto que foi adicionado na lista.
     */
    public Produto adicionarProduto(Produto produto){
        
        ultimoId++;
        
        produto.setId(ultimoId);
        produtos.add(produto);
         
        return produto;
    }
    /**
     * Método para deletar o produto por ID.
     * @param id do produto a ser deletado.
     * 
     */
    public void deletar(Integer id){
        produtos.removeIf(produto -> produto.getId() == id);
    }
    
    /**
     * Método para atualizar o produto na lista. 
     * @param produto que será atualizado.
     * @return Retorna o produto após atualizar na lista. 
     */
    public Produto atualizar(Produto produto){
        
        // Encontra o produto na lista pelo Id
        Optional<Produto> produtoEncontrado = obterPorId(produto.getId());

        // Caso não encontre será disparado a menssagem de erro
        if(produtoEncontrado.isEmpty()){ // isEmpty --> condição " se for Vazio"
           // throw new  InputMismatchException("Produto não encontrado");
           throw new ResourceNotFoundExcpition("Produto não encontrado!");
        }
        // Primeiro remove o produda lista para em seguida adicionar o produto atualizado referenciando o mesmo ID
        deletar(produto.getId());
        // Atualizando o produto como o novo produto referenciando o mesmo Id.
         produtos.add(produto);

        return produto;
       }

}