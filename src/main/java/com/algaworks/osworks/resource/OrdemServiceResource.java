package com.algaworks.osworks.resource;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.osworks.DTO.OrdemServicoDTO;
import com.algaworks.osworks.DTO.OrdemServicoInsertDTO;
import com.algaworks.osworks.domain.OrdemServico;
import com.algaworks.osworks.service.OrdemServicoService;

@RestController
@RequestMapping(value= "/ordens-servico")
public class OrdemServiceResource {

	@Autowired
	private OrdemServicoService service;
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody @Valid OrdemServico ordemServico) {
		ordemServico = service.criar(ordemServico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ordemServico.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	
//	@RequestMapping(value="/DTO", method = RequestMethod.POST)
//	public ResponseEntity<Void> insertModel(@RequestBody @Valid OrdemServicoInsertDTO ordemServicoInsert) {
//		ordemServicoInsert = service.criar(ordemServicoInsert);
//		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(ordemServico.getClass()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<OrdemServico>> findAll(){
		List<OrdemServico> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/DTO", method = RequestMethod.GET)
	public ResponseEntity<List<OrdemServicoDTO>> findAllModel(){
		List<OrdemServicoDTO> list = service.findAllModel();
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<OrdemServico> findById(@PathVariable Long id){
		OrdemServico obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	//Model Mapper
	@RequestMapping(value="/DTO/{id}", method = RequestMethod.GET)
	public ResponseEntity<OrdemServicoDTO> findByIdMapper(@PathVariable Long id){
		OrdemServicoDTO obj = service.findByIdModel(id);
		return ResponseEntity.ok().body(obj);
	}
	
}

