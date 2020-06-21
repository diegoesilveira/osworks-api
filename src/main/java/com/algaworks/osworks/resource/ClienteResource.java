package com.algaworks.osworks.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.osworks.domain.Cliente;
import com.algaworks.osworks.service.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> cliente = service.findByAll();
		return ResponseEntity.ok().body(cliente);
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<Cliente> findById(@PathVariable Long id){
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
		
		
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody @Valid Cliente cliente) {
		cliente = service.insert(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cliente.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

//	@PatchMapping
//	@ResponseStatus(HttpStatus.OK)
//	public ResponseEntity<Cliente> update(@Valid Cliente cliente){
//		cliente.setId(cliente.getId());
//		repository.saveAndFlush(cliente);
//		return ResponseEntity.ok(cliente);
//	}
//	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
		
}
