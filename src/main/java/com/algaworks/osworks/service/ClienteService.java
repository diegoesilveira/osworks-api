package com.algaworks.osworks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.osworks.domain.Cliente;
import com.algaworks.osworks.repositories.ClienteRepository;
import com.algaworks.osworks.service.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public Cliente insert(Cliente cliente) {
		cliente.setId(null);
		return repository.save(cliente);
		
	}
	
	
	public List<Cliente> findByAll(){
		return repository.findAll();
	}
	

	public Cliente findById(Long id) {
		Optional<Cliente>obj = repository.findById(id);
			
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
}
