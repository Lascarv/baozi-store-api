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

import com.github.lascarv.baozistoreapi.model.Cliente;
import com.github.lascarv.baozistoreapi.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public Cliente salvar(@RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}
	
	@GetMapping("/{id}")
	public Optional<Cliente> buscarPorId(@PathVariable Long id){
		return clienteService.buscarPorId(id);
	}
	
	@GetMapping
	public List<Cliente> listarTodos(){
		return clienteService.listarTodos();
	}
	
	@DeleteMapping("/{id}")
	public void remover(@PathVariable Long id) {
		clienteService.remover(id);
	}
	
	@PutMapping("/{id}")
	public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		return clienteService.atualizar(id, cliente);
	}
}
