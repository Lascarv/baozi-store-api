package com.github.lascarv.baozistoreapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.lascarv.baozistoreapi.model.Cliente;
import com.github.lascarv.baozistoreapi.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> buscarPorId(Long id){
		return clienteRepository.findById(id);
	}
	
	public Cliente atualizar(Long id, Cliente cliente) {
		
		Cliente clienteExistente = clienteRepository.findById(id).orElse(null);
		
		if (clienteExistente != null) {
			clienteExistente.setNome(cliente.getNome());
			clienteExistente.setClienteDesde(cliente.getClienteDesde());
			
			return clienteRepository.save(clienteExistente);
		}
		
		return null;
	}
	
	public void remover(Long id) {
		 clienteRepository.deleteById(id);
	}
}
