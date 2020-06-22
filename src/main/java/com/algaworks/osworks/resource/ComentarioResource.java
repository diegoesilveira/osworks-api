package com.algaworks.osworks.resource;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.algaworks.osworks.DTO.ComentarioInsertDTO;
import com.algaworks.osworks.service.OrdemServicoService;

@RestController
@RequestMapping("/orderns-servico/{ordemServicoId}/comentarios")
public class ComentarioResource {
	
	@Autowired
	private OrdemServicoService service;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ComentarioInsertDTO> insert(@PathVariable Long ordemServicoId, @Valid @RequestBody ComentarioInsertDTO comentarioInsertDTO) {
		service.adicionarComentario(ordemServicoId, comentarioInsertDTO.getDescricao());
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comentarioInsertDTO.getDescricao()).toUri();
		return ResponseEntity.created(uri).build();
		
	}

}
