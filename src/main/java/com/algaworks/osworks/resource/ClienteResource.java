package com.algaworks.osworks.resource;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.algaworks.osworks.domain.Cliente;
import com.algaworks.osworks.repositories.ClienteRepository;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

	@Autowired
	private ClienteRepository repository;
	
	@GetMapping
	public List<Cliente> listar(){
		return repository.findAll();
	}
	
	@GetMapping(value="/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Optional<Cliente> findById(@PathVariable Long id) {
		return repository.findById(id);
		
	}
	
	@GetMapping(value = "/nome/{nome}")
	@ResponseStatus(HttpStatus.OK)
	public List<Cliente> findByNome(@PathVariable String nome){
		return repository.findByNome(nome);
	}
	
	@GetMapping(value = "/email")
	@ResponseStatus(HttpStatus.OK)
	public List<Cliente> findByEmail(@RequestParam(value="value") String email){
		return repository.findByEmailContaining(email);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> insert(@Valid Cliente cliente){
		cliente.setId(null);
		repository.save(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@PatchMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Cliente> update(@Valid Cliente cliente){
		cliente.setId(cliente.getId());
		repository.saveAndFlush(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@DeleteMapping(value ="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		if(!repository.existsById(id)) {
			return ResponseEntity.notFound().build();
		}
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
		
}
