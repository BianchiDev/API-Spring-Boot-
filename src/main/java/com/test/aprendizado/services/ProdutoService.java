package com.test.aprendizado.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.aprendizado.model.Produto;
import com.test.aprendizado.model.exception.ResourceNotFoundExcpition;
import com.test.aprendizado.repository.ProdutoRepository;
import com.test.aprendizado.shared.ProdutoDTO;

@Service
public class ProdutoService {
    
    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Método para retornar uma lista de produtos.
     * @return Lista de produtos
     */
    public List<ProdutoDTO> obterTodos() {
        // Retorna uma lista de produto model
        List<Produto> produtos = produtoRepository.findAll();
        
        return produtos.stream()
        .map(produto -> new ModelMapper().map(produto, ProdutoDTO.class ))
        .collect(Collectors.toList());

    }

     /**
     * Método que retorna o produto encontrado pelo seu Id.
     * @param id do produto  que será localizado.
     * @return Retorna o produto caso seja encontrado.
     */

    public Optional<ProdutoDTO> obterPorId(Integer id){
     //Obtendo prooduto pelo Id
      Optional<Produto> produto = produtoRepository.findById(id);
     
     // Se não encontrar, lança uma exception
      if(produto.isEmpty()){ // isEmpty verificia se o "Produto" esta vazio.
        throw new ResourceNotFoundExcpition("Produto com id: " + id + " não encontrado");
      }
    // Convertendo meu optional de produto em um produtoDTO.
      ProdutoDTO dto = new ModelMapper().map(produto.get(),ProdutoDTO.class);
     
    // Criando e retornando um optional de produtoDTO.
      return Optional.of(dto);
    }

    /**
     * Método para adicionar Produto na lista.
     * @param produto Produto que será adicionado.
     * @return Retorna o produto que foi adicionado na lista.
     */
    public ProdutoDTO adicionar(ProdutoDTO produtoDto){
        //Poederia ter alguma regra de negócio para validar o produto... 
        produtoDto.setId(produtoDto.getId());

    //Criar um object de mapeamento.
        ModelMapper mapper = new ModelMapper();

    // Converter o nosso ProdutoDTO em Produto
        Produto produto = mapper.map(produtoDto, Produto.class);

    // Salvar o Produto no banco 
        produto = produtoRepository.save(produto);

        produtoDto.setId(produto.getId());
    
    // Retornar o Produto atualizado.
        return  produtoDto;
    }
     /**
     * Método para deletar o produto por ID.
     * @param id do produto a ser deletado.
     * 
     */
    public void deletar(Integer id){ 
        // Verificar se o produto existe
        Optional<Produto> produto = produtoRepository.findById(id);

        if(produto.isEmpty()){// isEmpty verifica se o "produto" existe. Caso ele exista, caso ele não exita, lança uma excption
            throw new ResourceNotFoundExcpition("Produto com id: " + id + " não foi possível excluir" + id + "Produto não existe");
        }
        //Deleta o produto pelo id.
        produtoRepository.deleteById(id);
    }

    public ProdutoDTO atualizar(Integer id, ProdutoDTO produtoDto){
       
        // Passar o  id para o produtoDto
        produtoDto.setId(id);

        //Criar um objeto de mapeamento
        ModelMapper mapper = new ModelMapper();

        //Converter o ProdutoDTO em um Produto
        Produto produto = mapper.map(produtoDto, Produto.class);

        // Atualizar o produto no Banco de dados.
        produtoRepository.save(produto);

        // Retornar o produto no Banco atualizado
        return produtoDto;
    }
}
