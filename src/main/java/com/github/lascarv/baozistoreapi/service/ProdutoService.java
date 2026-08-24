package com.github.lascarv.baozistoreapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.lascarv.baozistoreapi.model.Produto;
import com.github.lascarv.baozistoreapi.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto salvar(Produto produto) { 
		return produtoRepository.save(produto);
	}
	
	public List<Produto> listarTodos(){
		return produtoRepository.findAll();
	}
	
	public Optional<Produto> listarPorId(Long id){
		return produtoRepository.findById(id);
	}
	
	public Produto atualizar(Long id, Produto produto) {
		
		Produto produtoExistente = produtoRepository.findById(id).orElse(null);
		
		if(produtoExistente != null) {
			produtoExistente.setNome(produto.getNome());
			produtoExistente.setEstoque(produto.getEstoque());
			produtoExistente.setPreco(produto.getPreco());
		
			return produtoRepository.save(produtoExistente);
		}
		
		return null;
	}
	
	public void remover(Long id) {
		produtoRepository.deleteById(id);
	}
}
