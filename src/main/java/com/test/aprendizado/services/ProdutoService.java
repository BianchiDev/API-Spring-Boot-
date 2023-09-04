package com.test.aprendizado.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.aprendizado.model.Produto;
import com.test.aprendizado.repository.ProdutoRepository;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Método para retornar uma lista de produtos.
     * @return Lista de produtos
     */
    public List<Produto> obterTodos() {
        // Caso existisse uma regra, ela seria aqui.
        return produtoRepository.obterTodos();
    }

     /**
     * Método que retorna o produto encontrado pelo seu Id.
     * @param id do produto  que será localizado.
     * @return Retorna o produto caso seja encontrado.
     */

    public Optional<Produto> obterPorId(Integer id){
      return produtoRepository.obterPorId(id);
    }

    /**
     * Método para adicionar Produto na lista.
     * @param produto Produto que será adicionado.
     * @return Retorna o produto que foi adicionado na lista.
     */
    public Produto adicionarProduto(Produto produto){
        //Poederia ter alguma regra de negócio para validar o produto...
        return produtoRepository.adicionarProduto(produto);
    }
     /**
     * Método para deletar o produto por ID.
     * @param id do produto a ser deletado.
     * 
     */
    public void deletar(Integer id){ // Sendo void não tem retorno, apenas implicito. 
        // Aqui poderia ter uma lógica de validação  
        produtoRepository.deletar(id);
    }

    public Produto atualizar(Produto produto){
        
        //Poderia ter  uma validação aqui.
        deletar(produto.getId());

        return produtoRepository.atualizar(produto);
       }
}
