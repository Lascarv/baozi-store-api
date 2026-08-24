package com.github.lascarv.baozistoreapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.lascarv.baozistoreapi.model.Pedido;
import com.github.lascarv.baozistoreapi.model.Produto;
import com.github.lascarv.baozistoreapi.repository.ClienteRepository;
import com.github.lascarv.baozistoreapi.repository.PedidoRepository;
import com.github.lascarv.baozistoreapi.repository.ProdutoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	public Pedido salvar(Pedido pedido) {

		if (!clienteRepository.existsById(pedido.getClienteId())) {

			return null;
		}

		Produto produto = produtoRepository.findById(pedido.getProdutoId()).orElse(null);

		if (produto == null) {
			return null;
		}

		if (!Boolean.TRUE.equals(produto.getEstoque())) {
			return null;
		}

		if (pedido.getQuantidade() == null || pedido.getQuantidade() <= 0) {
			return null;
		}
		
		return pedidoRepository.save(pedido);
	}
	
	public List<Pedido> listarTodos(){
		return pedidoRepository.findAll();
	}
	
	public Optional<Pedido> listarPorId(Long id){
		return pedidoRepository.findById(id);
	}
	
	public void remover(Long id) {
		pedidoRepository.deleteById(id);
	}
	public Pedido atualizar(Long id, Pedido pedido) {

	    Pedido pedidoExistente = pedidoRepository.findById(id).orElse(null);

	    if (pedidoExistente == null) {
	        return null;
	    }

	    if (pedido.getClienteId() == null || pedido.getProdutoId() == null) {
	        return null;
	    }

	    if (!clienteRepository.existsById(pedido.getClienteId())) {
	        return null;
	    }

	    Produto produto = produtoRepository
	            .findById(pedido.getProdutoId())
	            .orElse(null);

	    if (produto == null) {
	        return null;
	    }

	    if (!Boolean.TRUE.equals(produto.getEstoque())) {
	        return null;
	    }

	    if (pedido.getQuantidade() == null || pedido.getQuantidade() <= 0) {
	        return null;
	    }

	    pedidoExistente.setClienteId(pedido.getClienteId());
	    pedidoExistente.setProdutoId(pedido.getProdutoId());
	    pedidoExistente.setQuantidade(pedido.getQuantidade());

	    return pedidoRepository.save(pedidoExistente);
	}
}
