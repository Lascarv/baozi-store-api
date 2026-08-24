package com.github.lascarv.baozistoreapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.lascarv.baozistoreapi.model.Pedido;
import com.github.lascarv.baozistoreapi.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public Pedido salvar(@RequestBody Pedido pedido) {
		return pedidoService.salvar(pedido);
	}
	
	@GetMapping("/{id}")
	public Optional<Pedido> listarPorId(@PathVariable Long id){
		return pedidoService.listarPorId(id);
	}
	
	public List<Pedido> listarTodos(){
		return pedidoService.listarTodos();
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		pedidoService.remover(id);
	}
	
	@PutMapping("/{id}")
	public Pedido atualizar(@PathVariable Long id, @RequestBody Pedido pedido) {
		return pedidoService.atualizar(id, pedido);
	}
}
